package ait.tarakansrace;

import ait.tarakansrace.model.Tarakan;

import java.util.Scanner;

public class RaceAppl {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("=========== Welcome to the TarakansRace =========== ");
        System.out.println("Please, enter number of Tarakans:");

        int countOfTar = scanner.nextInt();
        System.out.println("Please, enter a distance:");
        int distance = scanner.nextInt();


        Tarakan[] tarakans = new Tarakan[countOfTar];
        for (int i = 0; i < tarakans.length; i++) {
            tarakans[i] = new Tarakan("" + i, distance);
        }

        Thread[] threads = new Thread[countOfTar];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(tarakans[i]);
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        System.out.println("Congratulations to tarakan " + Tarakan.getWinnerName() + " (winner)");


    }
}
