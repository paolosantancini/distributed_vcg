package com.mycompany.testapp;

public class CountingSemaphore {

    // wake up signal
    private int signal;
    
    // constructor
    public CountingSemaphore() {
        signal = 0;
    }

    // request method
    public synchronized void take() {
        this.signal++;
        this.notify();
    }

    // release method
    public synchronized void release() throws InterruptedException {
        while (this.signal == 0) {
            wait();
        }
        this.signal--;
    }

}
