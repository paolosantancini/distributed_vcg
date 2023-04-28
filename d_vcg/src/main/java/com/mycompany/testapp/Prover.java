package com.mycompany.testapp;

import java.util.Random;

public class Prover {

    private final Integer a, b, c;
    private final Integer x1, x2, secret, tokens;
    private Integer y1, y2;
    private Integer[][] y;

    Prover() {

        // y = ax^2+bx+c (c=secret; a,b simple coefficient)
        // Generating parable
        
        Random ran = new Random();

        x1 = 1+ran.nextInt(10);
        x2 = 1+ran.nextInt(10);

        secret = 100+ran.nextInt(100);
        a = 1+ran.nextInt(10);
        b = 1+ran.nextInt(10);
        c = secret;
        
        tokens = 200;
        
        setShare();

    }

    private void setShare() {
        y1 = a * (x1 ^ 2) + b * x1 + secret;
        y2 = a * (x2 ^ 2) + b * x2 + secret;
        Integer[][] points = {
            {x1, x2}, // first row with three colums
            {y1, y2} // second row with three colums
        };
        y = points;
    }

    public Integer[][] getShare() {
        return (y);
    }

}
