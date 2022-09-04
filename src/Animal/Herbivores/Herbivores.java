package Animal.Herbivores;

import Animal.Animal;
import Plants.Plant;

public class Herbivores extends Animal {

    boolean carnivore = false;

    public boolean completed_turn;

    protected static int speed; //speed of the move

    @Override
    public boolean isCompleted_turn(){
        return completed_turn;
    }

    @Override
    public void setCompleted_turn(boolean completed_turn) {
        this.completed_turn = completed_turn;
    }


    public int food_stuff_to_full_satiety; //пища необходимая для полного насыщения
    @Override
    public int getFood_stuff_to_full_satiety() {
        return food_stuff_to_full_satiety;
    }
    @Override
    public void eat() {

        if (Plant.plants[this.getX()][this.getY()] > 0) {

            this.setSatiety(Math.min((this.getSatiety() + 10), this.getMax_satiety()));

            this.setHadlunch(true);

            //System.out.println("Лошадь " + this.hashCode() + " пощипала траву в ячейке x = " + this.getX() + ", y = " + this.getY());

            Plant.plants[this.getX()][this.getY()] = Plant.plants[this.getX()][this.getY()] - this.getFood_stuff_to_full_satiety(); //за один цикл лошадь съедает два растения
        }
    }

    public Herbivores(String name, int x, int y, boolean birth) {
        super(name, x, y, birth);
        this.carnivore = true;
    }
}
