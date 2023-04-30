package com.mycompany.testapp;

import java.util.Objects;
import java.util.concurrent.*;
import java.util.Random;

public class ProverThread01 extends Thread {

//object of the Semaphore class  
    Semaphore semaphore;
    String threadName;
    Buffer my_buffer = Buffer.getIstance();
    Integer[][] my_shares;
    Random ran = new Random();

    // constructor
    public ProverThread01(Semaphore semaphore, String threadName, Integer[][] shares) {
        super(threadName);
        this.semaphore = semaphore;
        this.threadName = threadName;
        this.my_shares = shares;
    }

    @Override
    public void run() {
        // run by prover bid
        //if (this.getName().equals("P1")) {
        try {
            Integer bid = 1+ran.nextInt(10);

            semaphore.acquire(); // Acquiring the lock 
            // reading verifier selected couple of points
            Integer[] p = my_buffer.getPoint();
            // check x
            if (Objects.equals(p[0], my_shares[0][0])) {
                //check y
                if ((Objects.equals(p[1], my_shares[1][0]))){
                    bid += 50;
                }
            }
            my_buffer.setBids(bid);
            System.out.println(threadName + " set own value: "+bid+ " "
                    + "for point("+p[0]+","+p[1]+")");

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e);
        }
        semaphore.release(); //release the permit  
        //}
    }
}
