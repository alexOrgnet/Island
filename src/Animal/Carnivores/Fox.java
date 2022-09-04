package Animal.Carnivores;
import Animal.Animal;
import FarmBuilder.Farm;
import Techno.Event;
import Techno.Params;


public class Fox extends Carnivores {

    public String name = "Лиса";
    public static int max_count_per_cell = 30; //максимальное количество животных в ячейке

    public int weight; //вес животного

    protected static int speed = 2; //speed of the move
    public boolean completed_turn; //признак завершения хода


    public int food_stuff_to_full_satiety; //пища необходимая для полного насыщения

    public int getFood_stuff_to_full_satiety() {
        return food_stuff_to_full_satiety;
    }

    @Override
    public boolean isCompleted_turn() {
        return completed_turn;
    }

    @Override
    public void setCompleted_turn(boolean completed_turn) {
        this.completed_turn = completed_turn;
    }
    public static int total_number; //общее количество животных данного вида

    public int min_child; //минимальное количество детенышей
    public int max_child;//максимальное количество детенышей.

    public static double max_satiety = Params.getFullsatiety(); //maximum allowed satiety

    public double satiety; //if 0 the animal is dead


    public double getMax_satiety() {
        return max_satiety;
    }

    @Override
    public double getSatiety() {
        return satiety;
    }

    @Override
    public void setSatiety(double satiety) {
        this.satiety = satiety;
    }

    public static int[][] count_in_cell = new int[Params.x][Params.y];

    public Fox(String name, int x, int y, boolean born) {
        super(name, x, y, born);
        this.name = name;
        this.weight = 8;
        this.x = x;
        this.y = y;
        this.carnivore = true;
        this.satiety = Params.satiety_at_birth;
        this.baby = born;
        this.readytosex = !born;

        Fox.total_number += 1;

        this.min_child = 3;
        this.max_child = 6;

        this.max_satiety = Params.getFullsatiety();
        this.food_stuff_to_full_satiety = 2;

        //Fox.count_in_cell[this.x][this.y] =  Fox.count_in_cell[this.x][this.y] + 1;

    }

    public int getMin_child() {
        return this.min_child;
    }

    public int getMax_child() {
        return this.max_child;
    }


    public boolean getCarnivore() {
        return this.carnivore;
    }

    @Override
    public Animal reproduce(Animal mom, Animal dad) {


        Fox animal = (Fox) Farm.Birth("Лиса", mom, dad);

        return animal;

    }

    @Override
    public String toString() {
        return "Лиса {" +
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

/*
    @Override
    public void devour(Animal another_animal) {


        another_animal.setAlive(false);
        another_animal.remove_if_dead(this.x, this.y);

        //this.satiety = Math.min((this.satiety + 1), Fox.max_satiety);

        int increase_in_satiety = (Math.min((int)another_animal.getWeight()/this.getFood_stuff_to_full_satiety() * Params.getFullsatiety(), Params.getFullsatiety()));
        this.setSatiety(Math.min((this.getSatiety() + increase_in_satiety), Fox.max_satiety));
        this.setHadlunch(true);

        //System.out.println("Лиса " + this.hashCode() + " съел " + another_animal.getName() + " " + another_animal.hashCode() + " в локации x = " + this.x + ", y = " + this.y);

    }

 */

    @Override
    public void move() {

        int step_for_x = Event.rnd(1, Fox.speed);
        int step_for_y = Event.rnd(1, Fox.speed);


        Fox.count_in_cell[this.x][this.y] = Fox.count_in_cell[this.x][this.y] - 1; //меняем статистику по количеству животного данного вида в ячейке острова

        this.make_shift(step_for_x, step_for_y);

        //Fox.count_in_cell[step_for_x][step_for_y] = Fox.count_in_cell[step_for_x][step_for_y] + 1; //меняем статистику по количеству животного данного вида в ячейке острова
        Fox.count_in_cell[this.x][this.y] = Fox.count_in_cell[this.x][this.y] + 1; //меняем статистику по количеству животного данного вида в ячейке острова

        //System.out.println("Лиса "+this.toString()+"  " + this.hashCode() + " переместился в другую ячейку x = " + this.x + ", y = " + this.y);

        this.completed_turn = true;

    }


    @Override
    public void remove_if_dead(int x, int y) {


        Fox.total_number = Fox.total_number - 1;

        Fox.count_in_cell[x][y] = Fox.count_in_cell[x][y] - 1;

        //System.out.println("Погибла лиса  " + this.toString() + " " + this.hashCode() + " в ячейке x = " + this.x + ", y = " + this.y);
    }


    @Override
    public void hunger() {

        this.setSatiety(Math.max((this.getSatiety()-Params.getFullsatiety()/3), 0));

    }


}
