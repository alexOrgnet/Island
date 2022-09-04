package Techno;

import Animal.Animal;
import Animal.Carnivores.*;
import Animal.Herbivores.*;
import Island.IslandMap;

import java.util.Arrays;
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
        System.out.println("Общее количество лисиц \uD83E\uDD8A " + Fox.total_number);
        System.out.println("Общее количество питонов \uD83D\uDC0D " + Python.total_number);
        System.out.println("Общее количество орлов \uD83E\uDD85 " + Eagle.total_number);

        System.out.println("Общее количество лощадей \uD83D\uDC0E " + Horse.total_number);
        System.out.println("Общее количество оленей \uD83E\uDD99 " + Deer.total_number);

        System.out.println("Общее количество кабанов \uD83D\uDC16 " + Boar.total_number);
        System.out.println("Общее количество быков \uD83D\uDC03 " + Bull.total_number);
        System.out.println("Общее количество коз \uD83D\uDC10 " + Goat.total_number);
        System.out.println("Общее количество овец \uD83D\uDC11 " + Sheep.total_number);
        System.out.println("Общее количество кроликов \uD83D\uDC07 " + Rabbit.total_number);
        System.out.println("Общее количество мышей \uD83D\uDC01 " + Mice.total_number);
        System.out.println("Общее количество уток \uD83E\uDD86 " + Duck.total_number);
        System.out.println("Общее количество гусениц \uD83D\uDC1B " + Caterpillar.total_number);

    }

    public static int totalAnimalQuanity() {

        int[] myArray = new int[12];

        myArray[0] = Horse.total_number;
        myArray[1] = Wolf.total_number;
        myArray[2] = Bear.total_number;
        myArray[3] = Fox.total_number;
        myArray[4] = Deer.total_number;
        myArray[5] = Python.total_number;
        myArray[6] = Boar.total_number;
        myArray[7] = Bull.total_number;

        myArray[8] = Goat.total_number;
        myArray[9] = Sheep.total_number;
        myArray[10] = Rabbit.total_number;
        myArray[11] = Mice.total_number;


        int total = Arrays.stream(myArray).sum();

        return total;
    }
}
