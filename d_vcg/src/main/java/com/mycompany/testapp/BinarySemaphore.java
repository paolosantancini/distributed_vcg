/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testapp;

/**
 *
 * @author user
 */
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
