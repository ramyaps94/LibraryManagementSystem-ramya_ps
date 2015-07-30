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
    public void shouldKnowTheOutputGivenOnScreenWithParticularFormat() {
        ArrayList<HashMap<String, String>> bookList = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> book1 = new HashMap<String, String>();
        book1.put("Title", "Wings Of Fire");
        book1.put("Author", "Abdhul Kalam");
        book1.put("year", "1995");
        HashMap<String, String> book2 = new HashMap<String, String>();
        book2.put("Title", "What young India Wants");
        book2.put("Author", "Chethan Bhaghat");
        book2.put("year", "2015");
        bookList.add(book1);
        bookList.add(book2);

        View view = new View();
        view.display(bookList);

        assertEquals("List of books are\n" +
                "                         title                        author                          year\n" +
                "\n" +
                "==============================================================================================\n" +
                "                 Wings Of Fire                  Abdhul Kalam                          1995\n" +
                "        What young India Wants               Chethan Bhaghat                          2015\n", outputContent.toString());

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