package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library
{
    private final Map<String, Book> bookCollection;
    private final Map<String, Book> borrowedBooks;

    public Library() {

        this.bookCollection = new HashMap<>();
        this.borrowedBooks = new HashMap<>();
    }

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book should not be null");
        }

        String isbn = book.getIsbn();
        if (bookCollection.containsKey(isbn)) {
            throw new IllegalStateException("Book with this ISBN already exists in the library");
        }

        bookCollection.put(isbn, book);
    }

    public void borrowBook(String isbn) {
        if (isbn == null || isbn.isEmpty()) {
            throw new IllegalArgumentException("ISBN cannot be null or empty");
        }
        if (borrowedBooks.containsKey(isbn)) {
            throw new IllegalStateException("Book is already borrowed");
        }
        Book book = bookCollection.get(isbn);
        if (book == null) {
            throw new IllegalArgumentException("Book not found");
        }

        bookCollection.remove(isbn);
        borrowedBooks.put(isbn, book);
    }

    public void returnBook(String isbn) {
        if (isbn == null || isbn.isEmpty()) {
            throw new IllegalArgumentException("ISBN cannot be null or empty");
        }
        Book book = borrowedBooks.get(isbn);

        if (book == null) {
            throw new IllegalArgumentException("Book was not borrowed");
        }

        borrowedBooks.remove(isbn);
        bookCollection.put(isbn, book);
    }
    public void viewAvailableBooks() {


        List<Book> availableBooks = new ArrayList<>(bookCollection.values());
        for (Book book : availableBooks) {
            System.out.println("Book Isbn : " + book.getIsbn() + ", Book Title: " + book.getTitle() +
                    ",Book Author: " + book.getAuthor() + ",Book Publish Year: " + book.getPublicationYear());
        }
    }
}