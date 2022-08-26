package Animal.Carnivores;
import Animal.Animal;

public abstract class Carnivores extends Animal {

    boolean carnivore=true;

    public void eat(Animal another_animal, int x, int y) {

        this.satiety = this.satiety+1;
        another_animal.satiety = 0;
        another_animal.alive = false;

    }

    @Override
    public Carnivores reproduce(int x, int y) {
        return (Carnivores) super.reproduce(x, y);
    }


    @Override
    public void move(int x, int y) {
        super.move(x, y);
    }
}
