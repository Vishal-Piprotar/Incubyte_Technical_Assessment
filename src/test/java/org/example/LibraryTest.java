package org.example;

import org.junit.jupiter.api.Test; // Use JUnit 5 import

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    Library library = new Library();

    @Test
    public void testAddBook() {
        // 1. Test case for addition of a valid Book
        Book validBook = new Book("9783161484100", "Ramayana", "Valmiki", 2011);
        library.addBook(validBook);

        // 2. Test case for adding a null book
        Exception exception = assertThrows(IllegalArgumentException.class, () -> library.addBook(null));
        assertEquals("Book should not be null", exception.getMessage());

        // 3. Test case for adding a book with duplicate ISBN
        Book duplicateBook = new Book("9783161484100", "Second Book", "Another Author", 2024);
        Exception duplicateException = assertThrows(IllegalStateException.class, () -> library.addBook(duplicateBook));
        assertEquals("Book with this ISBN already exists in the library", duplicateException.getMessage());
    }

    @Test
    public void testBorrowBook() {
        Book book = new Book("9783161484100", "Ramayana", "Valmiki", 2011);
        library.addBook(book);

        IllegalStateException exception1 = assertThrows(IllegalStateException.class, () -> library.borrowBook(book.getIsbn()));
        assertEquals("Book is already borrowed", exception1.getMessage());


        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> library.borrowBook("544554545445"));
        assertEquals("Book not found", exception2.getMessage());
    }
}
