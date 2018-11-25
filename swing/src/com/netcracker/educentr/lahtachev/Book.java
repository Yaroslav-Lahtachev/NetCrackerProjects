package com.netcracker.educentr.lahtachev;

public class Book {
    private String name;
    private Author author;
    private double price;
    private int qty = 0;

    public Book(double price, Author author, String name) {
        this.price = price;
        this.author = author;
        this.name = name;
    }

    public Book(String name, Author author, double price, int qty) {
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.author = author;
    }


    public String getName() {
        return name;
    }

    public int getQty() {
        return qty;
    }

    public double getPrice() {
        return price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " " + author + " " + String.valueOf(price).replace(".", ",") + " " + qty;
    }
}
