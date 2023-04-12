package com.mycompany.testapp;

public class Shared {
    
    // unique istance
    private static Shared instance = null;
    private int count = 0;

    // constructor
    public Shared () {}
    
    // create object if it doesn't exist
    public static Shared getIstance() {
    if (instance == null) {
            instance = new Shared();
        }
        return instance;
    }
    
    // upper count method
    public void setCount() { count++; }
    public int getCount() { return(count); }
    
    
}
