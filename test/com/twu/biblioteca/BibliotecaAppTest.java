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
    public void shouldBeAbleToDisplayBookListWhenUserEnters1() {
        View view = mock(View.class);
        ArrayList<HashMap<String, String>> bookList = new ArrayList<>();
        BibliotecaApp application = new BibliotecaApp(view, bookList);
        when(view.acceptInput()).thenReturn("1").thenReturn("0");
        application.start();
        verify(view).display(bookList);
    }

    @Test
    public void shouldBeAbleToDisplayBookListWhenUserEnters0() {
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

        assertEquals(ExpectedCheckList , ActualCheckList);

    }
}