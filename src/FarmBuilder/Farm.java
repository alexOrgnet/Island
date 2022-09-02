package FarmBuilder;

import Animal.*;
import Animal.Carnivores.Bear;
import Animal.Carnivores.Wolf;
import Animal.Herbivores.Horse;


public final class Farm {

    public static Animal Birth(String clsType, Animal mom, Animal dad) {


        if (clsType == "Animal") {
            return new Animal("Animal", mom.getX(), mom.getY(), true);

        } else if (clsType == "Волк") {
            if (Wolf.count_in_cell[mom.getX()][mom.getY()] >= Wolf.max_count_per_cell) {
                System.out.println("Достигнуто максимальное число " + Wolf.class + " в ячейке X " + mom.getX() + ":" + mom.getY());
            } else {
                Wolf.count_in_cell[mom.getX()][mom.getY()] = Wolf.count_in_cell[mom.getX()][mom.getY()] + 1;
                System.out.println("Родился новый волчонок в локации x = " + mom.getX() + ", y = " + mom.getY());
                return new Wolf("Волк", mom.getX(), mom.getY(), true);
            }

        } else if (clsType == "Лошадь") {
            if (Horse.count_in_cell[mom.getX()][mom.getY()] >= Horse.max_count_per_cell) {
                System.out.println("Достигнуто максимальное число " + Horse.class + " в ячейке X " + mom.getX() + ":" + mom.getY());
            } else {
                Horse.count_in_cell[mom.getX()][mom.getY()] = Horse.count_in_cell[mom.getX()][mom.getY()] + 1;
                System.out.println("Родился новый жеребенок в локации x = " + mom.getX() + ", y = " + mom.getY());
                return new Horse("Лошадь", mom.getX(), mom.getY(), true);
            }
        } else if (clsType == "Медведь") {
            if (Bear.count_in_cell[mom.getX()][mom.getY()] >= Bear.max_count_per_cell) {
                System.out.println("Достигнуто максимальное число " + Bear.class + " в ячейке X " + mom.getX() + ":" + mom.getY());
            } else {
                Bear.count_in_cell[mom.getX()][mom.getY()] = Bear.count_in_cell[mom.getX()][mom.getY()] + 1;
                System.out.println("Родился новый медвежонок в локации x = " + mom.getX() + ", y = " + mom.getY());
                return new Bear("Медведь", mom.getX(), mom.getY(), true);
            }
        }

        return null;
    }

    public static Animal Buy(String clsType, int x, int y) {

        if (clsType == "Animal") {
            return new Animal("Animal", x, y, false);
        } else if (clsType == "Волк") {
            if (Wolf.count_in_cell[x][y] >= Wolf.max_count_per_cell) {
                System.out.println("Достигнуто максимальное число волков в ячейке X: " + x + ", Y:" + y);
            } else {
                Wolf.count_in_cell[x][y] = Wolf.count_in_cell[x][y] + 1;
                return new Wolf("Волк", x, y, false);
            }
        } else if (clsType == "Лошадь") {
            if (Horse.count_in_cell[x][y] >= Horse.max_count_per_cell) {
                System.out.println("Достигнуто максимальное число лошадей в ячейке X: " + x + ", Y:" + y);
            } else {
                Horse.count_in_cell[x][y] = Horse.count_in_cell[x][y] + 1;
                return new Horse("Лошадь", x, y, true);
            }
        } else if (clsType == "Медведь") {
            if (Bear.count_in_cell[x][y] >= Bear.max_count_per_cell) {
                System.out.println("Достигнуто максимальное число медведей в ячейке X: " + x + ", Y:" + y);
            } else {
                Bear.count_in_cell[x][y] = Bear.count_in_cell[x][y] + 1;
                return new Bear("Медведь", x, y, true);
            }
        }
        return null;
    }
}

