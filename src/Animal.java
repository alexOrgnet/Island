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

    public Animal(String name, boolean alive, int x, int y, int age, int satiety, boolean carnivore, boolean male, boolean readytosex) {
        this.name = name;
        this.alive = alive;
        this.x = x;
        this.y = y;
        this.age = age;
        this.satiety = satiety;
        this.hadlunch = false; //already ate food
        this.carnivore = carnivore;
        this.male = male;
        this.readytosex = readytosex;
    }

    public Animal() {

    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", carnivore='" + carnivore + '\'' +
                ", satiety='" + satiety + '\'' +
                ", male='" + male + '\'' +
                ", alive='" + alive + '\'' +
                ", age='" + age + '\'' +
                ", type='" + getClass() + '\'' +
                ", location= x=" + x + " у ="+y+'\'' +
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


    }

    public Animal reproduce() {

        Animal animal  = Farm.Create("Animal", this.x, this.y, this.carnivore);
        this.readytosex = false;

        return animal;

    }

}
