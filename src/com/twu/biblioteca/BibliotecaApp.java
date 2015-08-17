package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

public class BibliotecaApp {

    private View view;
    private AuthenticateUser authenticateUser;
    private ArrayList<HashMap<String, String>> allAvailableBookList;
    private ArrayList<HashMap<String, String>> allAvailableMovieList;
    private ArrayList<HashMap<String, String>> checkedOutBookList = new ArrayList<>();
    private ArrayList<HashMap<String, String>> checkedOutMovieList = new ArrayList<>();

    public BibliotecaApp(View view, ArrayList<HashMap<String, String>> bookList, ArrayList<HashMap<String, String>> movieList, AuthenticateUser authenticateUser) {
        this.view = view;
        this.allAvailableBookList = bookList;
        this.allAvailableMovieList = movieList;
        this.authenticateUser = authenticateUser;
    }

    public void start() {
        view.display("Welcome to Bibilioteca -- the library management system");
        String option;
        do {
            view.displayLoginScreen();
            option = view.acceptInput();
            User user;
            switch (option) {
                case "1":
                    user = view.acceptIdAndPassword();
                    user = authenticateUser.isLibrarian(user);
                    if (user != null)
                        performLibrarianOperations(user);
                    else
                        view.display("not a librarian");
                    break;
                case "2":
                    user = view.acceptIdAndPassword();
                    user = authenticateUser.isNormalUser(user);
                    if (user != null)
                        performUserOperations(user);
                    else
                        view.display("not valid user");
                    break;
                case "0":
                    view.display("application is quiting !! thank you");
                    break;
                default:
                    view.display("Invalid option entered");
                    break;
            }
        } while (!option.equals("0"));
    }

    void performUserOperations(User user) {
        String option;
        do {
            view.displayUserMenu();
            option = view.acceptInput();
            switch (option) {
                case "1":
                    view.displayBookList(allAvailableBookList);
                    view.displaySeparator();
                    break;
                case "2":
                    view.display("Enter the name of the book to borrow");
                    String usersChoice = view.acceptInput();
                    if (checkOutBook(user, usersChoice))
                        view.display("Thank you! Enjoy the book");
                    else
                        view.display("That book is not available");
                    view.displaySeparator();
                    break;
                case "3":
                    view.display("Enter the name of the book to return");
                    usersChoice = view.acceptInput();
                    if (checkInBook(user, usersChoice))
                        view.display("Thank you for returning the book.");
                    else
                        view.display("That is not a valid book to return");
                    view.displaySeparator();
                    break;
                case "4":
                    view.displayMovieList(allAvailableMovieList);
                    view.displaySeparator();
                    break;
                case "5":
                    view.display("Enter the movie to enjoy");
                    usersChoice = view.acceptInput();
                    if (checkOutMovie(user, usersChoice))
                        view.display("Thank you! Enjoy the movie");
                    else
                        view.display("That movie is not available");
                    view.displaySeparator();
                    break;
                case "6":
                    view.display("Enter the name of the movie to return");
                    usersChoice = view.acceptInput();
                    if (checkInMovie(user, usersChoice))
                        view.display("Thank you for returning the movie.");
                    else
                        view.display("That is not a valid movie to return");
                    view.displaySeparator();
                    break;
                case "7":
                    view.display("libraryId       username        emailId         number\n ");
                    view.displayUserInformation(user);
                    view.displaySeparator();
                    break;
                case "0":
                    view.display("You are logging out !!! Thank You");
                    start();
                    break;
                default:
                    view.display("Select a valid option!");
                    view.displaySeparator();
                    break;
            }

        } while (!option.equals("0"));

    }

    void performLibrarianOperations(User librarian) {
        String option;
        do {
            view.displayLibrarianMenu();
            option = view.acceptInput();
            switch (option) {
                case "1":
                    view.displayBookList(allAvailableBookList);
                    view.displaySeparator();
                    break;
                case "2":
                    view.display("Enter the name of the book to borrow");
                    String usersChoice = view.acceptInput();
                    if (checkOutBook(librarian, usersChoice))
                        view.display("Thank you! Enjoy the book");
                    else
                        view.display("That book is not available");
                    view.displaySeparator();
                    break;
                case "3":
                    view.display("Enter the name of the book to return");
                    usersChoice = view.acceptInput();
                    if (checkInBook(librarian, usersChoice))
                        view.display("Thank you for returning the book.");
                    else
                        view.display("That is not a valid book to return");
                    view.displaySeparator();
                    break;
                case "4":
                    view.displayCheckedOutBookList(checkedOutBookList);
                    view.displaySeparator();
                    break;
                case "5":
                    view.displayMovieList(allAvailableMovieList);
                    view.displaySeparator();
                    break;
                case "6":
                    view.display("Enter the movie to enjoy");
                    usersChoice = view.acceptInput();
                    if (checkOutMovie(librarian, usersChoice))
                        view.display("Thank you! Enjoy the movie");
                    else
                        view.display("That movie is not available");
                    view.displaySeparator();
                    break;
                case "7":
                    view.display("Enter the name of the movie to return");
                    usersChoice = view.acceptInput();
                    if (checkInMovie(librarian, usersChoice))
                        view.display("Thank you for returning the movie.");
                    else
                        view.display("That is not a valid movie to return");
                    view.displaySeparator();
                    break;
                case "8":
                    view.displayCheckedOutMovieList(checkedOutMovieList);
                    view.displaySeparator();
                    break;
                case "9":
                    view.display("libraryId       username        emailId         number\n ");
                    view.displayUserInformation(librarian);
                    view.displaySeparator();
                    break;
                case "10":
                    view.display("libraryId       username        emailId         number\n ");
                    for (int index = 0; index < authenticateUser.getAllRegisteredUsers().size(); index++) {
                        view.displayEveryUserInformation(authenticateUser.getDetailsOfAllUsers(index));
                    }
                    view.displaySeparator();
                    break;
                case "0":
                    view.display("You are logging out !!! Thank You");
                    break;
                default:
                    view.display("Select a valid option!");
                    view.displaySeparator();
                    break;
            }

        } while (!option.equals("0"));

    }

    Boolean checkInBook(User user, String usersChoice) {
        for (int index = 0; index < checkedOutBookList.size(); index++) {
            HashMap book = checkedOutBookList.get(index);
            if (usersChoice.equalsIgnoreCase(String.valueOf(book.get("Title")))) {
                if (user.getLibraryId().equals(book.get("libraryId"))) {
                    allAvailableBookList.add(book);
                    checkedOutBookList.remove(book);
                    return true;
                }
            }
        }
        return false;
    }

    Boolean checkOutBook(User user, String usersChoice) {
        for (int index = 0; index < allAvailableBookList.size(); index++) {
            HashMap book = allAvailableBookList.get(index);
            if (usersChoice.equalsIgnoreCase(String.valueOf(book.get("Title")))) {
                book.put("libraryId", user.getLibraryId());
                checkedOutBookList.add(book);
                allAvailableBookList.remove(book);
                return true;
            }
        }
        return false;

    }

    Boolean checkOutMovie(User user, String usersChoice) {
        for (int index = 0; index < allAvailableMovieList.size(); index++) {
            HashMap movie = allAvailableMovieList.get(index);
            if (usersChoice.equalsIgnoreCase(String.valueOf(movie.get("Name")))) {
                movie.put("libraryId", user.getLibraryId());
                checkedOutMovieList.add(movie);
                allAvailableMovieList.remove(movie);
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

    public ArrayList<HashMap<String, String>> getCheckedOutMovie() {
        return checkedOutMovieList;
    }

    public boolean checkInMovie(User user, String usersChoice) {
        for (int index = 0; index < checkedOutMovieList.size(); index++) {
            HashMap movie = checkedOutMovieList.get(index);
            if (usersChoice.equalsIgnoreCase(String.valueOf(movie.get("Name")))) {
                if (usersChoice.equalsIgnoreCase(String.valueOf(movie.get("Title")))) {
                    movie.put("libraryId", user.getLibraryId());
                    allAvailableMovieList.add(movie);
                    checkedOutMovieList.remove(movie);
                    return true;
                }
            }
        }
        return false;
    }
}