import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        int cycles = 10;

        List<Animal> list_animals = new ArrayList<>();

        Animal animal  = Farm.Create("Animal", 10, 10);

        animal.move(100,10,2);

        list_animals.add( animal);

        Animal animal2  = Farm.Create("Wolf", 10, 10);

        animal2.move(100,10,1);

        list_animals.add(animal2);


        //System.out.println(" probability "+Event.probability(50));


/*        List[][] list1 = new ArrayList[100][20];

        List<ArrayList> cohort = new ArrayList<>();

        cohort.add((ArrayList) list_animals);


        List<ArrayList> cohort = new ArrayList<>();

        cohort.add((ArrayList) list_animals);

*/
        List<Animal>[][] island = new ArrayList[10][10];

        //сначала заполняем остров
        for (int x = 0; x < 10; x++) {

            for (int y = 0; y < 10; y++) {

                //добавляем растительность
                System.out.println("x= "+x+" у= "+y);
             }
        }

        island[0][0] = list_animals;

        //теперь смотрим что на острове
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {

                try {


                    List<Animal> copy1 = new ArrayList<>();
                    copy1.addAll(island[x][y]);

                    List<Animal> copy2 = new ArrayList<>();
                    copy2.addAll(island[x][y]);

                    for (Animal a : copy1) {
                        //System.out.println("coordinates : x ="+i+" y="+y+" "+list1[i][y]);
                        for (Animal b : copy2) {
                            if (a.equals(b)){
                                System.out.println("objects are equal "+b.toString());
                            }else {

                                if (a.carnivore==true && b.carnivore==false){

                                    a.eat(b);//хищник съел травоядное
                                    island[x][y].remove(b);//травоядного больше нет
                                    break;
                                }else if (a.name == b.name) {
                                    island[x][y].add(a.reproduce());
                                    break;
                                }

                                System.out.println("objects are not equal "+b.toString());
                                System.out.println(island[x][y]);
                            }

                        }
                    }
                } catch (NullPointerException e){}
            }
        }
    }
}
