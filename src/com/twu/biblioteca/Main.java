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
        HashMap<String, String> book2 = new HashMap<String, String>();
        book2.put("Title", "What young India Wants");
        book2.put("Author", "Chethan Bhaghat");
        book2.put("year", "2015");
        bookList.add(book1);
        bookList.add(book2);
        BibliotecaApp application = new BibliotecaApp(view ,bookList);
        application.start();
    }
}