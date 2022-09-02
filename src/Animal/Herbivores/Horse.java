package Animal.Herbivores;

import Animal.Animal;
import Animal.Carnivores.Wolf;
import FarmBuilder.Farm;
import Island.IslandMap;
import Techno.Event;
import Techno.Params;

public class Horse extends Herbivores {

    public String name = "Лошадь";
    public static int max_count_per_cell = 40; //максимальное количество животных в ячейке

    public static int total_number; //общее количество животных данного вида

    public static int weight = 400; //вес животного

    public int min_child = 2; //минимальное количество детенышей
    public int max_child = 8;//максимальное количество детенышей

    public static int max_satiety = 10; //maximum allowed satiety

    public int satiety; //if 0 the animal is dead

    public static int[][] count_in_cell = new int[Params.x][Params.y];

    public Horse(String name, int x, int y, boolean atbirth) {
        super(name, x, y, atbirth);
        this.x = x;
        this.y = y;
        this.name = name;
        this.satiety = 2;
        this.carnivore = false;
        if (atbirth) this.age = 0;
        this.baby = atbirth;
        this.readytosex = false;
        this.alive = true;

        Horse.total_number += 1;

        this.min_child = 3;
        this.max_child = 8;

        if (!atbirth) this.setWeight(300); else this.setWeight(50);


        //Horse.count_in_cell[this.x][this.y] =  Horse.count_in_cell[this.x][this.y] + 1;
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
    public String toString() {
        return "Horse{" +
                "name='" + this.name + '\'' +
                ", hash='" + this.hashCode() + '\'' +
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
    public void eat() {

        super.eat();

        this.setSatiety(Math.min((this.satiety + 1), Horse.max_satiety));

        this.setHadlunch(true);

        System.out.println("Лошадь "+this.hashCode()+" пощипала траву в ячейке x = "+this.x+", y = "+this.y);

        IslandMap islandMap = IslandMap.getInstance();

        islandMap.plants[this.x][this.y] = islandMap.plants[this.x][this.y] - 2; //за один цикл лошадь съедает два растения
    }


    @Override
    public Animal reproduce(Animal mom, Animal dad) {

        Horse foal  = (Horse) Farm.Birth("Лошадь", mom, dad);

        return foal;

    }

    public void remove_if_dead(int x, int y){

        total_number = total_number - 1;

        Horse.count_in_cell[x][y] = Horse.count_in_cell[x][y] - 1;

        System.out.println("Погибла лошадь "+this.hashCode()+" в ячейке x = "+this.x+", y = "+this.y);
    }

    @Override
    public void move() {

        int step_for_x = Event.rnd(1,3);
        int step_for_y = Event.rnd(1,3);

        Horse.count_in_cell[this.x][this.y] =  Horse.count_in_cell[this.x][this.y] - 1; //меняем статистику по количеству животного данного вида в ячейке острова

        this.make_shift(step_for_x, step_for_y);

        //Horse.count_in_cell[step_for_x][step_for_y] = Horse.count_in_cell[step_for_x][step_for_y] + 1; //меняем статистику по количеству животного данного вида в ячейке острова
        Horse.count_in_cell[this.x][this.y] =  Horse.count_in_cell[this.x][this.y] + 1;

        System.out.println("Лошадь "+this.hashCode()+" переместилась в другую ячейку: x = " + this.x + ", y = " + this.y);

    }


}
