package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    static ArrayList<HashMap<String, String>> bookList = new ArrayList<HashMap<String, String>>();
    public static void main(String[] args) {
        View view = new View();
        HashMap<String, String> book1 = new HashMap<String, String>();
        book1.put("Title", "Wings Of Fire");
        book1.put("Author", "Abdhul Kalam");
        book1.put("year", "1995");
        Book book_1 = new Book(book1.get("Title"), book1.get("Author"),book1.get("1995"));
        HashMap<String, String> book2 = new HashMap<String, String>();
        book2.put("Title", "What young India Wants");
        book2.put("Author", "Chethan Bhaghat");
        book2.put("year", "2015");
        Book book_2 = new Book(book2.get("Title"), book2.get("Author"),book2.get("1995"));
        bookList.add(book1);
        bookList.add(book2);
        Book book1 = new Book("Wings Of Fire", "Abdhul Kalam", "1980");
        Book book2 = new Book("What Young India Wants", "Chethan Bhaghat", "2014");
        Book book3 = new Book("Head First Java", "Katty Siera", "2000");
        BibliotecaApp application = new BibliotecaApp(view , bookList);
        application.start();
    }
}