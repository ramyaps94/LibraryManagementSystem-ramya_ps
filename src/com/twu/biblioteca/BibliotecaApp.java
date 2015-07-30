package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

public class BibliotecaApp {

    private View view;
    private ArrayList<HashMap<String, String>> bookList;

    public BibliotecaApp(View view, ArrayList<HashMap<String,String>> bookList) {
        this.view = view;
        this.bookList = bookList;
    }

    public void start() {
        view.display("Welcome to Bibilioteca -- the library management system");
        view.display("Menu options are");
        view.display("Enter 1 to list the books");
        String option = view.acceptInput();
        if (option.equals("1"))
            view.display(bookList);
        else
            view.display("Enter 1 to display list of books");
    }
}