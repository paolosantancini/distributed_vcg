package com.mycompany.testapp;

public class Light {

    Buffer my_buffer = Buffer.getIstance();
    Integer[] bids = my_buffer.getBids();
    Integer max = 0;

    Light() {
        // Get max bid element
        for (int i = 0; i < 3; i++) {
            if (max < bids[i]) {
                max = bids[i];
            }
        }

        // parabolic equation verify
        //
        //
        if (max > 50) {
            my_buffer.setCount();
        } else {
            my_buffer.init();
        }

    }

}
