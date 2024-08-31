package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    Library library = new Library();

//    Test Case : 1 Add Book
@Test
public void testAddBook() {
    Book validBook = new Book("9783161484100", "Ramayana", "Valmiki", 2011);
    assertTrue(library.addBook(validBook));

    // Test adding the same book again (should return false)
    assertFalse(library.addBook(validBook));
}

    @Test
    public void testAddNullBook() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> library.addBook(null));
        assertEquals("Book should not be null", exception.getMessage());
    }

    @Test
    public void testAddDuplicateBook() {
        Book book1 = new Book("9781612680195", "ABCD", "Robert T. Kiyosaki", 1997);
        Book book2 = new Book("9781612680195", "BCDA", "Another Author", 2020);

        assertTrue(library.addBook(book1));
        assertFalse(library.addBook(book2));
    }

    @Test
    public void testBorrowBook() {
        Book book = new Book("9783161484100", "Ramayana", "Valmiki", 2011);
        library.addBook(book);
        // Borrowing book here
        library.borrowBook(book.getIsbn());

    }

}