package Animal.Carnivores;
import Animal.Animal;
import FarmBuilder.Farm;
import Techno.Event;


public class Wolf extends Carnivores {

    public static int max_count_per_cell = 5; //максимальное количество животных в ячейке

    public static int total_number; //общее количество животных данного вида

    public int min_child = 1; //минимальное количество детенышей
    public int max_child = 2;//максимальное количество детенышей.

    public static int max_satiety = 20; //maximum allowed satiety

    public int satiety; //if 0 the animal is dead

    public Wolf(String name, int x, int y, boolean atbirth) {
        super(name, x, y, atbirth);
        this.name = name;
        this.x = x;
        this.y = y;
        this.carnivore = true;
        this.satiety = 3;
        this.baby = atbirth;
        this.readytosex = false;

        total_number += 1;

        this.min_child = 1;
        this.max_child = 1;

    }

    public int getMin_child() {
        return this.min_child;
    }

    public int getMax_child() {
        return this.max_child;
    }

    public void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    public boolean getCarnivore() {
        return this.carnivore;
    }

    @Override
    public Animal reproduce(Animal mom, Animal dad) {


        Wolf animal = (Wolf) Farm.Birth("Wolf", mom, dad);

        System.out.println("Родился новый волчонок в локации x = " + x + ", y = " + y);

        return animal;

    }

    @Override
    public String toString() {
        return "Wolfs{" +
                "name='" + this.name + '\'' +
                ", carnivore='" + this.carnivore + '\'' +
                ", satiety='" + this.satiety + '\'' +
                ", male='" + this.male + '\'' +
                ", alive='" + this.alive + '\'' +
                ", ready to sex='" + this.readytosex + '\'' +
                ", age='" + this.age + '\'' +
                //", type='" + getClass() + '\'' +
                ", location= x=" + this.x + " у =" + this.y + '\'' +
                '}';
    }


    @Override
    public void devour(Animal another_animal) {
        super.devour(another_animal);

        this.satiety = Math.min((this.satiety + 1), Wolf.max_satiety);
        this.setHadlunch(true);

        System.out.println("Волк съел " + another_animal.getName() + " в локации x = " + this.x + ", y = " + this.y);
    }

    @Override
    public void move() {

        int step_for_x = Event.rnd(1,2);
        int step_for_y = Event.rnd(1,2);

        this.make_shift(step_for_x, step_for_y);

        System.out.println("Волк "+this.hashCode()+" переместился в другую ячейку x = " + this.x + ", y = " + this.y);

    }


    public void remove_if_dad(int x, int y){

        if (!this.getAlive()) total_number = total_number - 1;

        Wolf.count_in_cell[x][y] ++;
    }

}
