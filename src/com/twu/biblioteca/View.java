package com.twu.biblioteca;

import java.util.ArrayList;

public class View {
    public void displayWelcomeMessage() {
        System.out.println("Welcome to Bibilioteca -- the library management system");
    }
    public void displayListOfBooks(ArrayList<String> bookList) {
        System.out.println("List of books are");
        System.out.print(bookList);
    }
}
