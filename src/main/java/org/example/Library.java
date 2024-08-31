    package org.example;

    import java.util.HashMap;
    import java.util.Map;

    public class Library {
             private final Map<String, Book> bookInventory;
        private final Map<String, Book> borrowedBooks;

             public Library(){
                this.bookInventory = new HashMap<String, Book>();
                 this.borrowedBooks = new HashMap<>();
            }


            public  void addBook(Book book){

                if (book == null) {
                    throw new IllegalArgumentException("Book should not be null");
                }

                String isbn =book.getIsbn();
                 bookInventory.put(isbn, book);
            }

        public void borrowBook(String isbn) {
            Book book = bookInventory.get(isbn);
            bookInventory.remove(isbn);
            borrowedBooks.put(isbn, book);
        }



    }
