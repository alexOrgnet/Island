package Animal.Carnivores;

import Animal.Animal;
import FarmBuilder.Farm;
import Techno.Event;
import Techno.Params;


public class Wolf extends Carnivores {

    public static int max_count_per_cell = 10; //максимальное количество животных в ячейке

    public static int total_number; //общее количество животных данного вида

    public Wolf(String name, int x, int y, boolean atbirth) {
        super(name, x, y, atbirth);
        this.name = name;
        this.x = x;
        this.y = y;
        this.carnivore = true;
        this.satiety = satiety * 3;
        this.baby = atbirth;

        total_number += 1;


    }

    public boolean getCarnivore() {
        return this.carnivore;
    }

    @Override
    public Animal reproduce(Animal mom, Animal dad) {


        Wolf animal = (Wolf) Farm.Birth("Wolf", mom, dad);

        System.out.println("Родился новый волчонок в локации x = " + x + ", y = " + y);

        return animal;

    }

    @Override
    public String toString() {
        return "Wolfs{" +
                "name='" + this.name + '\'' +
                ", carnivore='" + this.carnivore + '\'' +
                ", satiety='" + this.satiety + '\'' +
                ", male='" + this.male + '\'' +
                ", alive='" + this.alive + '\'' +
                ", ready to sex='" + this.readytosex + '\'' +
                ", age='" + this.age + '\'' +
                //", type='" + getClass() + '\'' +
                ", location= x=" + this.x + " у =" + this.y + '\'' +
                '}';
    }


    @Override
    public void devour(Animal another_animal) {
        super.devour(another_animal);

        this.satiety = this.satiety + 1;

        System.out.println("Волк съел " + another_animal.getName() + " в локации x = " + this.x + ", y = " + this.y);
    }

    @Override
    public void move() {

        int step_for_x = 3;
        int step_for_y = 3;

        this.make_shift(step_for_x, step_for_y);

        System.out.println("Волк переместился в другую ячейку x = " + x + ", y = " + y);

    }




    public void remove_if_dad(){

        if (!this.getAlive()) total_number = total_number - 1;

    }

}
