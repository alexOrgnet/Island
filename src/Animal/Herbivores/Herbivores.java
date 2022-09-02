package Animal.Herbivores;
import Animal.Animal;

public class Herbivores extends Animal {

    boolean carnivore=false;


    public void eat() {

    }

    @Override
    public void move() {
        int step_for_x = 1;
        int step_for_y = 1;

        this.make_shift(step_for_x, step_for_y);

    }
}
