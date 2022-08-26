import Animal.Animal;
import FarmBuilder.Farm;
import Techno.Params;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        List<Animal> list_animals = new ArrayList<>();

        Animal animal = Farm.Create("Wolf", 10, 10);

        list_animals.add(animal);

        Animal animal2 = Farm.Create("Wolf", 10, 10);

        list_animals.add(animal2);

        Animal animal3 = Farm.Create("Horse", 10, 10);

        list_animals.add(animal3);

        //создаем список ячеек острова
        List<Animal>[][] island = new ArrayList[10][10];

        int[][] plants = new int[10][10];


        //происходит первоначальное заполние острова травой
        for (int x = 0; x < 10; x++) {

            for (int y = 0; y < 10; y++) {

                //заполняем растениями, 10 растений на ячейку
                plants[x][y] = 10;

                //создаем пустые списки для каждой ячейки острова
                List<Animal> empty_animal_List = new ArrayList<>();

                island[x][y] = empty_animal_List;
            }
        }

        //заполняем ячейки списком животных
        island[0][0] = list_animals;


        //задаем параметры игры
        Params params = new Params();
        //запускаем циклы игры
        int cycles = params.getCycles();


        //запускаем жизненный цикл
        for (int i = 0; i < cycles; i++) {

            //теперь смотрим что на острове
            for (int x = 0; x < 10; x++) {
                for (int y = 0; y < 10; y++) {

                    //добавляем траву. трава растет и увеличивается в два раза за один цикл
                    plants[x][y] = plants[x][y] * 2;

                    try {

                        List<Animal> copy1 = new ArrayList<>();
                        copy1.addAll(island[x][y]);

                        List<Animal> copy2 = new ArrayList<>();
                        copy2.addAll(island[x][y]);

                        for (Animal a : copy1) {
                            //System.out.println("coordinates : x ="+i+" y="+y+" "+list1[i][y]);
                                if (!a.getAlive()) continue;
                            for (Animal b : copy2) {

                                if (!b.getAlive()) continue;

                                if (a.equals(b)) {
                                    //пропускаем так как оба объекта одинаковые
                                } else {

                                    if (a.carnivore && !b.carnivore) {

                                        a.eat(b, x, y);//хищник съел травоядное
                                        island[x][y].remove(b);//травоядного больше нет
                                        break;
                                    } else if (!a.getCarnivore() && b.getCarnivore()) {

                                        b.eat(a, x, y);//хищник съел травоядное
                                        island[x][y].remove(a);//травоядного больше нет
                                        break;
                                    } else if (a.name == b.name) {
                                        island[x][y].add(a.reproduce(x, y));
                                        break;
                                    }

                                    System.out.println("objects are not equal " + b.toString());
                                    System.out.println(island[x][y]);
                                }

                            }


                            a.move(x,y);
                            island[x][y].remove(a);


                        }
                    } catch (NullPointerException e) {
                        //e.printStackTrace();
                    }



                }
            }

        }
    }
}