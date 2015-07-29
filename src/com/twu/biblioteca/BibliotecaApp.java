package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    private View view;

    public BibliotecaApp(View view) {
        this.view = view;
    }
    public void start() {
        view.display();
        ArrayList<String> bookList = new ArrayList<String>();
        bookList.add("Wings of fire");
        bookList.add("Harry Potter");
        view.display(bookList);
    }
}