package Techno;

import Animal.Animal;
import Animal.Carnivores.Wolf;
import Animal.Herbivores.Horse;
import Island.IslandMap;

import java.sql.SQLOutput;
import java.util.List;

public class Stats {

    private static class SingletonHolder {
        public static final Stats HOLDER_INSTANCE = new Stats();
    }

    public static Stats getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }

    public void showStatistic(IslandMap o) {
        List<Animal>[][] island;
        island = o.getKarta();

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {


                try {

                    for (Animal a : island[x][y]) {

                        //System.out.println("Статистика: В данной части острова " + x + ":" + y + " найден " + a.getName() + " с возрастом " + a.getAge());
                    }

                } catch (NullPointerException e) {
                    //e.printStackTrace();
                }
            }
        }
        System.out.println("Общее количество волков " + Wolf.total_number);
        System.out.println("Общее количество лошадей " + Horse.total_number);
        System.out.println("Общее количество animal " + Animal.total_number);
    }
}