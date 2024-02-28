package com.example.library.impl;

import com.example.library.exception.BookAlreadyExistsException;
import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> findAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book createBook(Book book) {
        if(bookRepository.existsBooksByIsbn(book.getIsbn())){
            throw new BookAlreadyExistsException(book.getIsbn());
        }
        return bookRepository.save(book);
    }

    @Override
    public Book findBookById(Long id) {
        return bookRepository.findBookById(id);=
    }

    @Override
    public Book findBookByIsbn(String isbn) {
        return bookRepository.findBookByIsbn(isbn);
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(String isbn) {
        bookRepository.deleteBookByIsbn(isbn);
    }
}
