package com.project;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        ParkingLot parking = new ParkingLot(2);

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 5; i++) {

            final int id = i;

            Runnable cotxe = () -> {

                String nom = "Cotxe " + id;

                parking.entrar(nom);

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                parking.sortir(nom);
            };

            executor.submit(cotxe);
        }

        executor.shutdown();
    }
}