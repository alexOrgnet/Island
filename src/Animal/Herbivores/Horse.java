package Animal.Herbivores;

import Animal.Animal;
import Animal.Carnivores.Wolf;
import Animal.Herbivores.Herbivores;
import FarmBuilder.Farm;

public class Horse extends Herbivores {

    public static int max_count_per_cell = 10; //максимальное количество животных в ячейке

    public static int total_number; //общее количество животных данного вида

    public Horse(String name, int x, int y, boolean atbirth) {
        super();
        this.x = x;
        this.y = y;
        this.name = name;
        this.satiety = satiety*2;
        this.carnivore = false;
        if (atbirth) this.age = 0;
        this.baby = atbirth;

        total_number += 1;

        if (!atbirth) this.setWeight(300); else this.setWeight(50);
    }


    @Override
    public void eat() {

        System.out.println("Лошадь пощипала траву в ячейке x = "+this.x+", y = "+this.y);

    }


    @Override
    public Animal reproduce(Animal mom, Animal dad) {

        Horse animal  = (Horse) Farm.Birth("Horse", mom, dad);

        System.out.println("Родился новый жеребенок в ячейке x = "+x+", y = "+y);

        return animal;

    }

    public void remove_if_dead(){

        if (!this.getAlive()) total_number = total_number - 1;

    }

    @Override
    public void move() {

        int step_for_x = 3;
        int step_for_y = 3;

        this.make_shift(step_for_x, step_for_y);

        System.out.println("Лошадь переместился в другую ячейку: x = " + x + ", y = " + y);

    }


}
