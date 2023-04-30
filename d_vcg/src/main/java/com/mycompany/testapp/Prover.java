package com.mycompany.testapp;

import java.util.Random;

public class Prover {

    private final Integer a, b, c;
    private final Integer x1, secret;
    private final Integer[][] y;
    Shares my_shares;

    Prover() {

        // y = ax^2+bx+c (c=secret; a,b simple coefficient)
        // Generating parable
        
        Random ran = new Random();
        my_shares = new Shares();

        x1 = 1+ran.nextInt(10);

        secret = 100+ran.nextInt(100);
        a = 1+ran.nextInt(10);
        b = 1+ran.nextInt(10);
        c = secret;
        
        y = my_shares.setShare(x1,a,b,c);

    }

    public Integer[][] getShare() {
        return (y);
    }

}
