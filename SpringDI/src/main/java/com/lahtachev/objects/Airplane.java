package com.lahtachev.objects;

public class Airplane extends Transport {
    private String name;

    public Airplane(int qtyPassengers, String name) {
        super(qtyPassengers);
        System.out.println("Airplane.Airplane");
        this.name = name;
        System.out.println("qtyPassengers = " + qtyPassengers);
        System.out.println("name = " + name);
    }
}
