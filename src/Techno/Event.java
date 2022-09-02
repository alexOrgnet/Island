package Techno;

import Animal.Animal;

public final class Event {

    public static boolean probability (int probability){

        //probability with which event occurs
        //from 0 to 100
        //max probability 100%

        int p = (int) (Math.random() * 100);
        if (p <= probability) {
            return true;
        } else return false;
    }

    /**
     * Метод получения псевдослучайного целого числа от min до max (включая max);
     */
    public static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    /**
     * Вероятность быть съеденным различными животными;
     */
    public static boolean probability_to_be_eaten (Animal a, Animal b){

        //probability with which event occurs
        //from 0 to 100
        //max probability 100%

        if (a.getName() == "Волк" && b.getName() == "Лошадь"){
            return probability (50);
        }
        if (a.getName() == "Волк" && b.getName() == "Олень"){
            return probability (15);
        }

        return false;
    }
}
