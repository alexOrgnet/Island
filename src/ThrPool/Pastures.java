package ThrPool;

import Island.IslandMap;

public class Pastures extends Thread {

    @Override
    public void run() {

        System.out.println("Начало работы потока " + getName());

        IslandMap islandMap = IslandMap.getInstance();
        islandMap.pastures();

        System.out.println("Поток " + getName() + " завершил работу.");
    }
}
