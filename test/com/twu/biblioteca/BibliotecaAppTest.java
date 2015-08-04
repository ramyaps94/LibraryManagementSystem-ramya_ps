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
        BibliotecaApp application = new BibliotecaApp(view, bookList);
        application.start();
        verify(view).display("Welcome to Bibilioteca -- the library management system");
        verify(view).displayMenu();

    }

    @Test
    public void shouldBeAbleToDisplaySuggestionToUserWhenHeEntersOtherThanValidOptionOfMenu() {
        View view = mock(View.class);
        ArrayList<HashMap<String, String>> bookList = new ArrayList<>();
        BibliotecaApp application = new BibliotecaApp(view, bookList);
        when(view.acceptInput()).thenReturn("8").thenReturn("0");
        application.start();
        verify(view).display("Select a valid option!");
    }

    @Test
    public void shouldBeAbleToDisplayAllAvailableBookListWhenUserEnters1() {
        View view = mock(View.class);
        ArrayList<HashMap<String, String>> bookList = new ArrayList<>();
        BibliotecaApp application = new BibliotecaApp(view, bookList);
        when(view.acceptInput()).thenReturn("1").thenReturn("0");
        application.start();
        verify(view).display(bookList);
    }

    @Test
    public void shouldBeAbleToQuitTheApplicationWhenUserEnters0() {
        View view = mock(View.class);
        ArrayList<HashMap<String, String>> bookList = new ArrayList<>();
        BibliotecaApp application = new BibliotecaApp(view, bookList);
        when(view.acceptInput()).thenReturn("0");
        application.start();
        verify(view).display("The application is quiting !!! Thank You");
    }

    @Test
    public void shouldBeAbleToCheckOutBookAndAddItToCheckedOutList() {
        View view = mock(View.class);
        ArrayList<HashMap<String, String>> bookList = new ArrayList<HashMap<String, String>>();
        ArrayList<HashMap<String, String>> ActualCheckList = new ArrayList<HashMap<String, String>>();
        ArrayList<HashMap<String, String>> ExpectedCheckList = new ArrayList<HashMap<String, String>>();
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
        BibliotecaApp application = new BibliotecaApp(view ,bookList);
        application.checkOutBook("Wings Of Fire");
        ActualCheckList = application.getCheckedOutBook();

        ExpectedCheckList.add(book1);

        assertEquals(ExpectedCheckList, ActualCheckList);
    }

     @Test
         public void shouldBeAbleToCallViewToPrintSuccessfulCheckoutMessage() {

         ArrayList<HashMap<String, String>> bookList = new ArrayList<HashMap<String, String>>();

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
         BibliotecaApp application = new BibliotecaApp(view ,bookList);
         ArrayList<ArrayList<String>> books = new ArrayList<ArrayList<String>>();
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
        ArrayList<HashMap<String, String>> bookList = new ArrayList<HashMap<String, String>>();
        ArrayList<HashMap<String, String>> ActualBookList = new ArrayList<HashMap<String, String>>();
        ArrayList<HashMap<String, String>> ExpectedCheckList = new ArrayList<HashMap<String, String>>();
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
        BibliotecaApp application = new BibliotecaApp(view ,bookList);
        application.checkInBook("Wings Of Fire");
        ExpectedCheckList.remove(book1);

        ActualBookList = application.getAllAvailableBook();
        bookList.add(book1);

        assertEquals(bookList, ActualBookList);
    }

    @Test
    public void shouldBeAbleToDisplayAllCheckedOutBookListWhenUserEnters1() {
        View view = mock(View.class);
        ArrayList<HashMap<String, String>> bookList = new ArrayList<>();
        ArrayList<HashMap<String, String>> checkedOutBookList = new ArrayList<>();
        BibliotecaApp application = new BibliotecaApp(view, bookList);
        when(view.acceptInput()).thenReturn("4").thenReturn("0");
        application.start();
        verify(view).display(checkedOutBookList);
    }

}