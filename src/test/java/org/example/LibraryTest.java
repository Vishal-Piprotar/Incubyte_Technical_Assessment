package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    Library library = new Library();

//    Test Case : 1 Add Book
    @Test
    public  void testAddBook(){
        Book validBook = new Book("9783161484100", "Ramayana", "Valmiki", 2011);
        library.addBook(validBook);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> library.addBook(null));
        assertEquals("Book should not be null", exception.getMessage());
    }

    @Test
    public void testBorrowBook() {
        Book book = new Book("9783161484100", "Ramayana", "Valmiki", 2011);
        library.addBook(book);
        // Borrowing book here
        library.borrowBook(book.getIsbn());

    }

}