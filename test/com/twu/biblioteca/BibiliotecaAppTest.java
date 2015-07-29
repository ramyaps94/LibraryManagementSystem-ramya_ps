package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BibiliotecaAppTest {
    @Test
    public void shouldBeAbleToMockTheView() {
        View view = mock(View.class);
        BibliotecaApp application = new BibliotecaApp(view);
        application.start();
        verify(view).display();
    }
}