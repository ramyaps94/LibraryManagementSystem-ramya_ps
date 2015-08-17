package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;


import static org.junit.Assert.assertEquals;

public class ViewTest {
    private ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
    PrintStream original;

    @Before
    public void setsUpStream() {
        System.setOut(new PrintStream(outputContent));
        original = System.out;
    }

    @After
    public void cleansUpStream() {
        System.setOut(original);
    }

    @Test
    public void shouldKnowTheOutputGivenOnScreen() {
        View view = new View();
        view.display("Welcome to Bibilioteca -- the library management system");
        String message = "Welcome to Bibilioteca -- the library management system\n";

        assertEquals(message, outputContent.toString());
    }

    @Test
    public void shouldKnowTheOutputGivenOnScreenWithParticularFormatForBooks() {
        ArrayList<HashMap<String, String>> bookList = new ArrayList<>();
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

        View view = new View();
        view.displayBookList(bookList);

        assertEquals("List of books are\n" +
                "                         title                        author                          year\n" +
                "\n" +
                "==============================================================================================\n" +
                "                 Wings Of Fire                  Abdhul Kalam                          1995\n" +
                "        What young India Wants               Chethan Bhaghat                          2015\n", outputContent.toString());

    }

    @Test
    public void shouldKnowTheOutputGivenOnScreenWithParticularFormatForMovies() {
        ArrayList<HashMap<String, String>> movieList = new ArrayList<>();
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
        View view = new View();
        view.displayMovieList(movieList);

        assertEquals("List of movies are\n" +
                "                          name                          year                      director                        rating\n" +
                "\n" +
                "=============================================================================================================================\n" +
                "                      3 Idiots                          2011                           xyz                             9\n" +
                "                            pk                          2015                           abc                             8\n", outputContent.toString());

    }

    @Test
    public void shouldTakeUserInput() {
        View view = new View();
        String input = "add 5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("add 5", view.acceptInput());
    }
}