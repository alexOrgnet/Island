import Island.IslandMap;
import Techno.Cleansing;
import Techno.Params;
import Techno.Stats;
import ThrPool.Breeding;
import ThrPool.Hunting;
import ThrPool.Pastures;

public class Main {

    public static void main(String[] args) {

        //создаем объект острова
        IslandMap islandMap = IslandMap.getInstance();

        //инициализация острова, создание карты
        islandMap.island_initialization();

        //инициализация острова, создание растительности
        islandMap.plant_initialization();

        //первичное размещение животных
        islandMap.animal_creation();

        //получаем параметры игры: количество циклов
        int cycles = Params.getCycles();

        //запускаем жизненный цикл
        for (int i = 0; i < cycles; i++) {

            System.out.println("И настал день № " + (i + 1));

            //выпас травоядных животных
            Pastures t1 = new Pastures();
            t1.run();

            //охота плотоядных животных
            Hunting t2 = new Hunting();
            t2.run();

            //Выращивание детенышей
            Breeding t3 = new Breeding();
            t3.run();

            //собираем статистику
            Stats stats = Stats.getInstance();
            stats.showStatistic(IslandMap.getKarta());

            //удаляем старые данные
            Cleansing clean = Cleansing.getInstance();
            clean.cleanStaff(IslandMap.getKarta());



        }
    }
}