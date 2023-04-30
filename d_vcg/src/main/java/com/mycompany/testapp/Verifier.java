package com.mycompany.testapp;

import java.util.Random;

public class Verifier {

    Shares my_shares;

    private final Integer x1, a, b, c, secret;
    private final Integer[][] y;
    Random ran = new Random();

    Verifier() {

        // Generating fictitious parable
        my_shares = new Shares();

        x1 = 1 + ran.nextInt(10);

        secret = 0;
        a = 1 + ran.nextInt(10);
        b = 1 + ran.nextInt(10);
        c = secret;

        y = my_shares.setShare(x1, a, b, c);

    }

    public Integer[][] getShare() {
        return (y);
    }

}
