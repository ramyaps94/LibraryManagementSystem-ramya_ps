package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BibliotecaAppTest {
    AuthenticateUser authenticateUser;
    ArrayList<User> allRegisteredUsers = new ArrayList<>();
    ArrayList<User> registeredLibrarian = new ArrayList<>();

    @Before
    public void setUp() {
        User user1 = new User("123-4567", "12345678", "user1", "123-4567", "1235678");
        User user2 = new User("123-4567", "12345678", "user1", "abc-defg", "1235678");
        User user3 = new User("123-4567", "12345678", "user1", "xyz-abcd", "1235678");
        User librarian = new User("123-4567", "12345678", "user1", "xxx-xxxx", "12345678");
        allRegisteredUsers.add(user1);
        allRegisteredUsers.add(user2);
        allRegisteredUsers.add(user3);
        registeredLibrarian.add(librarian);
        authenticateUser = new AuthenticateUser(allRegisteredUsers, registeredLibrarian);
    }

    @Test
    public void shouldBeAbleToDisplayWelcomeMessagesToTheUser() {
        View view = mock(View.class);
        AuthenticateUser authenticate = mock(AuthenticateUser.class);

        when(view.acceptInput()).thenReturn("0");

        ArrayList<HashMap<String, String>> bookList = new ArrayList<>();
        ArrayList<HashMap<String, String>> movieList = new ArrayList<>();

        BibliotecaApp application = new BibliotecaApp(view, bookList, movieList, authenticate);
        when(view.acceptInput()).thenReturn("0");

        application.start();
        verify(view).display("Welcome to Bibilioteca -- the library management system");
        verify(view).displayLoginScreen();

    }

    @Test
    public void shouldBeAbleToDisplaySuggestionToUserOrLibrarianWhenHeEntersOtherThanValidOptionOfMenu() {
        View view = mock(View.class);
        ArrayList<HashMap<String, String>> bookList = new ArrayList<>();
        ArrayList<HashMap<String, String>> movieList = new ArrayList<>();
        BibliotecaApp application = new BibliotecaApp(view, bookList, movieList, authenticateUser);
        when(view.acceptInput()).thenReturn("20").thenReturn("0");
        application.start();
        verify(view).display("Welcome to Bibilioteca -- the library management system");
        verify(view, atLeast(1)).displayLoginScreen();
        verify(view).display("Invalid option entered");
    }

    @Test
    public void shouldBeAbleToQuitTheApplicationWhenUserOrLibrarianEnters0() {
        View view = mock(View.class);
        ArrayList<HashMap<String, String>> bookList = new ArrayList<>();
        ArrayList<HashMap<String, String>> movieList = new ArrayList<>();
        BibliotecaApp application = new BibliotecaApp(view, bookList, movieList, authenticateUser);
        when(view.acceptInput()).thenReturn("0");
        application.start();
        verify(view).display("application is quiting !! thank you");
    }

    @Test
    public void shouldBeAbleToDisplayAllAvailableBookListWhenUserOrLibrarianEnters1() {
        View view = mock(View.class);
        User user = new User("xxx-xxxx", "12345678", "librarian", "admin@mail.com", "123333809");
        ArrayList<HashMap<String, String>> bookList = new ArrayList<>();
        ArrayList<HashMap<String, String>> movieList = new ArrayList<>();
        BibliotecaApp application = new BibliotecaApp(view, bookList, movieList, authenticateUser);
        when(view.acceptInput()).thenReturn("1").thenReturn("0");
        application.performLibrarianOperations(user);
        verify(view).displayBookList(bookList);
    }

    @Test
    public void shouldBeAbleToCheckOutBookAndAddItToCheckedOutList() {
        View view = mock(View.class);
        ArrayList<HashMap<String, String>> bookList = new ArrayList<>();
        ArrayList<HashMap<String, String>> movieList = new ArrayList<>();
        ArrayList<HashMap<String, String>> ActualCheckList;
        ArrayList<HashMap<String, String>> ExpectedCheckList = new ArrayList<>();
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
        BibliotecaApp application = new BibliotecaApp(view, bookList, movieList, authenticateUser);
        application.checkOutBook(allRegisteredUsers.get(1), "Wings Of Fire");
        ActualCheckList = application.getCheckedOutBook();

        ExpectedCheckList.add(book1);

        assertEquals(ExpectedCheckList, ActualCheckList);
    }

    @Test
    public void shouldBeAbleToCallViewToPrintSuccessfulCheckoutMessage() {

        ArrayList<HashMap<String, String>> bookList = new ArrayList<>();
        ArrayList<HashMap<String, String>> movieList = new ArrayList<>();
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
        View view = mock(View.class);
        BibliotecaApp application = new BibliotecaApp(view, bookList, movieList, authenticateUser);
        when(view.acceptInput()).thenReturn("2").thenReturn("Wings Of Fire").thenReturn("0");
        User user = new User("xxx-xxxx", "12345678", "librarian", "admin@mail.com", "123333809");
        application.performLibrarianOperations(user);

        application.checkOutBook(registeredLibrarian.get(0), "Wings Of Fire");
        verify(view).display("Enter the name of the book to borrow");
        verify(view).display("Thank you! Enjoy the book");
    }

    @Test
    public void shouldBeAbleToCallViewToPrintUnSuccessfulCheckoutMessage() {

        ArrayList<HashMap<String, String>> bookList = new ArrayList<>();
        ArrayList<HashMap<String, String>> movieList = new ArrayList<>();
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
        View view = mock(View.class);
        BibliotecaApp application = new BibliotecaApp(view, bookList, movieList, authenticateUser);
        when(view.acceptInput()).thenReturn("2").thenReturn("abc").thenReturn("0");
        User user = new User("xxx-xxxx", "12345678", "librarian", "admin@mail.com", "123333809");
        application.performLibrarianOperations(user);

        application.checkOutBook(registeredLibrarian.get(0), "abc");
        verify(view).display("Enter the name of the book to borrow");
        verify(view).display("That book is not available");
    }

    @Test
    public void shouldBeAbleToCheckInBookAndAddItToAllAvailableBookList() {
        View view = mock(View.class);
        ArrayList<HashMap<String, String>> bookList = new ArrayList<>();
        ArrayList<HashMap<String, String>> movieList = new ArrayList<>();
        ArrayList<HashMap<String, String>> ActualBookList;
        ArrayList<HashMap<String, String>> ExpectedCheckList = new ArrayList<>();
        HashMap<String, String> book1 = new HashMap<>();
        book1.put("Title", "Wings Of Fire");
        book1.put("Author", "Abdhul Kalam");
        book1.put("year", "1995");
        HashMap<String, String> book2 = new HashMap<>();
        book2.put("Title", "What young India Wants");
        book2.put("Author", "Chethan Bhaghat");
        book2.put("year", "2015");
        ExpectedCheckList.add(book1);
        ExpectedCheckList.add(book2);
        BibliotecaApp application = new BibliotecaApp(view, bookList, movieList, authenticateUser);
        application.checkInBook(allRegisteredUsers.get(0), "Wings Of Fire");
        ExpectedCheckList.remove(book1);

        ActualBookList = application.getAllAvailableBook();
        bookList.add(book1);

        assertEquals(bookList, ActualBookList);
    }

    @Test
    public void shouldBeAbleToDisplayAllCheckedOutBookListWhenLibrarianEnters4() {
        View view = mock(View.class);
        ArrayList<HashMap<String, String>> bookList = new ArrayList<>();
        ArrayList<HashMap<String, String>> movieList = new ArrayList<>();
        ArrayList<HashMap<String, String>> checkedOutBookList = new ArrayList<>();
        BibliotecaApp application = new BibliotecaApp(view, bookList, movieList, authenticateUser);
        when(view.acceptInput()).thenReturn("1").thenReturn("0");
        User user = new User("xxx-xxxx", "12345678", "librarian", "admin@mail.com", "123333809");
        application.performLibrarianOperations(user);
        verify(view).displayBookList(checkedOutBookList);
    }

    @Test
    public void shouldBeAbleToDisplayAllAvailableMovieListWhenUserOrLibrarianEnters5() {
        View view = mock(View.class);
        ArrayList<HashMap<String, String>> bookList = new ArrayList<>();
        ArrayList<HashMap<String, String>> movieList = new ArrayList<>();
        BibliotecaApp application = new BibliotecaApp(view, bookList, movieList, authenticateUser);
        when(view.acceptInput()).thenReturn("5").thenReturn("0");
        User user = new User("xxx-xxxx", "12345678", "librarian", "admin@mail.com", "123333809");
        application.performLibrarianOperations(user);
        verify(view).displayMovieList(movieList);
    }

    @Test
    public void shouldBeAbleToCheckOutMovieAndAddItToCheckedOutMovieList() {
        View view = mock(View.class);
        ArrayList<HashMap<String, String>> bookList = new ArrayList<>();
        ArrayList<HashMap<String, String>> movieList = new ArrayList<>();
        ArrayList<HashMap<String, String>> ActualCheckList;
        ArrayList<HashMap<String, String>> ExpectedCheckList = new ArrayList<>();
        HashMap<String, String> movie1 = new HashMap<>();
        movie1.put("Name", "3 Idiots");
        movie1.put("year", "2011");
        movie1.put("director", "xyz");
        movie1.put("rating", "9");
        HashMap<String, String> movie2 = new HashMap<>();
        movie2.put("Name", "pk");
        movie2.put("year", "2015");
        movie2.put("director", "abc");
        movie2.put("rating", "8");
        movieList.add(movie1);
        movieList.add(movie2);
        BibliotecaApp application = new BibliotecaApp(view, bookList, movieList, authenticateUser);
        application.checkOutMovie(allRegisteredUsers.get(1), "3 Idiots");
        ActualCheckList = application.getCheckedOutMovie();

        ExpectedCheckList.add(movie1);

        assertEquals(ExpectedCheckList, ActualCheckList);
    }

    @Test
    public void shouldBeAbleToCheckInMovieAndAddItToAllAvailableMovieList() {
        View view = mock(View.class);
        ArrayList<HashMap<String, String>> bookList = new ArrayList<>();
        ArrayList<HashMap<String, String>> movieList = new ArrayList<>();
        ArrayList<HashMap<String, String>> ActualBookList;
        ArrayList<HashMap<String, String>> ExpectedCheckList = new ArrayList<>();
        HashMap<String, String> movie1 = new HashMap<>();
        movie1.put("Name", "3 Idiots");
        movie1.put("year", "2011");
        movie1.put("director", "xyz");
        movie1.put("rating", "9");
        HashMap<String, String> movie2 = new HashMap<>();
        movie2.put("Name", "pk");
        movie2.put("year", "2015");
        movie2.put("director", "abc");
        movie2.put("rating", "8");
        movieList.add(movie1);
        movieList.add(movie2);
        BibliotecaApp application = new BibliotecaApp(view, bookList, movieList, authenticateUser);
        ExpectedCheckList.add(movie1);
        ExpectedCheckList.add(movie2);
        application.checkInMovie(allRegisteredUsers.get(0), "3 Idiots");
        ExpectedCheckList.remove(movie1);

        ActualBookList = application.getAllAvailableBook();
        movieList.add(movie1);

        assertEquals(bookList, ActualBookList);
    }

    @Test
    public void shouldBeAbleToDisplayAllCheckedOutMovieListWhenLibrarianWantsToSeeIt() {
        View view = mock(View.class);
        ArrayList<HashMap<String, String>> bookList = new ArrayList<>();
        ArrayList<HashMap<String, String>> movieList = new ArrayList<>();
        ArrayList<HashMap<String, String>> checkedOutMovieList = new ArrayList<>();
        BibliotecaApp application = new BibliotecaApp(view, bookList, movieList, authenticateUser);
        when(view.acceptInput()).thenReturn("8").thenReturn("0");
        User user = new User("xxx-xxxx", "12345678", "librarian", "admin@mail.com", "123333809");
        application.performLibrarianOperations(user);
        verify(view).displayCheckedOutMovieList(checkedOutMovieList);
    }

}