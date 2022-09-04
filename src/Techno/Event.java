package Techno;

import Animal.Animal;

public final class Event {

    public static boolean probability(int probability) {

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
    public static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    /**
     * Вероятность быть съеденным различными животными;
     */
    public static boolean probability_to_be_eaten(Animal a, Animal b) {

        //probability with which event occurs
        //from 0 to 100
        //max probability 100%

        if (a.getName() == "Волк" && b.getName() == "Лошадь") {
            return probability(10);
        }
        if (a.getName() == "Волк" && b.getName() == "Олень") {
            return probability(15);
        }
        if (a.getName() == "Волк" && b.getName() == "Козел") {
            return probability(60);
        }
        if (a.getName() == "Волк" && b.getName() == "Овца") {
            return probability(70);
        }
        if (a.getName() == "Волк" && b.getName() == "Бык") {
            return probability(10);
        }
        if (a.getName() == "Волк" && b.getName() == "Кабан") {
            return probability(15);
        }


        if (a.getName() == "Медведь" && b.getName() == "Лошадь") {
            return probability(40);
        }
        if (a.getName() == "Медведь" && b.getName() == "Олень") {
            return probability(80);
        }
        if (a.getName() == "Медведь" && b.getName() == "Козел") {
            return probability(70);
        }
        if (a.getName() == "Медведь" && b.getName() == "Овца") {
            return probability(70);
        }
        if (a.getName() == "Медведь" && b.getName() == "Бык") {
            return probability(20);
        }
        if (a.getName() == "Медведь" && b.getName() == "Кабан") {
            return probability(50);
        }


        if (a.getName() == "Лиса" && b.getName() == "Кролик") {
            return probability(70);
        }
        if (a.getName() == "Лиса" && b.getName() == "Мышь") {
            return probability(90);
        }
        if (a.getName() == "Лиса" && b.getName() == "Утка") {
            return probability(60);
        }
        if (a.getName() == "Лиса" && b.getName() == "Гусеница") {
            return probability(40);
        }


        if (a.getName() == "Удав" && b.getName() == "Кролик") {
            return probability(20);
        }
        if (a.getName() == "Удав" && b.getName() == "Мышь") {
            return probability(40);
        }
        if (a.getName() == "Удав" && b.getName() == "Утка") {
            return probability(10);
        }



        if (a.getName() == "Орел" && b.getName() == "Кролик") {
            return probability(90);
        }
        if (a.getName() == "Орел" && b.getName() == "Мышь") {
            return probability(90);
        }
        if (a.getName() == "Орел" && b.getName() == "Утка") {
            return probability(80);
        }


        if (a.getName() == "Утка" && b.getName() == "Гусеница") {
            return probability(90);
        }
        return false;
    }
}
