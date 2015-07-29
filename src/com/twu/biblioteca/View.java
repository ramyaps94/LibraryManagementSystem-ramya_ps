package com.twu.biblioteca;

import java.util.ArrayList;

public class View {
    public void display() {
        System.out.println("Welcome to Bibilioteca -- the library management system");
    }
    public void display(ArrayList<String> bookList) {
        System.out.println("List of books are");
        System.out.print(bookList);
    }
}
