package Techno;

import Animal.Animal;

import java.util.ArrayList;
import java.util.List;

public class Cleansing {


        private static class SingletonHolder {
            public static final Techno.Cleansing HOLDER_INSTANCE = new Techno.Cleansing();
        }

        public static Cleansing getInstance() {
            return Techno.Cleansing.SingletonHolder.HOLDER_INSTANCE;
        }

        public String cleanStaff(List<Animal>[][] island){



            for (int x = 0; x < 10; x++) {
                for (int y = 0; y < 10; y++) {

                    List<Animal> copy1 = new ArrayList<>();
                    copy1.addAll(island[x][y]);

                    try {

                        //for (Animal a : island[x][y]) {
                        for (Animal a : copy1) {

                            if (!a.alive) System.out.println("Cleaning: В данной части острова "+x+":"+y+" найдено мертвое животное " + a.getName()+" с возрастом "+ a.getAge());
                            else if (a.alive) System.out.println("Cleaning: В данной части острова "+x+":"+y+" найдено живое животное " + a.getName()+" с возрастом "+ a.getAge());
                    }
                    } catch (NullPointerException e) {
                        //e.printStackTrace();
                    }
                }
            }

            return "nothing found";
        }


}
