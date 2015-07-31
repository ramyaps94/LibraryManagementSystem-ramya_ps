package com.twu.biblioteca;

import java.util.*;

public class View {

    public void display(ArrayList<HashMap <String , String > > bookList) {
        System.out.println("List of books are");
        String header = String.format("%30s%30s%30s\n","title","author","year");
        System.out.println(header);
        System.out.println("==============================================================================================");
        for (HashMap<String , String> book : bookList) {
            String FormattedBook=String.format("%30s%30s%30s", book.get("Title"), book.get("Author"), book.get("year"));
            System.out.println(FormattedBook);
        }
    }

    public void display(String s) {
        System.out.println(s);
    }

    public String acceptInput() {
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        return option;
    }

    public void displayMenu() {
        System.out.println("Menu options are");
        System.out.println("Enter 1 to list the books");
        System.out.println("Enter 0 to quit");
        System.out.println("Enter 2 to check out books");
    }
}
