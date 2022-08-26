package Animal.Herbivores;

import Animal.Animal;
import Animal.Herbivores.Herbivores;

public class Horse extends Herbivores {
    public Horse(String name, int x, int y) {
        super();
        this.name = name;
        this.satiety = satiety*2;
        this.carnivore = false;
    }

    @Override
    public void eat(Animal another_animal) {


    }
}
