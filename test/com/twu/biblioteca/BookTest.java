package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {
    @Test
    public void shouldGiveTheDetailsOfTheBook() {
        Book book = new Book("Wings Of Fire", "Abdhul Kalam", "1970");
        String ActualValue = book.getDetails();

        String ExpectedValue ="Wings Of Fire Abdhul Kalam 1970";

        assertEquals(ExpectedValue, ActualValue);
    }
}