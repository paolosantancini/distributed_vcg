package com.mycompany.testapp;

public class Buffer {

    // unique istance
    private static Buffer instance = null;
    private int count = 0, i = 0, j = 0;
    // Defining couple point's container [col][row]
    private Integer[][] all_shares = {
        {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0},
        {0, 0}
    };
    // Define bid as x, y, bid_value
    private Integer[] bids = {0, 0, 0};
    private Integer[] point;

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

// init counters
    public void init() {
        i = j = 0;
    }

// upper count method
    public void setCount() {
        //if (prover.contentEquals("P1")) {
        count++;
        //}
    }

    public int getCount() {
        return (count);
    }

    public void setBufferAllShares(Integer[][] shares) {

        all_shares[i][0] = shares[0][0]; // x
        all_shares[i][1] = shares[1][0]; // y

        i += 1;

    }

    public Integer[][] getAllShares() {
        return all_shares;
    }

    public void setPoint(Integer[] p) {
        point = p;
    }

    public Integer[] getPoint() {
        return point;
    }

    public void setBids(Integer bid) {
        bids[j] = bid;
        j += 1;
    }

    public Integer[] getBids() {
        return bids;
    }

}
