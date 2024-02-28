package com.example.library.impl;

import com.example.library.model.Book;
import com.example.library.model.LibraryBook;
import com.example.library.repository.BookRepository;
import com.example.library.repository.LibraryBookRepository;
import com.example.library.service.LibraryBookService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Log4j2
@Service
@AllArgsConstructor
public class LibraryBookServiceImpl implements LibraryBookService {

    private final LibraryBookRepository libraryBookRepository;
    private final BookRepository bookRepository;

    @Override
    public List<Book> findFreeBook() {
        List<Book> freeBooks = new ArrayList<>();
        List<LibraryBook> libraries = libraryBookRepository.findAll();
        for (LibraryBook libraryEntry : libraries) {
            if (libraryEntry.getReturnTime() != null && libraryEntry.getReturnTime().isBefore(LocalDateTime.now())) {
                Book freeBook = bookRepository.findBookById(libraryEntry.getBookId());
                if (freeBook != null) {
                    freeBooks.add(freeBook);
                }
            }
        }
        return freeBooks;
    }

    @Async
    @Override
    public void createLibraryEntryAsync(Long bookId) {
        if (libraryBookRepository.existsByBookId(bookId)) {
            log.info("Exists library book for book with ID: {}", bookId);
        } else {
            LibraryBook libraryEntry = new LibraryBook();
            libraryEntry.setBookId(bookId);
            log.info("Creating library book entry for book with ID: {}", bookId);
            libraryBookRepository.save(libraryEntry);
        }
    }

    @Override
    public void deleteLibraryBook(Long bookId) {
        libraryBookRepository.deleteLibraryBook(bookId);
    }
}
