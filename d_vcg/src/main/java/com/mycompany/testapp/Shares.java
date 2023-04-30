package com.mycompany.testapp;

public class Shares {
    
    Shares() {}
    
    public Integer[][] setShare(int x, int a, int b, int secret) {
        
        Integer y;
        
        y = a * (x ^ 2) + b * x + secret;
        
        Integer[][] points = {
            {x}, // first row with one colum
            {y} // second row with one colum
        };
        return points;
    }
    
}
