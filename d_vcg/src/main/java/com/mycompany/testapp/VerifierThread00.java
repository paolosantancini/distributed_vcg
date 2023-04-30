package com.mycompany.testapp;

import java.util.concurrent.*;

public class VerifierThread00 extends Thread {

//object of the Semaphore class 
    Semaphore semaphore;
    String threadName;
    Buffer my_buffer = Buffer.getIstance();
    Integer[][] my_shares;

    // constructor
    public VerifierThread00(Semaphore semaphore, String threadName, Integer[][] shares) {
        super(threadName);
        this.semaphore = semaphore;
        this.threadName = threadName;
        this.my_shares = shares;
    }

    @Override
    public void run() {
        // run by thread
        //if (this.getName().equals("V1")) {
        try {
            semaphore.acquire(); // Acquiring the lock
            my_buffer.setBufferAllShares(this.my_shares);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e);
        }
        semaphore.release(); //release the permit 

        System.out.println(threadName + " set fictitious point: ("+
                my_shares[0][0]+","+my_shares[1][0]+")");
        //}
    }
}
