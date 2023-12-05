package ait.tarakansrace.model;

import java.util.Random;

public class Tarakan implements Runnable {

    private static Random random = new Random();
    private static String winnerName;
    String name;
    int distance;

    public Tarakan(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public static String getWinnerName() {
        return winnerName;
    }


    @Override
    public void run() {
        for (int i = 0; i < distance; i++) {
            System.out.println("Tarakan #" + name + " = my position is = " + i);
            try {
                Thread.sleep(random.nextInt(2, 5));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        setWinnerName();


    }
    public synchronized void setWinnerName() {
        if (winnerName == null) {
            winnerName = "tarakan #" + name;
        }
    }
}
