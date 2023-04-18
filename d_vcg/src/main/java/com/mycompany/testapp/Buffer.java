package com.mycompany.testapp;

public class Buffer {
    
    // unique istance
    private static Buffer instance = null;
    private int count = 0;

    // constructor
    public Buffer () {}
    
    // create object if it doesn't exist
    public static synchronized Buffer getIstance() {
    if (instance == null) {
            instance = new Buffer();
        }
        return instance;
    }
    
    // upper count method
    public void setCount() { count++; }
    public int getCount() { return(count); }
    
    
}
