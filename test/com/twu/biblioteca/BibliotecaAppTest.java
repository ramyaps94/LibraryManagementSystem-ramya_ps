package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.mockito.Mockito.*;

public class BibliotecaAppTest {

    @Test
    public void shouldBeAbleToDisplayMessagesToTheUser() {
        View view = mock(View.class);
        when(view.acceptInput()).thenReturn("2");
        ArrayList<HashMap<String, String>> bookList = new ArrayList<HashMap<String, String>>();
        BibliotecaApp application = new BibliotecaApp(view ,bookList);
        application.start();
        verify(view).display("Welcome to Bibilioteca -- the library management system");
        verify(view).display("Menu options are");
        verify(view).display("Enter 1 to list the books");

    }

    @Test
    public void shouldBeAbleToDisplaySuggestionToUserWhenHeEntersOtherThan1() {
        View view = mock(View.class);
        ArrayList<HashMap<String, String>> bookList = new ArrayList<HashMap<String, String>>();
        BibliotecaApp application = new BibliotecaApp(view ,bookList);
        when(view.acceptInput()).thenReturn("2");
        application.start();
        verify(view).display("Enter 1 to display list of books");
    }

    @Test
    public void shouldBeAbleToDisplayBookListWhenUserEnters1() {
        View view = mock(View.class);
        ArrayList<HashMap<String, String>> bookList = new ArrayList<HashMap<String, String>>();
        BibliotecaApp application = new BibliotecaApp(view,bookList);
        when(view.acceptInput()).thenReturn("1");
        application.start();
        verify(view).display(bookList);
    }
}