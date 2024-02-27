package com.example.library.controller;


import com.example.library.model.Book;
import com.example.library.service.BookService;
import com.example.library.service.LibraryBookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;
    private final LibraryBookService libraryBookService;
    @GetMapping
    public List<Book> findAllBook() {
        return bookService.findAllBook();
    }
    @PostMapping("save_book")
    public Book createBook(@RequestBody Book book) {
        bookService.createBook(book);
        libraryBookService.createLibraryEntryAsync(book.getId());
        return book;
    }

    @GetMapping("/{isbn}")
    public Book findBookByIsbn(@PathVariable String isbn){
        return bookService.findBookByIsbn(isbn);
    }

    @GetMapping("/{id}")
    public Book findBookById(@PathVariable Long id){
        return bookService.findBookById(id);
    }
    @PutMapping("update_book")
    public Book updateBook(@Valid @RequestBody Book book){
        return bookService.updateBook(book);
    }

    @DeleteMapping("delete_book/{isbn}")
    public void deleteBook(@PathVariable String isbn){
        libraryBookService.deleteLibraryBook(bookService.findBookByIsbn(isbn).getId());
        bookService.deleteBook(isbn);

    }
}
