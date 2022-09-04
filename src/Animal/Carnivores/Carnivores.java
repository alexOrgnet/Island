package Animal.Carnivores;

import Animal.Animal;
import Techno.Params;

public class Carnivores extends Animal {

    public boolean completed_turn;
    boolean carnivore = true;

    public double getMax_satiety() {
        return max_satiety;
    }

    public int food_stuff_to_full_satiety;

    protected static int speed; //speed of the move

    @Override
    public boolean isCompleted_turn() {
        return completed_turn;
    }

    @Override
    public void setCompleted_turn(boolean completed_turn) {
        this.completed_turn = completed_turn;
    }
    public boolean isCarnivore() {
        return carnivore;
    }

    public Carnivores(String name, int x, int y, boolean birth) {
        super(name, x, y, birth);
        this.carnivore = true;
    }

    public Animal reproduce(Animal mom, Animal dad) {
        return super.reproduce(mom, dad);
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

    @Override
    public void move() {

        int step_for_x = 1;
        int step_for_y = 1;

        this.make_shift(step_for_x, step_for_y);

    }

    public void remove_if_dead(int x, int y){

    };
}
