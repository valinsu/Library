package com.example.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class LibraryBook {
    private static final int MINUTES_TO_ADD = 1;
    @Id
    @GeneratedValue
    private Long id;
    private Long bookId;
    private LocalDateTime issueTime = LocalDateTime.now();
    private LocalDateTime returnTime = LocalDateTime.now().plusMinutes(MINUTES_TO_ADD);
}
