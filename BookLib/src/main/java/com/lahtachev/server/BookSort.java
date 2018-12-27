package com.lahtachev.server;

import com.lahtachev.shared.Book;

import java.util.Collections;
import java.util.List;

public class BookSort {

    public static List<Book> makeSort(List<Book> books, String sorting) {
        switch (sorting) {
            case "id":
                Collections.sort(books, BookComparators.compareById);
                break;
            case "author":
                Collections.sort(books, BookComparators.compareByAuthor);
                break;
            case "title":
                Collections.sort(books, BookComparators.compareByTitle);
                break;
            case "pageNum":
                Collections.sort(books, BookComparators.compareByPageNum);
                break;
            case "publishingYear":
                Collections.sort(books, BookComparators.compareByPublishingYear);
                break;
            case "dateAdded":
                Collections.sort(books, BookComparators.compareByDateAdded);
                break;
        }
        return books;
    }
}
