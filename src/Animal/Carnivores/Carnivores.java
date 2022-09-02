package Animal.Carnivores;
import Animal.Animal;

public abstract class Carnivores extends Animal {

    boolean carnivore=true;

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
    public void devour(Animal another_animal) {

        this.satiety = this.satiety+1;
        this.setHadlunch(true);
        another_animal.satiety = 0;
        another_animal.alive = false;

    }

    @Override
    public void move() {

        int step_for_x = 1;
        int step_for_y = 1;

        this.make_shift(step_for_x, step_for_y);

    }
}
