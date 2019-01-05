package com.lahtachev.objects;

public class Transport {
    protected int qtyPassengers;

    public Transport(int qtyPassengers) {
        System.out.println("Transport.Transport");
        this.qtyPassengers = qtyPassengers;
        //System.out.println("qtyPassengers = " + qtyPassengers);
    }
}
