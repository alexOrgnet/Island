package Animal.Herbivores;

import Animal.Animal;
import Animal.Carnivores.Wolf;
import Animal.Herbivores.Herbivores;
import FarmBuilder.Farm;

public class Horse extends Herbivores {

    public static int max_count_per_cell = 10; //максимальное количество животных в ячейке


    public Horse(String name, int x, int y, boolean atbirth) {
        super();
        this.x = x;
        this.y = y;
        this.name = name;
        this.satiety = satiety*2;
        this.carnivore = false;
        if (atbirth) this.age = 0;
        this.baby = atbirth;


        if (!atbirth) this.setWeight(300); else this.setWeight(50);
    }


    @Override
    public void eat() {

        System.out.println("Лошадь пощипала траву в локации "+this.x+" "+this.y);

    }


    @Override
    public Animal reproduce(Animal mom, Animal dad) {

        Horse animal  = (Horse) Farm.Birth("Horse", mom, dad);

        System.out.println("Родился новый жеребенок в локации "+x+" "+y);

        return animal;

    }


}
