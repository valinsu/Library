package com.example.library.repository;

import com.example.library.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryBookDao {
    private final List<Book> BOOK = new ArrayList<>();

    public List<Book> findAllBook() {
        return BOOK;
    }

    public Book createBook(Book book) {
        BOOK.add(book);
        return book;
    }

    public Book findById(Long id) {
     return BOOK.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }


    public Book findByIsbn(String isbn) {
        return BOOK.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }

    public Book updateBook(Book book) {
        var bookIndex = IntStream.range(0, BOOK.size())
                .filter(index -> BOOK.get(index).getIsbn().equals(book.getIsbn()))
                .findFirst()
                .orElse(-1);
        if(bookIndex > -1){
            BOOK.set(bookIndex, book);
            return book;
        }
        return null;
    }

    public void deleteBook(String isbn) {
        var book = findByIsbn(isbn);
        if(book != null){
            BOOK.remove(book);
        }
    }
}
