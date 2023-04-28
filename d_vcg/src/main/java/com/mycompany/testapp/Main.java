package com.mycompany.testapp;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(1);

        // Initializing provers
        Prover p1 = new Prover();
        Prover p2 = new Prover();
        Prover p3 = new Prover();

        VerifierThread v1 = new VerifierThread(semaphore, "V1");
        v1.start(); // starting verifier 1

        // Starting VCG
        ProverThread p1_t = new ProverThread(semaphore, "P1", p1.getShare());
        ProverThread p2_t = new ProverThread(semaphore, "P2", p2.getShare());
        ProverThread p3_t = new ProverThread(semaphore, "P3", p3.getShare());
        p1_t.start();
        p2_t.start();
        p3_t.start();

        v1.join(); // release verifier 1
        p1_t.join();
        p2_t.join();
        p3_t.join();

    }

}
