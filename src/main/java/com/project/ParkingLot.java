package com.project;

import java.util.concurrent.Semaphore;

public class ParkingLot {

    private final Semaphore semaphore;

    public ParkingLot(int capacitat) {
        this.semaphore = new Semaphore(capacitat);
    }

    public void entrar(String cotxe) {
        try {

            if (semaphore.availablePermits() == 0) {
                System.out.println(cotxe + " espera perquè l'aparcament està ple.");
            }

            semaphore.acquire();

            System.out.println(cotxe +
                    " ha entrat. Places lliures: "
                    + semaphore.availablePermits());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sortir(String cotxe) {
        semaphore.release();

        System.out.println(cotxe +
                " ha sortit. Places lliures: "
                + semaphore.availablePermits());
    }
}