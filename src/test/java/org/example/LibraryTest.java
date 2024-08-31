package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    Library library = new Library();

//    Test Case For Add Valid Book in  The Library
    @Test
    public  void testAddBook(){
        Book validBook = new Book("9783161484100", "Ramayana", "Valmiki", 2011);
        library.addBook(validBook);
    }
}