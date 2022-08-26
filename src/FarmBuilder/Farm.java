package FarmBuilder;
import Animal.*;
import Animal.Carnivores.Wolf;
import Animal.Herbivores.Horse;
import Techno.Event;


public final class Farm {

    public static Animal Create(String clsType, int x, int y) {

        boolean sex_probability = Event.probability(50);

        if (clsType == "Animal") {
            return new Animal("Animal", x, y);
        }else if (clsType == "Wolf"){
            return new Wolf("Wolf", x, y);
        } else if (clsType == "Horse"){
            return new Horse("Horse", x, y);
        }

        return null;
    }
}
