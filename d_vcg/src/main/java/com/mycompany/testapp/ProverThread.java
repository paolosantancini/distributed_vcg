package com.mycompany.testapp;

import java.util.concurrent.*;

public class ProverThread extends Thread {

//object of the Semaphore class  
    Semaphore semaphore;
    String threadName;
    Buffer my_share = Buffer.getIstance();

    // constructor
    public ProverThread(Semaphore semaphore, String threadName) {
        super(threadName);
        this.semaphore = semaphore;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        // run by thread P1
        if (this.getName().equals("P1")) {
            System.out.println("Starting thread " + threadName);
            try {
                System.out.println(threadName + " is waiting for a permit.");
                semaphore.acquire(); // Acquiring the lock  
                System.out.println(threadName + " gets a permit.");
                for (int i = 0; i < 1; i++) {
                    this.my_share.setCount();
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Error: " + e);
            }
            System.out.println("Thread " + threadName + " releases the permit.");
            semaphore.release(); //release the permit  
        }

    }
}
