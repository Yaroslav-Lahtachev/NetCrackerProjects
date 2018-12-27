package com.lahtachev.server;

import com.lahtachev.shared.Book;
import com.lahtachev.shared.BookPagination;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BookModel {

    private int size;

    public BookPagination getAllBooks(int page, int booksNum, String sorting) {
        List<Book> books = new ArrayList<>();
        try {
            new FileWriter("books.txt", true);
            File file = new File("books.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String book = bufferedReader.readLine();
            try {
                Integer.valueOf(book);
            } catch (NumberFormatException ex) {
                System.out.println("creating bookLib");
                createLib();
            }
            System.out.println("reading bookLib");
            books = readFromFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("returning bookLib");
        return sortPage(books, page, booksNum, sorting);
    }

    public BookPagination addBook(Book book, int page, int booksNum, String sorting) {
        List<Book> books = readFromFile();
        size++;
        book.setId(size);
        books.add(book);
        writeToFile(books);
        return sortPage(books, page, booksNum, sorting);
    }

    public BookPagination deleteBook(int id, int page, int booksNum, String sorting) {
        List<Book> books = readFromFile();
        for (Book book : books)
            if (book.getId() == id) {
                books.remove(book);
                break;
            }
        writeToFile(books);
        return sortPage(books, page, booksNum, sorting);
    }

    public BookPagination sortPage(List<Book> books, int page, int booksNum, String sorting) {
        List<Book> booksOnPage;
        BookPagination bookPagination = new BookPagination();
        booksOnPage = BookSort.makeSort(books, sorting);
        bookPagination.setSize(booksOnPage.size());
        System.out.println("------------------->>>>" + page);
        if (page == 1) {
            switch (booksNum) {
                case 3:
                    if (booksOnPage.size() > 3)
                        booksOnPage = booksOnPage.subList(0, 3);
                    break;
                case 10:
                    if (booksOnPage.size() > 10)
                        booksOnPage = booksOnPage.subList(0, 10);
                    break;
            }
        } else {
            if (booksNum * page > booksOnPage.size()) {
                booksOnPage = booksOnPage.subList((page - 1) * booksNum, booksOnPage.size());
            } else {
                booksOnPage = booksOnPage.subList((page - 1) * booksNum, page * booksNum);
            }
        }
        bookPagination.setBooks(booksOnPage);
        return bookPagination;
    }

    private void createLib() {
        File file = new File("books.txt");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file, false);
            size = 4;
            fileWriter.write(String.valueOf(size));
            fileWriter.write('\n');
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        String book = new String("1###Homer###The Odyssey###560###1999###2018###12###26");
        try {
            fileWriter.write(book);
            fileWriter.write('\n');
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        book = new String("2###Leo Tolstoy###War and Peace###1225###1869###2018###12###26");
        try {
            fileWriter.write(book);
            fileWriter.write('\n');
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        book = new String("3###William Shakespeare###Hamlet###336###1609###2018###12###26");
        try {
            fileWriter.write(book);
            fileWriter.write('\n');
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        book = new String("4###Dante Alighieri###The Divine Comedy###928###1320###2018###12###26");
        try {
            fileWriter.write(book);
            fileWriter.write('\n');
            fileWriter.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void writeToFile(List<Book> books) {
        try {
            File file = new File("books.txt");
            FileWriter fileWriter = new FileWriter(file, false);
            fileWriter.write(String.valueOf(size));
            fileWriter.write('\n');
            for (Book book : books) {
                String bookLine = new String(book.getId() + "###" +
                        book.getAuthor() + "###" +
                        book.getTitle() + "###" +
                        book.getPageNum() + "###" +
                        book.getPublishingYear() + "###" +
                        book.getAddedYear() + "###" +
                        book.getAddedMonth() + "###" +
                        book.getAddedDay());
                fileWriter.write(bookLine);
                fileWriter.write('\n');
            }
            fileWriter.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public List<Book> readFromFile() {
        List<Book> books = new ArrayList<>();
        try {
            File file = new File("books.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String bookLine = bufferedReader.readLine();
            size = Integer.valueOf(bookLine);
            System.out.println("size of lib" + size);
            bookLine = bufferedReader.readLine();
            while (bookLine != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(bookLine, "###");
                books.add(new Book(Integer.valueOf(stringTokenizer.nextToken()),
                        stringTokenizer.nextToken(), stringTokenizer.nextToken(),
                        Integer.valueOf(stringTokenizer.nextToken()),
                        Integer.valueOf(stringTokenizer.nextToken()),
                        Integer.valueOf(stringTokenizer.nextToken()),
                        Integer.valueOf(stringTokenizer.nextToken()),
                        Integer.valueOf(stringTokenizer.nextToken())));
                //new Date(stringTokenizer.nextToken())
                //date.parse(stringTokenizer.nextToken())
                bookLine = bufferedReader.readLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }/* catch (ParseException ex) {
            ex.printStackTrace();
        }*/
        return books;
    }
}
