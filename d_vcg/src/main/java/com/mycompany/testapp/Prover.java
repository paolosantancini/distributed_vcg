package com.mycompany.testapp;

import java.util.Random;

public class Prover {

    private final Integer a, b, c;
    private final Integer x1, x2, x3, secret;
    private Integer y1, y2, y3;
    private Integer[][] y;

    Prover() {

        // y = ax^2+bx+c (c=secret; a,b simple coefficient)
        // Generating parable
        
        Random ran = new Random();

        x1 = ran.nextInt(100);
        x2 = ran.nextInt(100);
        x3 = ran.nextInt(100);

        secret = ran.nextInt(10000);
        a = ran.nextInt(100);
        b = ran.nextInt(100);
        c = secret;
        
        setShare();

    }

    private void setShare() {
        y1 = a * (x1 ^ 2) + b * x1 + secret;
        y2 = a * (x2 ^ 2) + b * x2 + secret;
        y3 = a * (x3 ^ 2) + b * x3 + secret;
        Integer[][] points = {
            {x1, x2, x3}, // first row with three colums
            {y1, y2, y3} // second row with three colums
        };
        y = points;
    }

    public Integer[][] getShare() {
        return (y);
    }

}
