package Animal.Herbivores;

import Animal.Animal;
import FarmBuilder.Farm;
import Plants.Plant;
import Techno.Event;
import Techno.Params;

public class Duck extends Herbivores {

    public String name = "Утка";

    public boolean completed_turn; //признак завершения хода
    public static int max_count_per_cell = 200; //максимальное количество животных в ячейке

    public static int total_number; //общее количество животных данного вида

    public int weight; //вес животного

    @Override
    public int getWeight() {
        return weight;
    }

    public int min_child; //минимальное количество детенышей
    public int max_child;//максимальное количество детенышей

    public double max_satiety; //maximum allowed satiety

    protected static int speed=4; //speed of the move
    public void setMax_satiety(double max_satiety) {
        this.max_satiety = max_satiety;
    }

    @Override
    public int getFood_stuff_to_full_satiety() {
        return food_stuff_to_full_satiety;
    }
    @Override
    public double getSatiety() {
        return satiety;
    }

    @Override
    public void setSatiety(double satiety) {
        this.satiety = satiety;
    }

    public double satiety; //if 0 the animal is dead

    public static int[][] count_in_cell = new int[Params.x][Params.y];

    public Duck(String name, int x, int y, boolean atbirth) {
        super(name, x, y, atbirth);
        this.x = x;
        this.y = y;
        this.name = name;
        this.satiety = Params.satiety_at_birth;
        this.carnivore = false;
        if (atbirth) this.age = 0;
        this.baby = atbirth;
        this.readytosex = false;
        this.alive = true;

        this.weight = 1; //вес животного

        Duck.total_number += 1;

        this.min_child = 3;
        this.max_child = 6;

        this.max_satiety = Params.getFullsatiety();

        this.food_stuff_to_full_satiety = 1;


        //Duck.count_in_cell[this.x][this.y] =  Duck.count_in_cell[this.x][this.y] + 1;
    }


    public int getMin_child() {
        return this.min_child;
    }

    public int getMax_child() {
        return this.max_child;
    }

    public double getMax_satiety() {
        return this.max_satiety;
    }

    @Override
    public String toString() {
        return "Утка {" +
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

        int how_much_grass_left = Plant.plants[this.getX()][this.getY()];
        double how_much_grass_to_eat_to_full_satiety = this.getFood_stuff_to_full_satiety() - (this.getSatiety() / Params.getFullsatiety() * this.getFood_stuff_to_full_satiety());
        double how_much_grass_to_eat = Math.min(how_much_grass_left,how_much_grass_to_eat_to_full_satiety);

        if (how_much_grass_to_eat > 0) {

            this.setSatiety(this.getSatiety() + (int)how_much_grass_to_eat / this.getFood_stuff_to_full_satiety());

            this.setHadlunch(true);

            //System.out.println("Утка " + this.hashCode() + " пощипала траву в ячейке x = " + this.getX() + ", y = " + this.getY());

            Plant.plants[this.getX()][this.getY()] = Plant.plants[this.getX()][this.getY()] - (int)how_much_grass_to_eat; //

        }
    }



    @Override
    public Animal reproduce(Animal mom, Animal dad) {

        Duck foal = (Duck) Farm.Birth("Утка", mom, dad);

        return foal;

    }

    @Override
    public void remove_if_dead(int x, int y) {

        Duck.total_number = Duck.total_number - 1;

        Duck.count_in_cell[x][y] = Duck.count_in_cell[x][y] - 1;

        //System.out.println("Погибла утка " + this.hashCode() + " в ячейке x = " + this.x + ", y = " + this.y);
    }

    @Override
    public boolean isCompleted_turn() {
        return completed_turn;
    }

    @Override
    public void setCompleted_turn(boolean completed_turn) {
        this.completed_turn = completed_turn;
    }

    public void move() {

        int step_for_x = Event.rnd(1, Duck.speed);
        int step_for_y = Event.rnd(1, Duck.speed);


        Duck.count_in_cell[this.x][this.y] = Duck.count_in_cell[this.x][this.y] - 1; //меняем статистику по количеству животного данного вида в ячейке острова

        this.make_shift(step_for_x, step_for_y);

        Duck.count_in_cell[this.x][this.y] = Duck.count_in_cell[this.x][this.y] + 1;

        //System.out.println("Утка "+this.toString()+"  "  + this.hashCode() + " переместилась в другую ячейку: x = " + this.x + ", y = " + this.y);

        this.completed_turn = true;

    }

    @Override
    public void hunger() {

        this.setSatiety(Math.max((this.getSatiety()-Params.getFullsatiety()/3), 0));

    }


    @Override
    public void devour(Animal another_animal){

        another_animal.setAlive(false);
        another_animal.remove_if_dead(this.x, this.y);

        //this.satiety = Math.min((this.satiety + 1), Wolf.max_satiety);

        double increase_in_satiety = (Math.min(another_animal.getWeight()/this.getFood_stuff_to_full_satiety() * Params.getFullsatiety(), Params.getFullsatiety()));
        this.setSatiety(Math.min((this.getSatiety() + increase_in_satiety), this.getMax_satiety()));
        this.setHadlunch(true);

        //System.out.println("Волк " + this.hashCode() + " съел " + another_animal.getName() + " " + another_animal.hashCode() + " в локации x = " + this.x + ", y = " + this.y);

    };



}
