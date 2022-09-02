package Techno;

import Animal.Animal;
import Animal.Carnivores.Bear;
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

        for (int x = 0; x < Params.x; x++) {
            for (int y = 0; y < Params.y; y++) {


                try {

                    for (Animal a : island[x][y]) {

                        //System.out.println("Статистика: В данной части острова " + x + ":" + y + " найден " + a.getName() + " с возрастом " + a.getAge());
                    }

                } catch (NullPointerException e) {
                    //e.printStackTrace();
                }
            }
        }
        System.out.println("Общее количество волков \uD83D\uDC3A " + Wolf.total_number);
        System.out.println("Общее количество медведей \uD83D\uDC3B " + Bear.total_number);
        System.out.println("Общее количество лощадей \uD83D\uDC0E " + Horse.total_number);

        //System.out.println("Общее количество кроликов \uD83D\uDC07 " + Horse.total_number);
        //System.out.println("Общее количество уток \uD83E\uDD86 " + Horse.total_number);
        //System.out.println("Общее количество змей \uD83D\uDC0D " + Horse.total_number);


        //System.out.println("Общее количество animal " + Animal.total_number);
        //System.out.println("🐺");
    }
}