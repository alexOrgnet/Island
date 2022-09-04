package ThrPool;

import Island.IslandMap;

public class Breeding extends Thread {

    @Override
    public void run() {

        //System.out.println("Начало работы потока " + getName());

        IslandMap islandMap = IslandMap.getInstance();
        islandMap.breeding();

        //System.out.println("Поток " + getName() + " завершил работу.");
    }
}
