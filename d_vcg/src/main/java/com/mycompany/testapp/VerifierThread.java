package com.mycompany.testapp;

import java.util.concurrent.*;

public class VerifierThread extends Thread {

//object of the Semaphore class  
    String threadName;
    Buffer my_share = Buffer.getIstance();

    // constructor
    public VerifierThread(Semaphore semaphore, String threadName) {
        super(threadName);
        this.threadName = threadName;
    }

    @Override
    public void run() {
        // run by thread V1   
        if (this.getName().equals("V1")) {
            System.out.println("Starting thread " + threadName);
            do {
                // loop
            } while (this.my_share.getCount() == 0);
            System.out.println(threadName + " gets count to " + 
                        this.my_share.getCount()+ " end the process");
            System.out.println("Releasing thread " + threadName);
        }
    }
}
