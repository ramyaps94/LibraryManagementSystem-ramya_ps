package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

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
                    String usersChoice = view.acceptInput();
                    if (checkOutBook(usersChoice))
                        view.display("Thank you! Enjoy the book");
                    else
                        view.display("That book is not available");
                    break;
                case "3":
                    view.display("Enter the name of the book to return");
                    usersChoice = view.acceptInput();
                    checkInBook(usersChoice);
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

    void checkInBook(String usersChoice) {
        for (int index = 0; index < checkedOutBookList.size(); index++) {
            HashMap book = checkedOutBookList.get(index);
            if (usersChoice.equalsIgnoreCase(String.valueOf(book.get("Title")))) {
                allAvailableBookList.add(book);
                checkedOutBookList.remove(book);
            }
        }

    }

    Boolean checkOutBook(String usersChoice) {
        for (int index = 0; index < allAvailableBookList.size(); index++) {
            HashMap book = allAvailableBookList.get(index);
            if (usersChoice.equalsIgnoreCase(String.valueOf(book.get("Title")))) {
                checkedOutBookList.add(book);
                allAvailableBookList.remove(book);
                return true;
            }
        }
            return false;

    }

    public ArrayList<HashMap<String, String>> getAllAvailableBook() {
        return allAvailableBookList;
    }

    public ArrayList<HashMap<String, String>> getCheckedOutBook() {
        return checkedOutBookList;
    }
}