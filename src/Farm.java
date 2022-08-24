public final class Farm {

    public static Animal Create(String clsType, int x, int y, boolean carnivore) {

        boolean sex_probability = Event.probability(50);

        if (clsType == "Animal") {
            return new Animal("Animal", true, x, y, 0, 3, carnivore, sex_probability,false);
        }else if (clsType == "Wolf"){
            return new Wolf("Wolf", true, x, y, 0, 3, carnivore, sex_probability,false);
        }

        return null;
    }
}
