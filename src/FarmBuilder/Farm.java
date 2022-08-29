package FarmBuilder;
import Animal.*;
import Animal.Carnivores.Wolf;
import Animal.Herbivores.Horse;


public final class Farm {

    public static Animal Birth(String clsType, Animal mom, Animal dad) {


        if (clsType == "Animal") {
            return new Animal("Animal", mom.getX(), mom.getY(), true);

        }else if (clsType == "Wolf"){
            if (Wolf.count_in_cell[mom.getX()][mom.getY()] >= Wolf.max_count_per_cell ) {
                System.out.println("Достигнуто максимальное число "+Wolf.class+" в ячейке X "+mom.getX()+ ":"+ mom.getY());
            } else {
                Wolf.count_in_cell[mom.getX()][mom.getY()] ++;
                return new Wolf("Wolf", mom.getX(), mom.getY(), true);
            }

        } else if (clsType == "Horse"){
            if (Horse.count_in_cell[mom.getX()][mom.getY()] >= Horse.max_count_per_cell ) {
                System.out.println("Достигнуто максимальное число " + Horse.class + " в ячейке X " + mom.getX() + ":" + mom.getY());
            } else {
                Horse.count_in_cell[mom.getX()][mom.getY()] ++;
                return new Horse("Horse", mom.getX(), mom.getY(), true);
            }
        }

        return null;
    }

    public static Animal Buy(String clsType, int x, int y) {

        if (clsType == "Animal") {
            return new Animal("Animal", x, y, false);
        }else if (clsType == "Wolf"){
            if (Wolf.count_in_cell[x][y] >= Wolf.max_count_per_cell ) {
                System.out.println("Достигнуто максимальное число "+Wolf.class+" в ячейке X "+x+ ":"+ y);
            } else {
                Wolf.count_in_cell[x][y] ++;
                return new Wolf("Wolf", x, y, false);
            }
        } else if (clsType == "Horse"){
            if (Horse.count_in_cell[x][y] >= Horse.max_count_per_cell ) {
                System.out.println("Достигнуто максимальное число " + Horse.class + " в ячейке X " + x + ":" + y);
            } else {
                Horse.count_in_cell[x][y] ++;
                return new Horse("Horse", x, y, true);
            }
        }

        return null;
    }
}
