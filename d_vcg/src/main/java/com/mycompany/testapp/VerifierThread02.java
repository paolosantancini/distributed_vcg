package com.mycompany.testapp;

public class VerifierThread02 extends Thread {

//object of the Semaphore class 
    String threadName;
    Buffer my_buffer = Buffer.getIstance();

    // constructor
    public VerifierThread02(String threadName) {
        super(threadName);
        this.threadName = threadName;
    }

    @Override
    public void run() {
        // run by thread checker
        System.out.println("Thread " + threadName + " is verifing...");

        do {
            // loop
        } while (this.my_buffer.getCount() == 0);

        System.out.println(threadName + " gets count to "
                + this.my_buffer.getCount() + " end the process");
    }
}
