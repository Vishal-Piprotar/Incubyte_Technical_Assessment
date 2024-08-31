package org.example;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private final Map<String, Book> bookInventory;
    private final Map<String, Book> borrowedBooks;

    public Library() {
        this.bookInventory = new HashMap<>();
        this.borrowedBooks = new HashMap<>();
    }

    public boolean addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book should not be null");
        }

        String isbn = book.getIsbn();
        // Check if the book already exists in the inventory
        if (bookInventory.containsKey(isbn)) {
            return false;
        }

        bookInventory.put(isbn, book);
        return true;
    }

    public boolean borrowBook(String isbn) {
        // Check if the book exists in the inventory and is not already borrowed
        if (bookInventory.containsKey(isbn)) {
            Book book = bookInventory.remove(isbn);
            borrowedBooks.put(isbn, book);
            return true;
        }
        return false;
    }
}
