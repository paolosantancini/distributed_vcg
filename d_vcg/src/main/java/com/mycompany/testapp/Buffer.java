package com.mycompany.testapp;

public class Buffer {

    // unique istance
    private static Buffer instance = null;
    private int count = 0, i = 0, j=0;
    // Defining couple point's container [col][row]
    private Integer[][] all_shares = {
            {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0},{0, 0}, 
            {0, 0}  
        };
    private Integer[][] bids = {
            {0, 0}, {0, 0}, {0, 0}  
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
    public void setCount(String prover) {
        if (prover.contentEquals("P1")) {count++;}
    }

    public int getCount() {
        return (count);
    }

    public void setBufferAllShares(Integer[][] shares) {
               
        all_shares[i][0] = shares[0][0]; // x
        all_shares[i][1] = shares[1][0]; // y
  
        i += 1;
        
        /*
        AGGIUNGERE LA COMPILAZIONE DELLA MATRICE CON PESI, VALUTAZIONE
        DEL PROVER (TOKENS).
        ALLA FINE DEL PROCESSO CALCOLARE LA MATRICE DELLE SCELTE E VIA DICENDO...
        */
        
    }
    
    public Integer[][] getAllShares(){
        return all_shares;
    }

    public void setBids(int x, int y) {
        bids[j][0] = 0;
        bids[j][1] = 0;
        j += 1;
    }
    
}
