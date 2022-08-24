public class Wolf extends Carnivores {

    public Wolf(String name, boolean alive, int x, int y, int age, int satiety, boolean carnivore, boolean male, boolean readytosex) {
        super();
        this.name = name;
        this.alive = alive;
        this.x = x;
        this.y = y;
        this.age = age;
        this.satiety = satiety*3;
        this.carnivore = carnivore;
        this.male = male;
        this.male = readytosex;
    }


    @Override
    public Wolf reproduce() {

        Wolf animal  = (Wolf) Farm.Create("Wolf", this.x, this.y, this.carnivore);
        this.readytosex = false;

        return animal;

    }


}
