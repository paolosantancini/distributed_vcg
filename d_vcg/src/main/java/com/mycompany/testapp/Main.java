package com.mycompany.testapp;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Integer[][] share_array;
        Semaphore semaphore = new Semaphore(1);

        // Initializing provers
        Prover p1 = new Prover();
        Prover p2 = new Prover();
        Prover p3 = new Prover();

        share_array = p1.getShare();
        System.out.println("P1 shares: "
                + "(" + share_array[0][0] + "," + share_array[1][0] + ") - "
                + "(" + share_array[0][1] + "," + share_array[1][1] + ") - "
                + "(" + share_array[0][2] + "," + share_array[1][2] + ")");

        share_array = p2.getShare();
        System.out.println("P2 shares: "
                + "(" + share_array[0][0] + "," + share_array[1][0] + ") - "
                + "(" + share_array[0][1] + "," + share_array[1][1] + ") - "
                + "(" + share_array[0][2] + "," + share_array[1][2] + ")");

        share_array = p3.getShare();
        System.out.println("P3 shares: "
                + "(" + share_array[0][0] + "," + share_array[1][0] + ") - "
                + "(" + share_array[0][1] + "," + share_array[1][1] + ") - "
                + "(" + share_array[0][2] + "," + share_array[1][2] + ")");

        VerifierThread v1 = new VerifierThread(semaphore, "V1");
        v1.start(); // starting verifier 1

        // Starting VCG
        ProverThread p1_t = new ProverThread(semaphore, "P1");
        ProverThread p2_t = new ProverThread(semaphore, "P2");
        ProverThread p3_t = new ProverThread(semaphore, "P3");
        p1_t.start();
        p2_t.start();
        p3_t.start();

        v1.join(); // release verifier 1
        p1_t.join();
        p2_t.join();
        p3_t.join();

    }

}
