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
        String option;
        do {
            view.displayMenu();
            option = view.acceptInput();
            switch (option) {
                case "1":
                    view.display(bookList);
                    break;
                //case "2":
                  //  view.display
                case "0":
                    view.display("The application is quiting !!! Thank You");
                    break;
                default:
                    view.display("Select a valid option!");
                    break;
            }

        } while (option != "0");

    }
}