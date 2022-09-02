package Animal.Herbivores;
import Animal.Animal;

public class Herbivores extends Animal {

    boolean carnivore=false;


    public void eat() {

    }
    public Herbivores(String name, int x, int y, boolean birth) {
        super(name, x, y, birth);
        this.carnivore = true;
    }
}
