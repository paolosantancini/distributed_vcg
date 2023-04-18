package com.mycompany.testapp;

public class BinarySemaphore {

    private boolean locked = false;

    public BinarySemaphore(int initial) {
        locked = (initial == 0);
    }

    public synchronized void waitForNotify() throws InterruptedException {
        while (locked) {
            wait();
        }
        locked = true;
    }

    public synchronized void notifyToWakeup() {
        if (locked) {
            notify();
        }
        locked = false;
    }
}
