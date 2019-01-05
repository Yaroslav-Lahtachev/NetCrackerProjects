package com.lahtachev.objects;

public class DefaultCar extends Transport {
    private String name;

    public DefaultCar(int qtyPassengers, String name) {
        super(qtyPassengers);
        System.out.println("DefaultCar.DefaultCar");
        this.name = name;
        System.out.println("qtyPassengers = " + qtyPassengers);
        System.out.println("name = " + name);
    }
}
