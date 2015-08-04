package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    static ArrayList<HashMap<String, String>> bookList = new ArrayList<HashMap<String, String>>();
    static ArrayList<HashMap<String, String>> movieList = new ArrayList<HashMap<String, String>>();
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
        HashMap<String, String> movie1 = new HashMap<String, String>();
        movie1.put("Name", "3 Idiots");
        movie1.put("year", "2011");
        movie1.put("director", "xyz");
        movie1.put("rating", "9");
        HashMap<String, String> movie2 = new HashMap<String, String>();
        movie2.put("Name" , "pk");
        movie2.put("year", "2015");
        movie2.put("director", "abc");
        movie2.put("rating","8");
        movieList.add(movie1);
        movieList.add(movie2);
        BibliotecaApp application = new BibliotecaApp(view ,bookList , movieList);
        application.start();
    }
}