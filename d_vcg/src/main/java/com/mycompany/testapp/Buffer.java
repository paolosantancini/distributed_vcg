package com.mycompany.testapp;

public class Buffer {

    // unique istance
    private static Buffer instance = null;
    private int count = 0, i = 0;
    private Integer[][] all_shares = {
            {0, 0}, // first couple of points
            {0, 0}, // second couple of points
            {0, 0}  // third couple of points
        };

    // constructor
    public Buffer() {
    }

    // create object if it doesn't exist
    public static synchronized Buffer getIstance() {
        if (instance == null) {
            instance = new Buffer();
        }
        return instance;
    }

    // upper count method
    public void setCount() {
        count++;
    }

    public int getCount() {
        return (count);
    }

    public void setBufferAllShares(Integer[][] shares) {
               
        System.out.println("(" + shares[0][0] + "," + shares[1][0] + ") - "
                        + "(" + shares[0][1] + "," + shares[1][1] + ")");
        
       
        all_shares[0][0] = shares[i][i];
  
        i += 1;
        
        //System.out.println("(" + all_shares[0][0] + "," + all_shares[0 + 1][0] + ") - "
          //      + "(" + all_shares[0][0 + 1] + "," + all_shares[0 + 1][0 + 1] + ")");

    }

}
