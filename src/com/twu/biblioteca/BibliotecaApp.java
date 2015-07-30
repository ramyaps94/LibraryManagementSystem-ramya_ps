package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

public class BibliotecaApp {

    private View view;
    private ArrayList<HashMap<String, String>> bookList = new ArrayList<HashMap<String, String>>();

    public BibliotecaApp(View view) {
        this.view = view;
    }

    public void start() {
        displayWelcomeMessage();
        loadLibraryBooks();
        displayMenu();
        int option = view.acceptInput();
        if (option == 1)
            view.display(bookList);
        else
            view.display("Enter 1 to display list of books");
    }

    public void displayWelcomeMessage() {
        view.display("Welcome to Bibilioteca -- the library management system");
    }

    public void displayMenu() {
        view.display("Menu options are");
        view.display("Enter 1 to list the books");

    }

    public void loadLibraryBooks() {

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
    }
}