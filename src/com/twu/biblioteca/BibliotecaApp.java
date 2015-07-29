package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        View view = new View();
        view.display();
        ArrayList<String> bookList = new ArrayList<String>();
        bookList.add("Wings of fire");
        bookList.add("Harry Potter");
        view.display(bookList);
    }
}