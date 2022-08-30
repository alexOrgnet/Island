package ThrPool;

import Island.IslandMap;
import Techno.Cleansing;
import Techno.Stats;

public class Tasks implements Runnable {

    @Override
    public void run() {

        //System.out.println("Начало работы потока " + getName());



        //System.out.println("Поток " +getName() + " завершил работу.");

        IslandMap islandMap = IslandMap.getInstance();
        islandMap.plant_growing();

        Stats stats = Stats.getInstance();
        stats.showStatistic(islandMap);

        Cleansing clean = Cleansing.getInstance();
        clean.cleanStaff(islandMap);

    }
}
