package FarmBuilder;

import Animal.*;
import Animal.Carnivores.*;
import Animal.Herbivores.*;


public final class Farm {

    public static Animal Birth(String clsType, Animal mom, Animal dad) {


        if (clsType == "Animal") {
            return new Animal("Animal", mom.getX(), mom.getY(), true);

        } else if (clsType == "Волк") {
            if (Wolf.count_in_cell[mom.getX()][mom.getY()] >= Wolf.max_count_per_cell) {
                //System.out.println("Достигнуто максимальное число " + Wolf.class + " в ячейке X " + mom.getX() + ":" + mom.getY());
            } else {
                Wolf.count_in_cell[mom.getX()][mom.getY()] = Wolf.count_in_cell[mom.getX()][mom.getY()] + 1;
                //System.out.println("Родился новый волчонок в локации x = " + mom.getX() + ", y = " + mom.getY());
                return new Wolf("Волк", mom.getX(), mom.getY(), true);
            }
        } else if (clsType == "Лошадь") {
            if (Horse.count_in_cell[mom.getX()][mom.getY()] >= Horse.max_count_per_cell) {
                //System.out.println("Достигнуто максимальное число " + Horse.class + " в ячейке X " + mom.getX() + ":" + mom.getY());
            } else {
                Horse.count_in_cell[mom.getX()][mom.getY()] = Horse.count_in_cell[mom.getX()][mom.getY()] + 1;
                //System.out.println("Родился новый жеребенок в локации x = " + mom.getX() + ", y = " + mom.getY());
                return new Horse("Лошадь", mom.getX(), mom.getY(), true);
            }
        } else if (clsType == "Медведь") {
            if (Bear.count_in_cell[mom.getX()][mom.getY()] >= Bear.max_count_per_cell) {
                //System.out.println("Достигнуто максимальное число " + Bear.class + " в ячейке X " + mom.getX() + ":" + mom.getY());
            } else {
                Bear.count_in_cell[mom.getX()][mom.getY()] = Bear.count_in_cell[mom.getX()][mom.getY()] + 1;
                //System.out.println("Родился новый медвежонок в локации x = " + mom.getX() + ", y = " + mom.getY());
                return new Bear("Медведь", mom.getX(), mom.getY(), true);
            }
        } else if (clsType == "Олень") {
            if (Deer.count_in_cell[mom.getX()][mom.getY()] >= Deer.max_count_per_cell) {
                //System.out.println("Достигнуто максимальное число " + Deer.class + " в ячейке X " + mom.getX() + ":" + mom.getY());
            } else {
                Deer.count_in_cell[mom.getX()][mom.getY()] = Deer.count_in_cell[mom.getX()][mom.getY()] + 1;
                //System.out.println("Родился новый олененок в локации x = " + mom.getX() + ", y = " + mom.getY());
                return new Deer("Олень", mom.getX(), mom.getY(), true);
            }
        } else if (clsType == "Лиса") {
            if (Fox.count_in_cell[mom.getX()][mom.getY()] >= Fox.max_count_per_cell) {
                //System.out.println("Достигнуто максимальное число " + Fox.class + " в ячейке X " + mom.getX() + ":" + mom.getY());
            } else {
                Fox.count_in_cell[mom.getX()][mom.getY()] = Fox.count_in_cell[mom.getX()][mom.getY()] + 1;
                //System.out.println("Родился новый лисенок в локации x = " + mom.getX() + ", y = " + mom.getY());
                return new Fox("Лиса", mom.getX(), mom.getY(), true);
            }
        } else if (clsType == "Питон") {
            if (Python.count_in_cell[mom.getX()][mom.getY()] >= Python.max_count_per_cell) {
                //System.out.println("Достигнуто максимальное число " + Python.class + " в ячейке X " + mom.getX() + ":" + mom.getY());
            } else {
                Python.count_in_cell[mom.getX()][mom.getY()] = Python.count_in_cell[mom.getX()][mom.getY()] + 1;
                //System.out.println("Родился новый удавчик в локации x = " + mom.getX() + ", y = " + mom.getY());
                return new Python("Питон", mom.getX(), mom.getY(), true);
            }
        } else if (clsType == "Кабан") {
            if (Boar.count_in_cell[mom.getX()][mom.getY()] >= Boar.max_count_per_cell) {
                //System.out.println("Достигнуто максимальное число " + Boar.class + " в ячейке X " + mom.getX() + ":" + mom.getY());
            } else {
                Boar.count_in_cell[mom.getX()][mom.getY()] = Boar.count_in_cell[mom.getX()][mom.getY()] + 1;
                //System.out.println("Родился новый кабанчик в локации x = " + mom.getX() + ", y = " + mom.getY());
                return new Boar("Кабан", mom.getX(), mom.getY(), true);
            }
        } else if (clsType == "Бык") {
            if (Bull.count_in_cell[mom.getX()][mom.getY()] >= Bull.max_count_per_cell) {
                //System.out.println("Достигнуто максимальное число " + Bull.class + " в ячейке X " + mom.getX() + ":" + mom.getY());
            } else {
                Bull.count_in_cell[mom.getX()][mom.getY()] = Bull.count_in_cell[mom.getX()][mom.getY()] + 1;
                //System.out.println("Родился новый бычок в локации x = " + mom.getX() + ", y = " + mom.getY());
                return new Bull("Бык", mom.getX(), mom.getY(), true);
            }
        } else if (clsType == "Овца") {
            if (Sheep.count_in_cell[mom.getX()][mom.getY()] >= Sheep.max_count_per_cell) {
                //System.out.println("Достигнуто максимальное число " + Sheep.class + " в ячейке X " + mom.getX() + ":" + mom.getY());
            } else {
                Sheep.count_in_cell[mom.getX()][mom.getY()] = Sheep.count_in_cell[mom.getX()][mom.getY()] + 1;
                //System.out.println("Родился новая овечка в локации x = " + mom.getX() + ", y = " + mom.getY());
                return new Sheep("Овца", mom.getX(), mom.getY(), true);
            }
        } else if (clsType == "Козел") {
            if (Goat.count_in_cell[mom.getX()][mom.getY()] >= Goat.max_count_per_cell) {
                //System.out.println("Достигнуто максимальное число " + Goat.class + " в ячейке X " + mom.getX() + ":" + mom.getY());
            } else {
                Goat.count_in_cell[mom.getX()][mom.getY()] = Goat.count_in_cell[mom.getX()][mom.getY()] + 1;
                //System.out.println("Родился новый козленок в локации x = " + mom.getX() + ", y = " + mom.getY());
                return new Goat("Козел", mom.getX(), mom.getY(), true);
            }
        } else if (clsType == "Кролик") {
            if (Rabbit.count_in_cell[mom.getX()][mom.getY()] >= Rabbit.max_count_per_cell) {
                //System.out.println("Достигнуто максимальное число " + Goat.class + " в ячейке X " + mom.getX() + ":" + mom.getY());
            } else {
                Rabbit.count_in_cell[mom.getX()][mom.getY()] = Rabbit.count_in_cell[mom.getX()][mom.getY()] + 1;
                //System.out.println("Родился новый крольчонок в локации x = " + mom.getX() + ", y = " + mom.getY());
                return new Rabbit("Кролик", mom.getX(), mom.getY(), true);
            }
        } else if (clsType == "Мышь") {
            if (Mice.count_in_cell[mom.getX()][mom.getY()] >= Mice.max_count_per_cell) {
                //System.out.println("Достигнуто максимальное число " + Goat.class + " в ячейке X " + mom.getX() + ":" + mom.getY());
            } else {
                Mice.count_in_cell[mom.getX()][mom.getY()] = Mice.count_in_cell[mom.getX()][mom.getY()] + 1;
                //System.out.println("Родился новый мышонок в локации x = " + mom.getX() + ", y = " + mom.getY());
                return new Mice("Мышь", mom.getX(), mom.getY(), true);
            }
        } else if (clsType == "Орел") {
            if (Eagle.count_in_cell[mom.getX()][mom.getY()] >= Eagle.max_count_per_cell) {
                //System.out.println("Достигнуто максимальное число " + Goat.class + " в ячейке X " + mom.getX() + ":" + mom.getY());
            } else {
                Eagle.count_in_cell[mom.getX()][mom.getY()] = Eagle.count_in_cell[mom.getX()][mom.getY()] + 1;
                //System.out.println("Родился новый орленок в локации x = " + mom.getX() + ", y = " + mom.getY());
                return new Eagle("Орел", mom.getX(), mom.getY(), true);
            }
        } else if (clsType == "Утка") {
            if (Duck.count_in_cell[mom.getX()][mom.getY()] >= Duck.max_count_per_cell) {
                //System.out.println("Достигнуто максимальное число " + Duck.class + " в ячейке X " + mom.getX() + ":" + mom.getY());
            } else {
                Duck.count_in_cell[mom.getX()][mom.getY()] = Duck.count_in_cell[mom.getX()][mom.getY()] + 1;
                //System.out.println("Родился новый утенок в локации x = " + mom.getX() + ", y = " + mom.getY());
                return new Duck("Утка", mom.getX(), mom.getY(), true);
            }
        } else if (clsType == "Гусеница") {
            if (Caterpillar.count_in_cell[mom.getX()][mom.getY()] >= Caterpillar.max_count_per_cell) {
                //System.out.println("Достигнуто максимальное число " + Duck.class + " в ячейке X " + mom.getX() + ":" + mom.getY());
            } else {
                Caterpillar.count_in_cell[mom.getX()][mom.getY()] = Caterpillar.count_in_cell[mom.getX()][mom.getY()] + 1;
                //System.out.println("Родился новая гусеница в локации x = " + mom.getX() + ", y = " + mom.getY());
                return new Caterpillar("Гусеница", mom.getX(), mom.getY(), true);
            }
        }

        return null;
    }


    public static Animal Buy(String clsType, int x, int y) {

        if (clsType == "Animal") {
            return new Animal("Animal", x, y, false);
        } else if (clsType == "Волк") {
            if (Wolf.count_in_cell[x][y] >= Wolf.max_count_per_cell) {
                //System.out.println("Достигнуто максимальное число волков в ячейке X: " + x + ", Y:" + y);
            } else {
                Wolf.count_in_cell[x][y] = Wolf.count_in_cell[x][y] + 1;
                return new Wolf("Волк", x, y, false);
            }
        } else if (clsType == "Лошадь") {
            if (Horse.count_in_cell[x][y] >= Horse.max_count_per_cell) {
                //System.out.println("Достигнуто максимальное число лошадей в ячейке X: " + x + ", Y:" + y);
            } else {
                Horse.count_in_cell[x][y] = Horse.count_in_cell[x][y] + 1;
                return new Horse("Лошадь", x, y, true);
            }
        } else if (clsType == "Медведь") {
            if (Bear.count_in_cell[x][y] >= Bear.max_count_per_cell) {
                //System.out.println("Достигнуто максимальное число медведей в ячейке X: " + x + ", Y:" + y);
            } else {
                Bear.count_in_cell[x][y] = Bear.count_in_cell[x][y] + 1;
                return new Bear("Медведь", x, y, true);
            }
        } else if (clsType == "Олень") {
            if (Deer.count_in_cell[x][y] >= Deer.max_count_per_cell) {
                //System.out.println("Достигнуто максимальное число оленей в ячейке X: " + x + ", Y:" + y);
            } else {
                Deer.count_in_cell[x][y] = Deer.count_in_cell[x][y] + 1;
                return new Deer("Олень", x, y, true);
            }
        } else if (clsType == "Лиса") {
            if (Fox.count_in_cell[x][y] >= Fox.max_count_per_cell) {
                //System.out.println("Достигнуто максимальное число лис в ячейке X: " + x + ", Y:" + y);
            } else {
                Fox.count_in_cell[x][y] = Fox.count_in_cell[x][y] + 1;
                return new Fox("Лиса", x, y, true);
            }
        } else if (clsType == "Удав") {
            if (Python.count_in_cell[x][y] >= Python.max_count_per_cell) {
                //System.out.println("Достигнуто максимальное число удавов в ячейке X: " + x + ", Y:" + y);
            } else {
                Python.count_in_cell[x][y] = Python.count_in_cell[x][y] + 1;
                return new Python("Удав", x, y, true);
            }
        } else if (clsType == "Кабан") {
            if (Boar.count_in_cell[x][y] >= Boar.max_count_per_cell) {
                //System.out.println("Достигнуто максимальное число кабанов в ячейке X: " + x + ", Y:" + y);
            } else {
                Boar.count_in_cell[x][y] = Boar.count_in_cell[x][y] + 1;
                return new Boar("Кабан", x, y, true);
            }
        } else if (clsType == "Бык") {
            if (Bull.count_in_cell[x][y] >= Bull.max_count_per_cell) {
                //System.out.println("Достигнуто максимальное число быков в ячейке X: " + x + ", Y:" + y);
            } else {
                Bull.count_in_cell[x][y] = Bull.count_in_cell[x][y] + 1;
                return new Bull("Бык", x, y, true);
            }
        } else if (clsType == "Овца") {
            if (Sheep.count_in_cell[x][y] >= Sheep.max_count_per_cell) {
                //System.out.println("Достигнуто максимальное число овец в ячейке X: " + x + ", Y:" + y);
            } else {
                Sheep.count_in_cell[x][y] = Sheep.count_in_cell[x][y] + 1;
                return new Sheep("Овца", x, y, true);
            }
        } else if (clsType == "Козел") {
            if (Goat.count_in_cell[x][y] >= Goat.max_count_per_cell) {
                //System.out.println("Достигнуто максимальное число коз в ячейке X: " + x + ", Y:" + y);
            } else {
                Goat.count_in_cell[x][y] = Goat.count_in_cell[x][y] + 1;
                return new Goat("Козел", x, y, true);
            }
        } else if (clsType == "Кролик") {
            if (Rabbit.count_in_cell[x][y] >= Rabbit.max_count_per_cell) {
                //System.out.println("Достигнуто максимальное число кроликов в ячейке X: " + x + ", Y:" + y);
            } else {
                Rabbit.count_in_cell[x][y] = Rabbit.count_in_cell[x][y] + 1;
                return new Rabbit("Кролик", x, y, true);
            }
        } else if (clsType == "Мышь") {
            if (Mice.count_in_cell[x][y] >= Mice.max_count_per_cell) {
                //System.out.println("Достигнуто максимальное число мышей в ячейке X: " + x + ", Y:" + y);
            } else {
                Mice.count_in_cell[x][y] = Mice.count_in_cell[x][y] + 1;
                return new Mice("Мышь", x, y, true);
            }
        } else if (clsType == "Орел") {
            if (Eagle.count_in_cell[x][y] >= Eagle.max_count_per_cell) {
                //System.out.println("Достигнуто максимальное число орлов в ячейке X: " + x + ", Y:" + y);
            } else {
                Eagle.count_in_cell[x][y] = Eagle.count_in_cell[x][y] + 1;
                return new Eagle("Орел", x, y, true);
            }
        } else if (clsType == "Утка") {
            if (Duck.count_in_cell[x][y] >= Duck.max_count_per_cell) {
                //System.out.println("Достигнуто максимальное число уток в ячейке X: " + x + ", Y:" + y);
            } else {
                Duck.count_in_cell[x][y] = Duck.count_in_cell[x][y] + 1;
                return new Duck("Утка", x, y, true);
            }
        } else if (clsType == "Гусеница") {
            if (Caterpillar.count_in_cell[x][y] >= Caterpillar.max_count_per_cell) {
                //System.out.println("Достигнуто максимальное число гусениц в ячейке X: " + x + ", Y:" + y);
            } else {
                Caterpillar.count_in_cell[x][y] = Caterpillar.count_in_cell[x][y] + 1;
                return new Caterpillar("Гусеница", x, y, true);
            }
        }


        return null;
    }
}

