package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.model.LibraryBook;
import com.example.library.service.LibraryBookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library_books")
@AllArgsConstructor
public class LibraryBookController {

    private final LibraryBookService libraryService;

    @GetMapping("free_books")
    public List<Book> findFreeBook() {
        return libraryService.findFreeBook();
    }

    @PostMapping("save")
    public LibraryBook createLibraryBook(@RequestBody LibraryBook library) {
        libraryService.createLibraryEntryAsync(library.getBookId());
        return library;
    }

    @DeleteMapping("delete/{bookId}")
    public void deleteLibraryBook(@PathVariable Long bookId){
        libraryService.deleteLibraryBook(bookId);
    }
}
