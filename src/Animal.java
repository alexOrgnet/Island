public class Animal {

    String name = "animal";

    boolean alive = true;

    int x = 0; //coordinates x
    int y = 0; //coordinates y

    int age = 0; //number of cycles alive

    int weight = 0; //вес животного
    int satiety = 0; //if 0 the animal is dead

    boolean carnivore = false;

    boolean male = true;

    boolean readytosex = true;

    boolean hadlunch = false;

    boolean child = true;

    public Animal(String name, int x, int y) {
        this.name = name;
        this.alive = true;
        this.x = x;
        this.y = y;
        this.age = 0;
        this.satiety = 3;
        this.hadlunch = false; //already ate food
        this.male = Event.probability(50);
        this.readytosex = false;
        this.child = true;
    }

    public Animal() {

    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + this.name + '\'' +
                ", carnivore='" + this.carnivore + '\'' +
                ", satiety='" + this.satiety + '\'' +
                ", male='" + this.male + '\'' +
                ", alive='" + this.alive + '\'' +
                ", ready to sex='" + this.readytosex + '\'' +
                ", age='" + this.age + '\'' +
                //", type='" + getClass() + '\'' +
                ", location= x=" + this.x + " у ="+this.y+'\'' +
                '}';
    }

    public void move(int x, int y, int steps) {

        int step_for_x = steps;
        int step_for_y = steps;

        boolean probability_of_direction_x = Event.probability(50);
        boolean probability_of_direction_y = Event.probability(50);

        //вероятность пойти вправо или лево
        if (probability_of_direction_x == true) {
        } else step_for_x = -1*step_for_x;
        //вероятность пойти вверх или вниз
        if (probability_of_direction_y == true) {
        } else step_for_y = -1*step_for_y;

        //ограничение по оси х в 160 клеток
        if ((x + step_for_x) > 160) {
            this.x = x - step_for_x;
        } else if ((x + step_for_x) < 0) {
            this.x = x - step_for_x;
        } else this.x = x + step_for_x;

        //ограничение по оси у в 20 клеток
        if ((y + step_for_y) > 20) {
            this.y = y - step_for_y;
        } else if ((y + step_for_y) < 0) {
            this.y = y - step_for_y;
        } else this.y = y + step_for_y;

    }

    public void eat(Animal another_animal) {

        this.satiety = this.satiety+1;
        another_animal.satiety = 0;
        another_animal.alive = false;

        System.out.println("Animal съел "+another_animal);

    }

    public Animal reproduce() {

        Animal animal  = Farm.Create("Animal", this.x, this.y);
        this.readytosex = false;

        return animal;

    }

}
