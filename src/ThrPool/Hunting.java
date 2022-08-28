package ThrPool;

import Island.IslandMap;

public class Hunting extends Thread {

    @Override
    public void run() {

        System.out.println("Начало работы потока " + getName());

        IslandMap islandMap = IslandMap.getInstance();
        islandMap.hunting();

        System.out.println("Поток " + getName() + " завершил работу.");
    }
}

