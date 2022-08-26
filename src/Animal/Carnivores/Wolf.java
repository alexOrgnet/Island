package Animal.Carnivores;
import Animal.Animal;
import FarmBuilder.Farm;
import Techno.Event;


public class Wolf extends Carnivores {

        Boolean carnivore = true;

        public Wolf(String name, int x, int y) {
            super();
            this.name = name;
            this.carnivore = true;
            this.satiety = satiety*3;
        }

    public boolean getCarnivore() {
        return this.carnivore;
    }

    public void setCarnivore(Boolean carnivore) {
        this.carnivore = carnivore;
    }

    @Override
        public Wolf reproduce(int x, int y) {

            Wolf animal  = (Wolf) Farm.Create("Wolf", this.x, this.y);

            System.out.println("Родился новый волчонок в локации "+x+" "+y);

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
                    ", location= x=" + this.x + " у ="+this.y+'\'' +
                    '}';
        }


    @Override
        public void eat(Animal another_animal,int x,int y) {
            super.eat(another_animal,x,y);

            this.satiety = this.satiety+1;

            System.out.println("Wolf съел "+another_animal.getName()+" в локации "+x+""+y);
        }

    @Override
    public void move(int x, int y) {
        int step_for_x = 3;
        int step_for_y = 3;

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

        System.out.println("Волк переместился в другую локацию " + x + ", y = " + y);

    }
}
