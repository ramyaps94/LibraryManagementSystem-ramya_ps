package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

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
        view.displayWelcomeMessage();
        String message = "Welcome to Bibilioteca -- the library management system\n";

        assertEquals(message, outputContent.toString());
    }

    @Test
    public void shouldKnowTheOutputGivenOnScreenWithParticularFormat() {
        View view = new View();
        ArrayList<String> bookList =new ArrayList<String>();
        bookList.add("Wings Of Fire");
        bookList.add("Two States");
        view.displayListOfBooks(bookList);
        String message = "List of books are\n";
        message = message + bookList;
        assertEquals(message, outputContent.toString());

    }
}