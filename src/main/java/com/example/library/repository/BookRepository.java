package com.example.library.repository;


import com.example.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Modifying
    @Transactional
    @Query("delete from Book where isbn = :isbn")
    void deleteBookByIsbn(String isbn);

    Book findBookByIsbn(String isbn);
    Book findBookById(Long id);
    boolean existsBooksByIsbn(String isbn);
}
