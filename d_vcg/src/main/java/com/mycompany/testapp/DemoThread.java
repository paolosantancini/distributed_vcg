/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testapp;

import java.util.concurrent.*;

/**
 *
 * @author user
 */

public class DemoThread extends Thread {

//object of the Semaphore class  
    Semaphore semaphore;
    String threadName;
    Shared my_share = new Shared();

    // constructor
    public DemoThread(Semaphore semaphore, String threadName) {
        super(threadName);
        this.semaphore = semaphore;
        this.threadName = threadName;
    }

    @Override
    public void run() {
// run by thread A   
        if (this.getName().equals("A")) {
            System.out.println("Starting thread " + threadName);
            try {
// First, get a permit.   
                System.out.println(threadName + " is waiting for a permit.");
//acquiring the lock   
                semaphore.acquire();
                System.out.println(threadName + " gets a permit.");
//current thread A is accessing the resource and the   
//other threads are waiting for to get the resource   
//until the thread A release the lock   
                for (int i = 0; i < 5; i++) {
//thread A has acquired the resource   
//hence the value of the count is incremented to 1    

this.my_share.setCount();

                    System.out.println(threadName + ": " + this.my_share.getCount());
//now, allowing a context switch for thread B to execute   
//sleeps thread for 1 second  
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Error: "+e);
            }
//release the permit  
            System.out.println("Thread " + threadName + " releases the permit.");
            semaphore.release();
        } // run by thread B   
        else {
            System.out.println("Starting thread " + threadName);
            try {
//first, get a permit  
                System.out.println("Thread " + threadName + " is waiting for a permit.");
//acquiring the lock   
                semaphore.acquire();
                System.out.println("Thread " + threadName + " gets a permit.");
//Now, accessing the shared resource.   
//other waiting threads will wait, until this   
//thread release the lock   
                for (int i = 0; i < 5; i++) {
//decrements the count value      
                    this.my_share.setCount();
                    System.out.println(threadName + ": " + this.my_share.getCount());
//Now, allowing a context switch -- if possible.   
//for thread A to execute   
//sleeps thread for 1 second  
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Error: "+e);
            }
//release the permit   
            System.out.println("Thread " + threadName + " releases the permit.");
//release the resource  
            semaphore.release();
        }
    }
}
