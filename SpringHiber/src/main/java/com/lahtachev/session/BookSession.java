package com.lahtachev.session;

import com.lahtachev.config.SpringConfig;
import com.lahtachev.dao.bookDAO.IBookDAO;
import com.lahtachev.entity.Book;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.List;

public class BookSession {

    static AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    static IBookDAO service = (IBookDAO) context.getBean("bookDAO");

    public static void deleteBookById(int idBook) {
        service.deleteBookById(idBook);
    }

    public static Book updateBook(int idBook, String name, int price, String region, int qty) {
        service.updateBook(idBook, name, price, region, qty);
        return findBookById(idBook);
    }

    public static Book saveBook(Book entity) {
        service.saveBook(entity);
        return entity;
    }

    public static void findAllBooks() {
        System.out.println(service.findAllBooks());
    }

    public static void rowCount() {
        System.out.println(service.rowCount());
    }

    public static Book findBookById(int idBook) {
        System.out.println(service.findBookById(idBook));
        return service.findBookById(idBook);
    }

    public static void task2a() {
        System.out.println("BookSession.task2a");
        System.out.println(service.task2a());
    }

    public static void task3c(String name, double price) {
        System.out.println("BookSession.task3c");
        List<Book> list = service.task3c(name, price);
        System.out.println(list);
    }

}
