package Animal.Herbivores;

import Animal.Animal;
import Animal.Herbivores.Herbivores;

public class Horse extends Herbivores {
    public Horse(String name, int x, int y, boolean atbirth) {
        super();
        this.x = x;
        this.y = y;
        this.name = name;
        this.satiety = satiety*2;
        this.carnivore = false;
        if (atbirth) this.age = 0;
        this.baby = atbirth;
        this.max_count = 10;

        if (!atbirth) this.setWeight(300); else this.setWeight(50);
    }


    @Override
    public void eat() {

        System.out.println("Лошадь пощипала траву в локации "+this.x+" "+this.y);

    }



}
