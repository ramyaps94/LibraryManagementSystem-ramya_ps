package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ArrayList<HashMap<String, String>> bookList = new ArrayList<>();
        ArrayList<HashMap<String, String>> movieList = new ArrayList<>();
        ArrayList<User> allRegisteredUsers = new ArrayList<>();
        ArrayList<User> registeredLibrarian = new ArrayList<>();
        View view = new View();
        User user1 = new User("123-4567", "12345678", "user1", "user1@mail.com", "111111111");
        User user2 = new User("abc-defg", "12345678", "user2", "user2@mail.com", "222222222");
        User user3 = new User("xyz-abcd", "12345678", "user3", "user3@mail.com", "333333333");
        User librarian= new User("xxx-xxxx", "12345678", "librarian", "admin@mail.com", "123333809");
        allRegisteredUsers.add(user1);
        allRegisteredUsers.add(user2);
        allRegisteredUsers.add(user3);
        registeredLibrarian.add(librarian);
        AuthenticateUser authenticateUser = new AuthenticateUser(allRegisteredUsers, registeredLibrarian);
        HashMap<String, String> book1 = new HashMap<>();
        book1.put("Title", "Wings Of Fire");
        book1.put("Author", "Abdhul Kalam");
        book1.put("year", "1995");
        HashMap<String, String> book2 = new HashMap<>();
        book2.put("Title", "What young India Wants");
        book2.put("Author", "Chethan Bhaghat");
        book2.put("year", "2015");
        bookList.add(book1);
        bookList.add(book2);
        HashMap<String, String> movie1 = new HashMap<>();
        movie1.put("Name", "3 Idiots");
        movie1.put("Year", "2011");
        movie1.put("Director", "xyz");
        movie1.put("Rating", "9");
        HashMap<String, String> movie2 = new HashMap<>();
        movie2.put("Name", "pk");
        movie2.put("Year", "2015");
        movie2.put("Director", "abc");
        movie2.put("Rating", "8");
        movieList.add(movie1);
        movieList.add(movie2);
        BibliotecaApp application = new BibliotecaApp(view, bookList, movieList,authenticateUser);
        application.start();
    }
}