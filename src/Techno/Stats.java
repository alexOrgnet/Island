package Techno;
import Animal.Animal;
import java.util.List;

public class Stats {

    private static class SingletonHolder {
        public static final Stats HOLDER_INSTANCE = new Stats();
    }

    public static Stats getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }
    public static String showStatistic(List<Animal>[][] island){



        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {


                try {

                    for (Animal a : island[x][y]) {

                        System.out.println("В данной части острова "+x+":"+y+" найден " + a.getName()+" с возрастом "+ a.getAge());}

                } catch (NullPointerException e) {
                        //e.printStackTrace();
                    }
            }
        }

        return "nothing found";
    }
}