package Island;
import Animal.Animal;
import FarmBuilder.Farm;
import Plants.Plant;
import Techno.Params;

import java.util.ArrayList;
import java.util.List;

public class IslandMap {

    static List<Animal>[][] karta = new ArrayList[Params.x][Params.y];

    public static List<Animal>[][] getKarta() {
        return (List<Animal>[][]) karta;
    }


    public static int[][] plants = new int[Params.x][Params.y];

    public static int[][] getPlants() {
        return plants;
    }

    public IslandMap() {
    }

    private static class SingletonHolder {
        public static final IslandMap HOLDER_INSTANCE = new IslandMap();
    }

    public static IslandMap getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }

    public void island_initialization() {


        for (int x = 0; x < Params.x; x++) {

            for (int y = 0; y < Params.y; y++) {

                //создаем пустые списки для каждой ячейки острова
                List<Animal> empty_animal_List = new ArrayList<>();

                karta[x][y] = empty_animal_List;
            }
        }
    }

    public void plant_initialization() {

        for (int x = 0; x < Params.x; x++) {

            for (int y = 0; y < Params.y; y++) {

                //заполняем растениями, 10 растений на ячейку
                plants[x][y] = Params.plants;

            }
        }
    }

    public void plant_growing() {

        for (int x = 0; x < Params.x; x++) {

            for (int y = 0; y < Params.y; y++) {

                //заполняем растениями, 10 растений на ячейку
                // добавляем траву. трава растет до масксимально допустимого количества растений в одной ячейке

                if (plants[x][y] < Params.plants){
                    plants[x][y] = Params.plants;
                }
            }
        }
    }

    public void animal_creation() {


        List<Animal> list_animals = new ArrayList<>();

        Animal animal = Farm.Buy("Wolf", 1, 1);

        list_animals.add(animal);

        Animal animal2 = Farm.Buy("Wolf", 1, 1);

        list_animals.add(animal2);

        Animal animal3 = Farm.Buy("Horse", 1, 1);

        list_animals.add(animal3);

        Animal animal4 = Farm.Buy("Horse", 1, 1);

        list_animals.add(animal4);

        Animal animal5 = Farm.Buy("Horse", 1, 1);

        list_animals.add(animal5);

        Animal animal6 = Farm.Buy("Horse", 1, 1);

        list_animals.add(animal6);


        karta[1][1] = list_animals;

    }


    public void pastures() {

        //первый процесс внутри ячейки острова. Пастбища
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {


                try {

                    List<Animal> copy1 = new ArrayList<>();
                    copy1.addAll(karta[x][y]);


                    List<Animal> copy2 = new ArrayList<>();
                    copy2.addAll(karta[x][y]);


                    //второй процесс внутри ячейки острова. Питание травоядных
                    for (Animal a : copy1) {

                        if (!a.getAlive()) continue;//пропускаем мертвое животное

                        if (a.getCarnivore()) continue;//пропускаем плотоядное животное

                        if (a.getSatiety() == 10) continue;//пропускаем сытое животное

                        if ((a.getSatiety() > Params.getFullsatiety()) || (a.isHadlunch())) continue; //животное сытое и только что поело

                        a.eat();//травоядное животное пощипало травку
                        plants[x][y] = plants[x][y] + Plant.grazed(a);

                    }
                } catch (NullPointerException e) {
                    //e.printStackTrace();
                }
            }
        }
    }

    public void hunting() {
        //второй процесс внутри ячейки острова. Питание хищников
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {


                try {

                    List<Animal> copy1 = new ArrayList<>();
                    copy1.addAll(karta[x][y]);


                    List<Animal> copy2 = new ArrayList<>();
                    copy2.addAll(karta[x][y]);

                    //второй процесс внутри ячейки острова. Питание травоядных
                    for (Animal a : copy1) {

                        if (!a.getAlive()) continue;//пропускаем мертвое животное

                        for (Animal b : copy2) {

                            if (!b.getAlive()) continue;//пропускаем мертвое животное

                            if (a.equals(b)) {
                                //пропускаем так как оба объекта одинаковые
                            } else {

                                if (a.carnivore && !b.carnivore) {

                                    if ((a.getSatiety() > Params.getFullsatiety()) || (a.isHadlunch()))
                                        //животное сытое и тольк что поело
                                        continue;//пропускаем сытое животное

                                    a.devour(a);//хищник съел травоядное

                                    break;
                                }
                            }
                        }
                    }
                } catch (NullPointerException e) {
                    //e.printStackTrace();
                }
            }
        }
    }

    //третий процесс внутри ячейки острова. Размножение животных
    public void breeding() {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {

                try {

                    List<Animal> copy1 = new ArrayList<>();
                    copy1.addAll(karta[x][y]);


                    List<Animal> copy2 = new ArrayList<>();
                    copy2.addAll(karta[x][y]);


                    //добавляем траву. трава растет и увеличивается в два раза за один цикл
                    plants[x][y] = plants[x][y] * 2;


                    //второй процесс внутри ячейки острова. Питание травоядных
                    for (Animal a : copy1) {

                        if (!a.getAlive()) continue;//пропускаем мертвое животное

                        for (Animal b : copy2) {

                            if (!b.getAlive()) continue;//пропускаем мертвое животное

                            if (a.equals(b)) {
                                //пропускаем так как оба объекта одинаковые
                            } else {

                                if (a.name == b.name) {

                                    if (!b.isReadytosex()) continue;

                                    if (!a.isReadytosex()) break;

                                    Animal baby = a.reproduce(a, b);
                                    karta[x][y].add(baby);

                                    break;
                                }
                            }
                        }
                    }
                } catch (NullPointerException e) {
                    //e.printStackTrace();
                }
            }
        }
    }


    public void preparing_next_cycle() {
        //подготавливаем животных к новому циклу
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {

                try {

                    List<Animal> copy1 = new ArrayList<>();
                    copy1.addAll(karta[x][y]);

                    for (Animal a : copy1) {

                        if (!a.getAlive()) {
                            //пропускаем мертвое животное
                            //continue;


                        }else {

                            if (!a.isHadlunch() && a.getSatiety()<=0) {a.setAlive(false); continue;}; //если животное голодное и не ело, то оно умирает
                            a.setAge(1); //животное прожило еще 1 год
                            a.setBaby(false); //уже не детеныш на следующем цикле
                            a.setHadlunch(false); //пока не было еды на следующем цикле
                            a.setReadytosex(true); //животное готово к спариванию на следующем цикле
                            a.setHadlunch(false); //животное готово к приему пищи на следующем цикле

                            //теперь делаем движение для всех животных

                            a.move();

                            karta[a.getX()][a.getY()].add(a); //добавляем животное в новую локацию
                            karta[x][y].remove(a);//убираем животное из старой локации
                        }
                     }
                } catch (NullPointerException e) {
                    //e.printStackTrace();
                }
            }
        }
    }
}
