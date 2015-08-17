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

    public void displayLibrarianMenu() {
        System.out.println("Menu options are");
        System.out.println("Enter 1 to list all the available books");
        System.out.println("Enter 2 to check out books");
        System.out.println("Enter 3 to check in books");
        System.out.println("Enter 4 to list the checked out books");
        System.out.println("Enter 5 to list all the movie list");
        System.out.println("Enter 6 to check out movie");
        System.out.println("Enter 7 to check in movie");
        System.out.println("Enter 8 to list all the checked out movies");
        System.out.println("Enter 9 to display profile details of librarian");
        System.out.println("Enter 10 to details of all users");
        System.out.println("Enter 0 to logout");
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

    public void displaySeparator() {
        System.out.println("                                                                                                                              ");
        System.out.println("==============================================================================================================================");
        System.out.println("                                                                                                                              ");

    }

    public void displayLoginScreen() {
        System.out.println("Enter 1 to login as librarian");
        System.out.println("Enter 2 to login as user");
        System.out.println("Enter 0 to quit");
    }

    public void displayUserMenu() {
        System.out.println("Menu options are");
        System.out.println("Enter 1 to list all the available books");
        System.out.println("Enter 2 to check out books");
        System.out.println("Enter 3 to check in books");
        System.out.println("Enter 4 to list all the movie list");
        System.out.println("Enter 5 to check out movie");
        System.out.println("Enter 6 to check in movie");
        System.out.println("Enter 7 to display profile user details");
        System.out.println("Enter 0 to logout");
    }

    public User acceptIdAndPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Id");
        String id = scanner.nextLine();
        System.out.println("Enter Password");
        String password = scanner.nextLine();
        return new User(id, password);
    }

    public void displayUserInformation(User user) {
        System.out.println(user.getDetails());
    }

    public void displayCheckedOutBookList(ArrayList<HashMap<String, String>> checkedOutBookList) {
        System.out.println("List of checked out books are");
        String header = String.format("%30s%30s%30s%30s\n", "title", "author", "year", "libraryId");
        System.out.println(header);
        System.out.println("===========================================================================================================================");
        for (HashMap<String, String> book : checkedOutBookList) {
            String FormattedBook = String.format("%30s%30s%30s%30s", book.get("Title"), book.get("Author"), book.get("year"), book.get("libraryId"));
            System.out.println(FormattedBook);
        }
    }

    public void displayCheckedOutMovieList(ArrayList<HashMap<String, String>> checkedOutMovieList) {
        System.out.println("List of movies are");
        String header = String.format("%30s%30s%30s%30s%30s\n", "name", "year", "director", "rating", "libraryId");
        System.out.println(header);
        System.out.println("==========================================================================================================================================");
        for (HashMap<String, String> movie : checkedOutMovieList) {
            String FormattedMovie = String.format("%30s%30s%30s%30s%30s", movie.get("Name"), movie.get("Year"), movie.get("Director"), movie.get("Rating"), movie.get("libraryId"));
            System.out.println(FormattedMovie);
        }
    }

    public void displayEveryUserInformation(User detailsOfAllUsers) {
        System.out.println(detailsOfAllUsers.getDetails());
    }
}
