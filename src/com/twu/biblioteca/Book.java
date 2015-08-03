package com.twu.biblioteca;

public class Book {
    private String bookName;
    private String author;
    private String publishingYear;

    public Book(String bookName, String author, String publishingYear) {
        this.bookName = bookName;
        this.author = author;
        this.publishingYear = publishingYear;
    }

    public String getDetails() {
        return ""+bookName+" "+author+" "+publishingYear;
    }
}