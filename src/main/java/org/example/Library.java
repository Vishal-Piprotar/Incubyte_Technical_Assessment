package org.example;

import java.util.HashMap;
import java.util.Map;

public class Library {
         private final Map<String, Book> bookInventory;

         public Library(){
            this.bookInventory = new HashMap<String, Book>();
        }


        public  void addBook(Book book){
            String isbn =book.getIsbn();
             bookInventory.put(isbn, book);
        }
}
