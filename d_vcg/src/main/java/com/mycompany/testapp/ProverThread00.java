package com.mycompany.testapp;

import java.util.concurrent.*;

public class ProverThread00 extends Thread {

//object of the Semaphore class  
    Semaphore semaphore;
    String threadName;
    Buffer my_buffer = Buffer.getIstance();
    Integer[][] my_shares;

    // constructor
    public ProverThread00(Semaphore semaphore, String threadName, Integer[][] shares) {
        super(threadName);
        this.semaphore = semaphore;
        this.threadName = threadName;
        this.my_shares = shares;
    }

    @Override
    public void run() {
        // run by thread
        //if (this.getName().equals("P1")) {
        try {

            semaphore.acquire(); // Acquiring the lock  

            // set shares to buffer
            my_buffer.setBufferAllShares(my_shares);
            System.out.println(threadName+ " set own point: ("+
                    my_shares[0][0]+","+my_shares[1][0]+")");

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e);
        }
        semaphore.release(); //release the permit  
        //}
    }
}
