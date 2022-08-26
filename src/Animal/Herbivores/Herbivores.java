package Animal.Herbivores;
import Animal.Animal;

public abstract class Herbivores extends Animal {

    boolean carnivore=false;


    public abstract void eat(Animal another_animal);

    @Override
    public void move(int x, int y) {
        super.move(x, y);
    }
}
