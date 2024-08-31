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

        //4. Attempt to borrow with null or empty ISBNs
        IllegalArgumentException exception3 = assertThrows(IllegalArgumentException.class, () -> library.borrowBook(null));
        assertEquals("ISBN cannot be null or empty", exception1.getMessage());

        IllegalArgumentException exception4 = assertThrows(IllegalArgumentException.class, () -> library.borrowBook(""));
        assertEquals("ISBN cannot be null or empty", exception2.getMessage());
    }

    @Test
    public void testReturnBook() {

        Book book = new Book("9783161484100", "Ramayana", "Valmiki", 2011);
        library.addBook(book);

        // 1. Borrow the book and then return it
        library.borrowBook(book.getIsbn());
        library.returnBook(book.getIsbn());

        //2. Attempt to return a book that was never borrowed
        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> library.returnBook("97831611111111"));
        assertEquals("Book was not borrowed", exception2.getMessage());

        // 3. trying to return book with null or empty ISBNs
        IllegalArgumentException exception3 = assertThrows(IllegalArgumentException.class, () -> library.returnBook(null));
        assertEquals("ISBN cannot be null or empty", exception3.getMessage());

        IllegalArgumentException exception4 = assertThrows(IllegalArgumentException.class, () -> library.returnBook(""));
        assertEquals("ISBN cannot be null or empty", exception4.getMessage());

    }
}
