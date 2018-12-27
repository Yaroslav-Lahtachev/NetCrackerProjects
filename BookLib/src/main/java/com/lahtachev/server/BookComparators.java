package com.lahtachev.server;

import com.lahtachev.shared.Book;

import java.util.Comparator;

public class BookComparators {
    public static Comparator<Book> compareById = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.getId()-o2.getId();
        }
    };
    public static Comparator<Book> compareByAuthor = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.getAuthor().compareTo(o2.getAuthor());
        }
    };
    public static Comparator<Book> compareByTitle = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    };
    public static Comparator<Book> compareByPageNum = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.getPageNum()-o2.getPageNum();
        }
    };
    public static Comparator<Book> compareByPublishingYear = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.getPublishingYear()-o2.getPublishingYear();
        }
    };
    public static Comparator<Book> compareByDateAdded = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            if((o1.getAddedYear()-o2.getAddedYear())!=0){
                return (int)(o1.getAddedYear()-o2.getAddedYear());
            }
            else{
                if((o1.getAddedMonth()-o2.getAddedMonth())!=0){
                    return (int)(o1.getAddedMonth()-o2.getAddedMonth());
                }
                else{
                    return (int)(o1.getAddedDay()-o2.getAddedDay());
                }
            }
        }
    };


}
