package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.mockito.Mockito.*;

public class BibliotecaAppTest {

    @Test
    public void shouldBeAbleToDisplayMessagesToTheUser() {
        View view = mock(View.class);
        when(view.acceptInput()).thenReturn("0");
        ArrayList<HashMap<String, String>> bookList = new ArrayList<HashMap<String, String>>();
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
}