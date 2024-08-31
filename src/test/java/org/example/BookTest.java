package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    // create sample Book
    Book book = new Book("9783161484100", "Ramayana", "Valmiki", 2011);

    // Test Case : 1 ISBN is not null
    @Test
    public void testIsbnNotNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Book(null, "Ramayana", "Valmiki", 2011));
        assertEquals("Isbn should not be  null", exception.getMessage());
    }

    // Test case : 2 ISBN not empty
    @Test
    public void testIsbnIsEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Book("", "Ramayana", "Valmiki", 2011));
        assertEquals("ISBN should not be  empty", exception.getMessage());
    }

    // Test case : 3 Title is Not Null
    @Test
    public void testTitleNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Book("9788129119183", null, "Valmiki", 2011));
        assertEquals("Title should not be null or empty", exception.getMessage());
    }

    // Test case : 4 Title is Not Empty
    @Test
    public void testTitleIsEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Book("9788129119183", "", "Valmiki", 2011));
        assertEquals("Title should not be null or empty", exception.getMessage());
    }

    // Test case : 5 Author is Not Null
    @Test
    public void testAuthorIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Book("9788129119183", "Ramayana", null, 2011));
        assertEquals("Author should not be null or empty", exception.getMessage());
    }

    // Test case : 6 Author is Not Empty
    @Test
    public void testAuthorIsEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Book("9788129119183", "Ramayana", "", 2011));
        assertEquals("Author should not be null or empty", exception.getMessage());
    }

    // Test case : 7 Publication Year being zero
    @Test
    public void testPublicationYearIsZero() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Book("9788129119183", "Ramayana", "Valmiki", 0));
        assertEquals("Publication year should be a positive integer", exception.getMessage());
    }

    // Test case : 7 Publication Year being zero
    @Test
    public void testPublicationYearIsNegative() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Book("9788129119183", "Ramayana", "Valmiki", -2011));
        assertEquals("Publication year should be a positive integer", exception.getMessage());
    }



}