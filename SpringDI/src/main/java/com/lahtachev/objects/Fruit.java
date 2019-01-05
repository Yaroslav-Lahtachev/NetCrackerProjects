package com.lahtachev.objects;

public class Fruit {
    private String name;
    private String color;
    private int qty;

    public Fruit() {
        System.out.println("Fruit.Fruit");
    }

    public Fruit(String name, String color, int qty) {
        this.name = name;
        this.color = color;
        this.qty = qty;
        System.out.println("name = " + name);
        System.out.println("color = " + color);
        System.out.println("qty = " + qty);
    }
}
