package Animal.Carnivores;
import Animal.Animal;
import FarmBuilder.Farm;
import Techno.Event;
import Techno.Params;


public class Bear extends Carnivores {

    public String name = "Медведь";
    public static int max_count_per_cell = 5; //максимальное количество животных в ячейке

    public static int weight = 50; //вес животного

    public static int total_number; //общее количество животных данного вида

    public int min_child = 1; //минимальное количество детенышей
    public int max_child = 2;//максимальное количество детенышей.

    public static int max_satiety = 10; //maximum allowed satiety

    public int satiety; //if 0 the animal is dead

    public static int[][] count_in_cell = new int[Params.x][Params.y];
    public Bear(String name, int x, int y, boolean atbirth) {
        super(name, x, y, atbirth);
        this.name = name;
        this.x = x;
        this.y = y;
        this.carnivore = true;
        this.satiety = 3;
        this.baby = atbirth;
        this.readytosex = !atbirth;

        total_number += 1;

        this.min_child = 1;
        this.max_child = 2;

        //Wolf.count_in_cell[this.x][this.y] =  Wolf.count_in_cell[this.x][this.y] + 1;

    }

    public int getMin_child() {
        return this.min_child;
    }

    public int getMax_child() {
        return this.max_child;
    }


    public boolean getCarnivore() {
        return this.carnivore;
    }

    @Override
    public Animal reproduce(Animal mom, Animal dad) {


        Bear animal = (Bear) Farm.Birth("Медведь", mom, dad);

        return animal;

    }

    @Override
    public String toString() {
        return "Медведь {" +
                "name='" + this.name + '\'' +
                ", hash='" + this.hashCode() + '\'' +
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


            this.setHadlunch(true);
            another_animal.setAlive(false);
            another_animal.remove_if_dead(this.x, this.y);

            this.satiety = Math.min((this.satiety + 1), Bear.max_satiety);
            this.setHadlunch(true);

            System.out.println("Медведь " + this.hashCode() + " съел " + another_animal.getName() + " " + another_animal.hashCode() + " в локации x = " + this.x + ", y = " + this.y);


    }

    @Override
    public void move() {

        int step_for_x = Event.rnd(1, 2);
        int step_for_y = Event.rnd(1, 2);

        Bear.count_in_cell[this.x][this.y] = Bear.count_in_cell[this.x][this.y] - 1; //меняем статистику по количеству животного данного вида в ячейке острова

        this.make_shift(step_for_x, step_for_y);

        //Wolf.count_in_cell[step_for_x][step_for_y] = Wolf.count_in_cell[step_for_x][step_for_y] + 1; //меняем статистику по количеству животного данного вида в ячейке острова
        Bear.count_in_cell[this.x][this.y] = Bear.count_in_cell[this.x][this.y] + 1; //меняем статистику по количеству животного данного вида в ячейке острова

        System.out.println("Медведь " + this.hashCode() + " переместился в другую ячейку x = " + this.x + ", y = " + this.y);

    }


    public void remove_if_dad(int x, int y) {

        total_number = total_number - 1;

        Bear.count_in_cell[x][y] = Bear.count_in_cell[x][y] - 1;

        System.out.println("Погиб медведь " + this.hashCode() + " в ячейке x = " + this.x + ", y = " + this.y);
    }

}
