package com.example.library.repository;

import com.example.library.model.LibraryBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface LibraryBookRepository extends JpaRepository<LibraryBook, Long> {

    @Modifying
    @Transactional
    @Query("delete from LibraryBook where bookId = :bookId")
    void deleteLibraryBook(Long bookId);

    boolean existsByBookId(Long bookId);
}
