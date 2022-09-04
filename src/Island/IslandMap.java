package Island;

import Animal.Animal;
import Animal.Carnivores.*;
import Animal.Herbivores.*;
import FarmBuilder.Farm;
import Plants.Plant;
import Techno.Event;
import Techno.Params;
import Techno.Stats;

import java.util.ArrayList;
import java.util.List;

public class IslandMap {

    static List<Animal>[][] karta = new ArrayList[Params.x][Params.y];

    public static List<Animal>[][] getKarta() {
        return (List<Animal>[][]) karta;
    }


    public int number_of_life_cycles;

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
                Plant.plants[x][y] = Plant.max_count_per_cell;

            }
        }
    }

    public void plant_growing() {

        for (int x = 0; x < Params.x; x++) {

            for (int y = 0; y < Params.y; y++) {

                //заполняем растениями, 10 растений на ячейку
                // добавляем траву. трава растет до масксимально допустимого количества растений в одной ячейке
                //трава умножается в два раза за один цикл
                if (Plant.plants[x][y] < Plant.max_count_per_cell) {
                    Plant.plants[x][y] = Math.min(Plant.plants[x][y] * 2, Plant.max_count_per_cell - Plant.plants[x][y]);
                }
            }
        }
    }

    public void animal_creation() {

        //готовим список для животных
        List<Animal> list_animals = new ArrayList<>();

        for (int i = 0; i < Wolf.max_count_per_cell; i++) {

            Animal wolf1 = Farm.Buy("Волк", 5, 5);
            if (wolf1 != null) list_animals.add(wolf1);
        }

        for (int i = 0; i < Horse.max_count_per_cell; i++) {

            Animal horse = Farm.Buy("Лошадь", 5, 5);
            if (horse != null) list_animals.add(horse);

        }

        for (int i = 0; i < Bear.max_count_per_cell; i++) {

            Animal bear = Farm.Buy("Медведь", 5, 5);
            if (bear != null) list_animals.add(bear);

        }


        for (int i = 0; i < Deer.max_count_per_cell; i++) {

            Animal deer = Farm.Buy("Олень", 5, 5);
            if (deer != null) list_animals.add(deer);

        }

        for (int i = 0; i < Python.max_count_per_cell; i++) {

            Animal python = Farm.Buy("Удав", 5, 5);
            if (python != null) list_animals.add(python);

        }

        for (int i = 0; i < Fox.max_count_per_cell; i++) {

            Animal fox = Farm.Buy("Лиса", 5, 5);
            if (fox != null) list_animals.add(fox);

        }

        for (int i = 0; i < Bull.max_count_per_cell; i++) {

            Animal bull = Farm.Buy("Бык", 5, 5);
            if (bull != null) list_animals.add(bull);

        }

        for (int i = 0; i < Boar.max_count_per_cell; i++) {

            Animal boar = Farm.Buy("Кабан", 5, 5);
            if (boar != null) list_animals.add(boar);

        }

        for (int i = 0; i < Goat.max_count_per_cell; i++) {

            Animal goat = Farm.Buy("Козел", 5, 5);
            if (goat != null) list_animals.add(goat);

        }

        for (int i = 0; i < Sheep.max_count_per_cell; i++) {

            Animal sheep = Farm.Buy("Овца", 5, 5);
            if (sheep != null) list_animals.add(sheep);

        }

        for (int i = 0; i < Rabbit.max_count_per_cell; i++) {

            Animal rabbit = Farm.Buy("Кролик", 5, 5);
            if (rabbit != null) list_animals.add(rabbit);

        }

        for (int i = 0; i < Mice.max_count_per_cell; i++) {

            Animal mice = Farm.Buy("Мышь", 5, 5);
            if (mice != null) list_animals.add(mice);

        }

        for (int i = 0; i < Eagle.max_count_per_cell; i++) {

            Animal eagle = Farm.Buy("Орел", 5, 5);
            if (eagle != null) list_animals.add(eagle);

        }

        for (int i = 0; i < Duck.max_count_per_cell; i++) {

            Animal duck = Farm.Buy("Утка", 5, 5);
            if (duck != null) list_animals.add(duck);

        }

        for (int i = 0; i < Caterpillar.max_count_per_cell; i++) {

            Animal cat = Farm.Buy("Гусеница", 5, 5);
            if (cat != null) list_animals.add(cat);

        }

        karta[5][5] = list_animals;//первичное размещение животных в единой ячейке

    }


    public void pastures() {

        //первый процесс внутри ячейки острова. Пастбища
        for (int x = 0; x < Params.x; x++) {
            for (int y = 0; y < Params.y; y++) {


                try {

                    List<Animal> copy1 = new ArrayList<>();
                    copy1.addAll(karta[x][y]);


                    List<Animal> copy2 = new ArrayList<>();
                    copy2.addAll(karta[x][y]);


                    //второй процесс внутри ячейки острова. Питание травоядных
                    for (Animal a : copy1) {

                        if (!a.getAlive()) continue;//пропускаем мертвое животное

                        if (a.getCarnivore()) continue;//пропускаем плотоядное животное

                        //if (a.getSatiety() == 10) continue;//пропускаем сытое животное

                        if (a.getSatiety() >= Params.getFullsatiety()) continue; //животное сытое и только что поело

                        a.eat();//травоядное животное пощипало травку
                        //plants[x][y] = plants[x][y] + Plant.grazed(a);

                    }
                } catch (NullPointerException e) {
                    //e.printStackTrace();
                }
            }
        }
    }

    public void hunting() {
        //второй процесс внутри ячейки острова. Питание хищников
        for (int x = 0; x < Params.x; x++) {
            for (int y = 0; y < Params.y; y++) {


                try {

                    List<Animal> copy1 = new ArrayList<>();
                    copy1.addAll(karta[x][y]);


                    List<Animal> copy2 = new ArrayList<>();
                    copy2.addAll(karta[x][y]);

                    //второй процесс внутри ячейки острова. Питание травоядных
                    for (Animal a : copy1) {

                        if (!a.getAlive()) continue;//пропускаем мертвое животное

                        if (!a.getCarnivore() && a.getName() != "Утка") continue;//пропускаем травоядное животное

                        if (a.isBaby()) continue;//пропускаем детеныша животного, который пока не умеет охотиться

                        //if (a.getSatiety() > Params.getFullsatiety())
                         //   continue; //пропускаем охоту если хищник сыт или только что поел

                        if (a.getSatiety() >= a.getMax_satiety())
                            //животное сытое и только что поело
                            continue;//пропускаем сытое животное

                        for (Animal b : copy2) {

                            if (!b.getAlive()) continue;//пропускаем мертвое животное

                            if (b.getCarnivore()) continue;//пропускаем хищное животное

                            if (a.equals(b)) {
                                //пропускаем так как оба объекта одинаковые
                            } else {

                                if (a.getCarnivore() && !b.getCarnivore()) {


                                    if (Event.probability_to_be_eaten(a, b)) {
                                        //вероятность с какой хищник может съесть другое животное
                                        a.devour(b);//хищник съел травоядное
                                        karta[x][y].remove(b);//удаляем съеденное животное из карты острова

                                        break;

                                    }
                                } else if (a.getName()=="Утка" && a.getName()=="Гусеница")  {


                                    if (Event.probability_to_be_eaten(a, b)) {
                                        //вероятность с какой хищник может съесть другое животное
                                        a.devour(b);//хищник съел травоядное
                                        karta[x][y].remove(b);//удаляем съеденное животное из карты острова

                                        break;

                                    }
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
        for (int x = 0; x < Params.x; x++) {
            for (int y = 0; y < Params.y; y++) {

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

                                if (a.getName() == b.getName()) {

                                    if (!b.isReadytosex()) continue;

                                    if (!a.isReadytosex()) continue;

                                    if (a.getSatiety()<=0) continue; //животное голодное, не может размножаться
                                    if (b.getSatiety()<=0) continue; //животное голодное, не может размножаться

                                    int number_children = Event.rnd(a.getMin_child(), a.getMax_child());

                                    for (int i = 0; i < number_children; i++) {
                                        Animal baby = a.reproduce(a, b);
                                        if (baby != null) {
                                            a.setReadytosex(false);
                                            b.setReadytosex(false);
                                            if (!karta[x][y].contains(baby)) {
                                                karta[x][y].add(baby);
                                            }
                                        }
                                    }

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


    public void moving_to_next_cell() {
        //передвигаем животных на новую клетку
        for (int x = 0; x < Params.x; x++) {
            for (int y = 0; y < Params.y; y++) {


                try {

                    List<Animal> copy1 = new ArrayList<>();
                    copy1.addAll(karta[x][y]);

                    for (Animal a : copy1) {

                        //System.out.println(a.toString());

                        if (!a.getAlive()) {
                            //пропускаем мертвое животное
                            //continue;
                        } else {

                            if (a.isCompleted_turn()) continue;//если животное уже закончило действия в данном цикле жизни, то пропускаем ход

                            if (a.getSatiety() <= 0) continue; //животное умерло от голода

                            if (a != null) {
                                a.move();
                                if (!karta[a.getX()][a.getY()].contains(a)) {
                                    karta[a.getX()][a.getY()].add(a); //добавляем животное в новую локацию если его там не было
                                }
                                karta[x][y].remove(a);//убираем животное из старой локации
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
        for (int x = 0; x < Params.x; x++) {
            for (int y = 0; y < Params.y; y++) {


                Plant.plants[x][y] = Math.min(Plant.max_count_per_cell, Plant.plants[x][y] * Plant.plantGrowingSpeed); //максимальное значение растений на одну ячейку

                try {

                    List<Animal> copy1 = new ArrayList<>();
                    copy1.addAll(karta[x][y]);

                    for (Animal a : copy1) {

                        //System.out.println(a.toString());

                        if (!a.getAlive()) {
                            //пропускаем мертвое животное
                            //continue;
                            a.remove_if_dead(x, y);
                            karta[x][y].remove(a);//убираем животное из старой локации

                        } else {

                            if (a.getSatiety() <= 0) {
                                a.setAlive(false);
                                //пропускаем мертвое животное
                                //continue;
                                a.remove_if_dead(x, y);
                                karta[x][y].remove(a);//убираем животное из старой локации
                                continue;
                            }
                            ; //если животное голодное и не ело, то оно умирает

                            a.setAge(1); //животное прожило еще 1 год
                            a.setBaby(false); //уже не детеныш на следующем цикле
                            a.setHadlunch(false); //пока не было еды на следующем цикле
                            a.setReadytosex(true); //животное готово к спариванию на следующем цикле
                            a.setCompleted_turn(false); //животное готово к движению в следующем цикле
                            a.hunger(); //животное проголодалось

                        }
                    }
                } catch (NullPointerException e) {
                    //e.printStackTrace();
                }
            }
        }
    }
}
