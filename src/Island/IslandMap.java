package Island;
import Animal.Animal;
import FarmBuilder.Farm;
import Plants.Plant;
import Techno.Params;

import java.util.ArrayList;
import java.util.List;

public class IslandMap {

    static List<Animal>[][] karta = new ArrayList[10][10];

    public static List<Animal>[][] getKarta() {
        return (List<Animal>[][]) karta;
    }


    public static int[][] plants = new int[10][10];


    public IslandMap() {
    }

    private static class SingletonHolder {
        public static final IslandMap HOLDER_INSTANCE = new IslandMap();
    }

    public static IslandMap getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }

    public void island_initialization() {


        for (int x = 0; x < 10; x++) {

            for (int y = 0; y < 10; y++) {

                //создаем пустые списки для каждой ячейки острова
                List<Animal> empty_animal_List = new ArrayList<>();

                karta[x][y] = empty_animal_List;
            }
        }
    }

    public void plant_initialization() {

        for (int x = 0; x < 10; x++) {

            for (int y = 0; y < 10; y++) {

                //заполняем растениями, 10 растений на ячейку
                plants[x][y] = 10;

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


                    //добавляем траву. трава растет и увеличивается в два раза за один цикл
                    plants[x][y] = plants[x][y] * 2;


                    //второй процесс внутри ячейки острова. Питание травоядных
                    for (Animal a : copy1) {

                        if (!a.getAlive()) continue;//пропускаем мертвое животное

                        if (a.getCarnivore()) continue;//пропускаем плотоядное животное

                        if (a.getSatiety() == 10) continue;//пропускаем сытое животное

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

                                    if (a.getSatiety() > Params.getFullsatiety())
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
}
