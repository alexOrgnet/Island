package Plants;

import Animal.Animal;
import Animal.Herbivores.Herbivores;

public class Plant {

    public static int grazed(Animal a){

        if (a.getName() == "Horse") {

            a.setWeight(Math.min((a.getWeight()+2),400));

            return -2;

        }

        return 0;

    }
}
