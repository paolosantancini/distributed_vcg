package com.mycompany.testapp;

import java.util.Random;

public class VerifierThread01 extends Thread {

//object of the Semaphore class 
    String threadName;
    Buffer my_buffer = Buffer.getIstance();

    // constructor
    public VerifierThread01(String threadName) {
        super(threadName);
        this.threadName = threadName;
    }

    @Override
    public void run() {
        // run by thread bid's manager

        Integer[][] shares;
        int j;
        
        Random ran = new Random();

        shares = my_buffer.getAllShares();
        
        j = ran.nextInt(9);
        
        // select random point from shares
        Integer[] point = {shares[j][0], shares[j][1] };
                
        my_buffer.setPoint(point);
        
        System.out.println(threadName+" select point: (" + point[0]+","+point[1]+")");
        
    }
}
