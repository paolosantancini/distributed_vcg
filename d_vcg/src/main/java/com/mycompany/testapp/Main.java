package com.mycompany.testapp;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(1);
        Buffer my_buffer = Buffer.getIstance();

        // Initializing provers
        Prover p1 = new Prover();
        Prover p2 = new Prover();
        Prover p3 = new Prover();

        Verifier v1 = new Verifier();
        Verifier v2 = new Verifier();
        Verifier v3 = new Verifier();
        Verifier v4 = new Verifier();
        Verifier v5 = new Verifier();
        Verifier v6 = new Verifier();

        VerifierThread00 v1_t = new VerifierThread00(semaphore, "V1", v1.getShare());
        VerifierThread00 v2_t = new VerifierThread00(semaphore, "V2", v2.getShare());
        VerifierThread00 v3_t = new VerifierThread00(semaphore, "V3", v3.getShare());
        VerifierThread00 v4_t = new VerifierThread00(semaphore, "V4", v4.getShare());
        VerifierThread00 v5_t = new VerifierThread00(semaphore, "V5", v5.getShare());
        VerifierThread00 v6_t = new VerifierThread00(semaphore, "V6", v6.getShare());

        // Starting verifiers
        v1_t.start();
        v2_t.start();
        v3_t.start();
        v4_t.start();
        v5_t.start();
        v6_t.start();

        // Starting VCG
        ProverThread00 p1_t = new ProverThread00(semaphore, "P1", p1.getShare());
        ProverThread00 p2_t = new ProverThread00(semaphore, "P2", p2.getShare());
        ProverThread00 p3_t = new ProverThread00(semaphore, "P3", p3.getShare());
        p1_t.start();
        p2_t.start();
        p3_t.start();

        v1_t.join();
        v2_t.join();
        v3_t.join();
        v4_t.join();
        v5_t.join();
        v6_t.join();

        p1_t.join();
        p2_t.join();
        p3_t.join();

        /* STARTING AUCTION */
        do {
// Selecting Thread
            VerifierThread01 v1_t1 = new VerifierThread01("V1");
            v1_t1.start();
            v1_t1.join();

            ProverThread01 p1_t1 = new ProverThread01(semaphore, "P1", p1.getShare());
            ProverThread01 p2_t1 = new ProverThread01(semaphore, "P2", p2.getShare());
            ProverThread01 p3_t1 = new ProverThread01(semaphore, "P3", p3.getShare());
            p1_t1.start();
            p2_t1.start();
            p3_t1.start();
            p1_t1.join();
            p2_t1.join();
            p3_t1.join();

            // Light manager
            Light light_manager = new Light();

            // Verifier Thread
            VerifierThread02 v1_t2 = new VerifierThread02("V1");
            VerifierThread02 v2_t2 = new VerifierThread02("V2");
            VerifierThread02 v3_t2 = new VerifierThread02("V3");
            v1_t2.start();
            v2_t2.start();
            v3_t2.start();
            v1_t2.join();
            v2_t2.join();
            v3_t2.join();

        } while (my_buffer.getCount() == 0);
    }

}
