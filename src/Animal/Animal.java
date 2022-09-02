package Animal;
import Animal.Carnivores.Carnivores;
import FarmBuilder.Farm;
import Techno.Event;
import Techno.Params;

public class Animal {

    public String name = "animal";

    public boolean alive = true;

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    protected int x = 0; //coordinates x
    protected int y = 0; //coordinates y

    protected int age = 0; //number of cycles alive

    int weight = 0; //вес животного
    public int satiety = 0; //if 0 the animal is dead

    public boolean carnivore = false;

    protected boolean male = true;

    protected boolean readytosex = true;

    boolean hadlunch = false;

    protected boolean baby = true;

    public static int max_count_per_cell = 0; //максимальное количество животных в ячейке

    public static int total_number; //общее количество животных данного вида

    public String getName() {
        return name;
    }

    public int min_child = 0;
    public int max_child = 0;

    public static int max_satiety =0; //maximum allowed satiety
    public static int[][] count_in_cell = new int[Params.x][Params.y];

    public Animal(String name, int x, int y, boolean birth) {
        this.name = name;
        this.alive = true;
        this.x = x;
        this.y = y;
        this.age = 0;
        this.satiety = 3;
        this.hadlunch = false; //already ate food
        this.male = Event.probability(50);
        this.readytosex = !birth;
        this.baby = birth;
    }

    public Animal() {

    }

    public int getMin_child() {
        return this.min_child;
    }

    public int getMax_child() {
        return this.max_child;
    }

    public static int getMax_satiety() {
        return max_satiety;
    }

    public boolean getAlive() {
        return this.alive;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Animals{" +
                "name='" + this.name + '\'' +
                //", carnivore='" + this.carnivore + '\'' +
                ", satiety='" + this.satiety + '\'' +
                ", male='" + this.male + '\'' +
                ", alive='" + this.alive + '\'' +
                ", ready to sex='" + this.readytosex + '\'' +
                ", age='" + this.age + '\'' +
                //", type='" + getClass() + '\'' +
                ", location= x=" + this.x + " у ="+this.y+'\'' +
                '}';
    }

    public void move() {

        int step_for_x = 1;
        int step_for_y = 1;

        this.make_shift(step_for_x, step_for_y);

        System.out.println("Энимал переместился в другую ячейку: x = " + x + ", y = " + y);
    }

    public void make_shift(int x, int y) {

        int step_for_x = x;
        int step_for_y = y;

        boolean probability_of_direction_x = Event.probability(50);
        boolean probability_of_direction_y = Event.probability(50);

        //вероятность пойти вправо или лево
        if (probability_of_direction_x == true) {
        } else step_for_x = -1*step_for_x;
        //вероятность пойти вверх или вниз
        if (probability_of_direction_y == true) {
        } else step_for_y = -1*step_for_y;

        //ограничение по оси х в 160 клеток
        if ((this.x + step_for_x + 1) > Params.x) {
            this.x = this.x - step_for_x;
        } else if ((this.x + step_for_x) < 0) {
            this.x = this.x - step_for_x;
        } else this.x = this.x + step_for_x;

        //ограничение по оси у в 20 клеток
        if ((this.y + step_for_y + 1) > Params.y) {
            this.y = this.y - step_for_y;
        } else if ((this.y + step_for_y) < 0) {
            this.y = this.y - step_for_y;
        } else this.y = this.y + step_for_y;

    }

    public void eat() {


    }

    public Animal reproduce(Animal mom, Animal dad) {

        Animal animal  = Farm.Birth("Animals", mom, dad);
        this.readytosex = false;

        System.out.println("Родился энимал в локации у родителей "+mom+" и "+dad);

        return animal;

    }

    public boolean getCarnivore() {

        return this.carnivore;
    }

    public void devour(Animal a) {
    }

    public int getSatiety() {
        return this.satiety;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = this.age+age;
    }

    public boolean isAlive() {
        return alive;
    }


    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isMale() {
        return male;
    }

    public boolean isReadytosex() {
        return readytosex;
    }

    public boolean isHadlunch() {
        return hadlunch;
    }

    public boolean isBaby() {
        return baby;
    }

    public void setReadytosex(boolean readytosex) {
        this.readytosex = readytosex;
    }

    public void setHadlunch(boolean hadlunch) {
        this.hadlunch = hadlunch;
    }

    public void setBaby(boolean baby) {
        this.baby = baby;
    }

    public void remove_if_dead(int x, int y) {
    }

    public void setSatiety(double v) {
    }

/*    public void check_if_alive(){

        if (!this.getAlive()) total_number = total_number - 1;

    }*/
}
