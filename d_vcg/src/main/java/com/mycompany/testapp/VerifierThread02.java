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
        if (this.my_buffer.getCount() == 1) {
            System.out.println(threadName + " say light turned on!!!");
        } else {
            System.out.println(threadName + " say light not turned on!!!");
        }
        /*do {
            // loop
        } while (this.my_buffer.getCount() == 0);*/

    }
}
