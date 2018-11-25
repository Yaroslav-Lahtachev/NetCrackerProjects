package com.netcracker.educentr.lahtachev;

import javax.swing.table.AbstractTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class BookModel extends AbstractTableModel {

    public ArrayList<Book> books = new ArrayList<>();

    public BookModel() {
    }

    public void addBook(Book b) {
        books.add(b);
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return books.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Book cur = books.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return cur.getName();
            case 1:
                return cur.getAuthor().toString();
            case 2:
                return cur.getPrice();
            case 3:
                return cur.getQty();
        }
        return null;
    }

    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Book name";
            case 1:
                return "Author";
            case 2:
                return "Price";
            case 3:
                return "Count";
        }
        return "";
    }

    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return Double.class;
            case 3:
                return Integer.class;
        }
        return Object.class;
    }

    public void readFromFile(String name) throws IOException {

        Scanner sc = new Scanner(new File(name));
        System.out.println("Start reading");
        String bookName;
        String authorName;
        String authorEmail;
        String authorGender;
        double bookPrice;
        int booksCount;

        while (sc.hasNext()) {
            bookName = sc.next();
            authorName = sc.next();
            authorEmail = sc.next();
            authorGender = sc.next();
            bookPrice = sc.nextDouble();
            booksCount = sc.nextInt();
            if (sc.hasNextLine())
                sc.nextLine();

            Author author = new Author(authorName, authorEmail, authorGender);
            Book book = new Book(bookName, author, bookPrice, booksCount);
            this.addBook(book);
        }
        sc.close();
    }

    public static void writeToFile(String name, BookModel m) throws IOException {
        FileWriter writer = new FileWriter(name);

        BufferedWriter bufferWriter = new BufferedWriter(writer);
        bufferWriter.write("");


        Book book;
        for (int i = 0; i < m.books.size(); i++) {
            book = m.books.get(i);
            bufferWriter.write(book.toString());
            if (i != m.books.size() - 1) bufferWriter.newLine();
        }
        bufferWriter.close();
    }

    public void removePreviousRecords() {
        books.clear();
    }

    public void removeBook(int idx) {
        books.remove(idx);
        fireTableDataChanged();
    }
}
