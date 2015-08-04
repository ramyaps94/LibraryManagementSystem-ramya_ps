package com.twu.biblioteca;

import java.util.*;

public class View {

    public void displayBookList(ArrayList<HashMap<String, String>> bookList) {
        System.out.println("List of books are");
        String header = String.format("%30s%30s%30s\n", "title", "author", "year");
        System.out.println(header);
        System.out.println("==============================================================================================");
        for (HashMap<String, String> book : bookList) {
            String FormattedBook = String.format("%30s%30s%30s", book.get("Title"), book.get("Author"), book.get("year"));
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
        System.out.println("Enter 1 to list all the available books");
        System.out.println("Enter 2 to check out books");
        System.out.println("Enter 3 to check in books");
        System.out.println("Enter 4 to list the checked out books");
        System.out.println("Enter 5 to list all the movie list");
        System.out.println("Enter 6 to check out movie");
        System.out.println("Enter 0 to quit");
    }

    public void displayMovieList(ArrayList<HashMap<String, String>> movieList) {
        System.out.println("List of movies are");
        String header = String.format("%30s%30s%30s%30s\n", "name", "year", "director", "rating");
        System.out.println(header);
        System.out.println("=============================================================================================================================");
        for (HashMap<String, String> movie : movieList) {
            String FormattedMovie = String.format("%30s%30s%30s%30s", movie.get("Name"), movie.get("Year"), movie.get("Director"), movie.get("Rating"));
            System.out.println(FormattedMovie);
        }
    }
}
