public final class Farm {

    public static Animal Create(String clsType, int x, int y) {

        boolean sex_probability = Event.probability(50);

        if (clsType == "Animal") {
            return new Animal("Animal", x, y);
        }else if (clsType == "Wolf"){
            return new Wolf("Wolf", x, y);
        }

        return null;
    }
}
