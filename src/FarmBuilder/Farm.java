package FarmBuilder;
import Animal.*;
import Animal.Carnivores.Wolf;
import Animal.Herbivores.Horse;
import Techno.Event;


public final class Farm {

    public static Animal Birth(String clsType, Animal mom, Animal dad) {

        boolean sex_probability = Event.probability(50);

        if (clsType == "Animal") {
            return new Animal("Animal", mom.getX(), mom.getY(), true);
        }else if (clsType == "Wolf"){
            return new Wolf("Wolf", mom.getX(), mom.getY(), true);
        } else if (clsType == "Horse"){
            return new Horse("Horse", mom.getX(), mom.getY(), true);
        }

        return null;
    }

    public static Animal Buy(String clsType, int x, int у) {

        boolean sex_probability = Event.probability(50);

        if (clsType == "Animal") {
            return new Animal("Animal", x, у, false);
        }else if (clsType == "Wolf"){
            return new Wolf("Wolf", x, у, false);
        } else if (clsType == "Horse"){
            return new Horse("Horse", x, у, false);
        }

        return null;
    }
}
