package com.lahtachev.dao.bookDAO;

import com.lahtachev.entity.Book;

import java.util.List;

public interface IBookDAO {

    void deleteBookById(int idBook);

    void updateBook(int idBook, String name, int price, String region, int qty);

    void saveBook(Book entity);

    List<Book> findAllBooks();

    long rowCount();

    Book findBookById(int idBook);

    List<Book> task2a();

    List<Book> task3c(String name, double price);
}
