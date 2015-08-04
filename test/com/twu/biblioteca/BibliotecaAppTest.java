package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BibliotecaAppTest {

    @Test
    public void shouldBeAbleToDisplayMessagesToTheUser() {
        View view = mock(View.class);
        when(view.acceptInput()).thenReturn("0");
        ArrayList<HashMap<String, String>> bookList = new ArrayList<>();
        ArrayList<HashMap<String, String>> movieList = new ArrayList<>();
        BibliotecaApp application = new BibliotecaApp(view, bookList, movieList);
        application.start();
        verify(view).display("Welcome to Bibilioteca -- the library management system");
        verify(view).displayMenu();

    }

    @Test
    public void shouldBeAbleToDisplaySuggestionToUserWhenHeEntersOtherThanValidOptionOfMenu() {
        View view = mock(View.class);
        ArrayList<HashMap<String, String>> bookList = new ArrayList<>();
        ArrayList<HashMap<String, String>> movieList = new ArrayList<>();
        BibliotecaApp application = new BibliotecaApp(view, bookList, movieList);
        when(view.acceptInput()).thenReturn("8").thenReturn("0");
        application.start();
        verify(view).display("Select a valid option!");
    }

    @Test
    public void shouldBeAbleToDisplayAllAvailableBookListWhenUserEnters1() {
        View view = mock(View.class);
        ArrayList<HashMap<String, String>> bookList = new ArrayList<>();
        ArrayList<HashMap<String, String>> movieList = new ArrayList<>();
        BibliotecaApp application = new BibliotecaApp(view, bookList, movieList);
        when(view.acceptInput()).thenReturn("1").thenReturn("0");
        application.start();
        verify(view).displayBookList(bookList);
    }

    @Test
    public void shouldBeAbleToQuitTheApplicationWhenUserEnters0() {
        View view = mock(View.class);
        ArrayList<HashMap<String, String>> bookList = new ArrayList<>();
        ArrayList<HashMap<String, String>> movieList = new ArrayList<>();
        BibliotecaApp application = new BibliotecaApp(view, bookList, movieList);
        when(view.acceptInput()).thenReturn("0");
        application.start();
        verify(view).display("The application is quiting !!! Thank You");
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
        BibliotecaApp application = new BibliotecaApp(view ,bookList, movieList);
        application.checkOutBook("Wings Of Fire");
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
         BibliotecaApp application = new BibliotecaApp(view ,bookList, movieList);
         ArrayList<ArrayList<String>> books = new ArrayList<>();
         when(view.acceptInput()).thenReturn("2").thenReturn("0");
         Boolean expectedCheckOutStatus = application.checkOutBook("Wings Of Fire");
         application.start();
         verify(view).display("Enter the name of the book to borrow");
         //when(view.acceptInput()).thenReturn(String.valueOf(expectedCheckOutStatus));
         //verify(view).display("Thank you! Enjoy the book");

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
        BibliotecaApp application = new BibliotecaApp(view ,bookList, movieList);
        application.checkInBook("Wings Of Fire");
        ExpectedCheckList.remove(book1);

        ActualBookList = application.getAllAvailableBook();
        bookList.add(book1);

        assertEquals(bookList, ActualBookList);
    }

    @Test
    public void shouldBeAbleToDisplayAllCheckedOutBookListWhenUserEnters4() {
        View view = mock(View.class);
        ArrayList<HashMap<String, String>> bookList = new ArrayList<>();
        ArrayList<HashMap<String, String>> movieList = new ArrayList<>();
        ArrayList<HashMap<String, String>> checkedOutBookList = new ArrayList<>();
        BibliotecaApp application = new BibliotecaApp(view, bookList, movieList);
        when(view.acceptInput()).thenReturn("4").thenReturn("0");
        application.start();
        verify(view).displayBookList(checkedOutBookList);
    }

    @Test
    public void shouldBeAbleToDisplayAllAvailableMovieListWhenUserEnters5() {
        View view = mock(View.class);
        ArrayList<HashMap<String, String>> bookList = new ArrayList<>();
        ArrayList<HashMap<String, String>> movieList = new ArrayList<>();
        BibliotecaApp application = new BibliotecaApp(view, bookList, movieList);
        when(view.acceptInput()).thenReturn("5").thenReturn("0");
        application.start();
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
        movie2.put("Name" , "pk");
        movie2.put("year", "2015");
        movie2.put("director", "abc");
        movie2.put("rating","8");
        movieList.add(movie1);
        movieList.add(movie2);
        BibliotecaApp application = new BibliotecaApp(view ,bookList, movieList);
        application.checkOutMovie("3 Idiots");
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
        movie2.put("Name" , "pk");
        movie2.put("year", "2015");
        movie2.put("director", "abc");
        movie2.put("rating","8");
        movieList.add(movie1);
        movieList.add(movie2);
        BibliotecaApp application = new BibliotecaApp(view ,bookList, movieList);
        ExpectedCheckList.add(movie1);
        ExpectedCheckList.add(movie2);
        application.checkInMovie("3 Idiots");
        ExpectedCheckList.remove(movie1);

        ActualBookList = application.getAllAvailableBook();
        movieList.add(movie1);

        assertEquals(bookList, ActualBookList);
    }

}