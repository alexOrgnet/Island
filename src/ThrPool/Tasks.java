package ThrPool;

import Island.IslandMap;
import Techno.Stats;

public class Tasks implements Runnable {

    @Override
    public void run() {

        //System.out.println("Начало работы потока " + getName());

        Stats stats = Stats.getInstance();
        stats.showStatistic(IslandMap.getKarta());

        //System.out.println("Поток " +getName() + " завершил работу.");

        IslandMap islandMap = IslandMap.getInstance();
        islandMap.plant_growing();

    }
}
