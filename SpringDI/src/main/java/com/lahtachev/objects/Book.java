package com.lahtachev.objects;

public class Book {
    private String bookName;
    private Author author;

    public Book() {
        System.out.println("Book.Book");
    }

    public Book(String bookName, Author author) {
        this.bookName = bookName;
        this.author = author;
        System.out.println("bookName = " + bookName);
        System.out.println("author = " + author.getAuthorName());
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        System.out.println("Book.setBookName");
        this.bookName = bookName;
        System.out.println("bookName = " + bookName);
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        System.out.println("Book.setAuthor");
        this.author = author;
    }
}
