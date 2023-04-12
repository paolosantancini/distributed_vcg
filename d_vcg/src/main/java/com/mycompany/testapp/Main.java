package com.mycompany.testapp;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(1);
        Shared my_share = new Shared();

        DemoThread dt1 = new DemoThread(semaphore, "A");
        DemoThread dt2 = new DemoThread(semaphore, "B");
//stating both threads A and B   
        dt1.start();
        dt2.start();
//waiting for thread A   
        dt1.join();
//waiting for thread B  
        dt2.join();
//after completing the execution of the threads, the count value will be 0 always

        my_share.setCount();
        System.out.println("count: " + my_share.getCount());

    }

}
