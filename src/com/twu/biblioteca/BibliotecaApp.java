package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class BibliotecaApp {

    private View view;
    private ArrayList<HashMap<String, String>> allAvailableBookList;
    private ArrayList<HashMap<String, String>> checkedOutBookList = new ArrayList<HashMap<String, String>>();

    public BibliotecaApp(View view, ArrayList<HashMap<String,String>> bookList) {
        this.view = view;
        this.allAvailableBookList = bookList;
    }

    public void start() {
        view.display("Welcome to Bibilioteca -- the library management system");
        String option;
        do {
            view.displayMenu();
            option = view.acceptInput();
            switch (option) {
                case "1":
                    view.display(allAvailableBookList);
                    break;
                case "2":
                    view.display("Enter the name of the book to borrow");
                    String UsersChoice = view.acceptInput();
                    checkOutBook(UsersChoice);
                    break;
                case "0":
                    view.display("The application is quiting !!! Thank You");
                    break;
                default:
                    view.display("Select a valid option!");
                    break;
            }

        } while (!option.equals("0"));

    }

    void checkOutBook(String usersChoice) {
        for (int index = 0; index < allAvailableBookList.size(); index++) {
            HashMap book = allAvailableBookList.get(index);
            if(usersChoice.equalsIgnoreCase((String) book.get("Title")))
                checkedOutBookList.add(book);
                allAvailableBookList.remove(book);
            }
        }

    public ArrayList<HashMap<String, String>> getAllAvailableBook() {
        return allAvailableBookList;
    }

    public ArrayList<HashMap<String, String>> getCheckedOutBook() {
        return checkedOutBookList;
    }
}