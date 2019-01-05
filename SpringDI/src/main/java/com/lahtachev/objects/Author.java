package com.lahtachev.objects;

public class Author {
    private String authorName;

    public Author() {
        System.out.println("Author.Author");
    }

    public Author(String authorName) {
        this.authorName = authorName;
        System.out.println("authorName = " + authorName);
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        System.out.println("Author.setAuthorName");
        this.authorName = authorName;
        System.out.println("authorName = " + authorName);
    }
}
