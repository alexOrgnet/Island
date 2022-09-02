import Island.IslandMap;
import Techno.Cleansing;
import Techno.Params;
import Techno.Stats;
import ThrPool.Breeding;
import ThrPool.Hunting;
import ThrPool.Pastures;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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


        //запускаем периодический сбор статистики
/*
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        executorService.scheduleAtFixedRate(new ThrPool.Tasks(), 0, 3, TimeUnit.SECONDS);

        if (islandMap.number_of_life_cycles > Params.getCycles()) executorService.shutdown();

*/

        //получаем параметры игры: количество циклов

        //запускаем жизненный цикл
        for (int i = 0; i < Params.getCycles(); i++) {

            System.out.println("И настал день № " + (i + 1));


            Stats stats = Stats.getInstance();
            stats.showStatistic(islandMap);


            //выпас травоядных животных
            Pastures t1 = new Pastures();
            t1.run();

            //охота плотоядных животных
            Hunting t2 = new Hunting();
            t2.run();

            //Выращивание детенышей
            Breeding t3 = new Breeding();
            t3.run();

            //удаляем старые данные
            Cleansing clean = Cleansing.getInstance();
            clean.cleanStaff(islandMap);


            //подготовка к следующему циклу жизни
            islandMap.preparing_next_cycle();

            //собираем статистику
            stats.showStatistic(islandMap);
        }


    }
}