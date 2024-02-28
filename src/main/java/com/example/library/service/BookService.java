package com.example.library.service;

import com.example.library.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<Book> findAllBook();
    Book createBook(Book book);
    Book findBookById(Long id);
    Book findBookByIsbn(String isbn);
    Book updateBook(Book book);
    void deleteBook(String isbn);
}
