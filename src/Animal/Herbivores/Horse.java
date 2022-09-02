package Animal.Herbivores;

import Animal.Animal;
import FarmBuilder.Farm;
import Island.IslandMap;
import Techno.Event;

public class Horse extends Herbivores {

    public static int max_count_per_cell = 15; //максимальное количество животных в ячейке

    public static int total_number; //общее количество животных данного вида

    public int min_child = 2; //минимальное количество детенышей
    public int max_child = 4;//максимальное количество детенышей

    public static int max_satiety = 10; //maximum allowed satiety

    public int satiety; //if 0 the animal is dead

    public Horse(String name, int x, int y, boolean atbirth) {
        super();
        this.x = x;
        this.y = y;
        this.name = name;
        this.satiety = 2;
        this.carnivore = false;
        if (atbirth) this.age = 0;
        this.baby = atbirth;
        this.readytosex = false;

        total_number += 1;

        this.min_child = 4;
        this.max_child = 8;

        if (!atbirth) this.setWeight(300); else this.setWeight(50);
    }

    public void setSatiety(int satiety) {
        this.satiety = satiety;
    }
    public int getMin_child() {
        return this.min_child;
    }

    public int getMax_child() {
        return this.max_child;
    }

    public static int getMax_satiety() {
        return max_satiety;
    }

    @Override
    public void eat() {

        super.eat();

        this.satiety = Math.min((this.satiety + 1), Horse.max_satiety);

        this.setHadlunch(true);

        System.out.println("Лошадь пощипала траву в ячейке x = "+this.x+", y = "+this.y);

        IslandMap islandMap = IslandMap.getInstance();

        islandMap.plants[this.x][this.y] = islandMap.plants[this.x][this.y] - 2; //за один цикл лошадь съедает два растения
    }


    @Override
    public Animal reproduce(Animal mom, Animal dad) {

        Horse animal  = (Horse) Farm.Birth("Horse", mom, dad);

        System.out.println("Родился новый жеребенок в ячейке x = "+x+", y = "+y);

        return animal;

    }

    public void remove_if_dead(int x, int y){

        if (!this.getAlive()) total_number = total_number - 1;

        Horse.count_in_cell[x][y] --;

    }

    @Override
    public void move() {

        int step_for_x = Event.rnd(1,3);
        int step_for_y = Event.rnd(1,3);

        this.make_shift(step_for_x, step_for_y);

        System.out.println("Лошадь "+this.hashCode()+" переместилась в другую ячейку: x = " + this.x + ", y = " + this.y);

    }


}
