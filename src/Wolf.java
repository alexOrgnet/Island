public class Wolf extends Carnivores {

    public Wolf(String name, int x, int y) {
        super();
        this.satiety = satiety*3;
        this.carnivore = true;
    }


    @Override
    public Wolf reproduce() {

        Wolf animal  = (Wolf) Farm.Create("Wolf", this.x, this.y);

        System.out.println("Родился новый волчонок");

        return animal;

    }

    @Override
    public void eat(Animal another_animal) {
        super.eat(another_animal);
        System.out.println("Волк съел "+another_animal.getClass());
    }
}
