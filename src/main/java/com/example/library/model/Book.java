package com.example.library.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "The book ISBN must be defined")
    @Pattern(
            regexp = "^([0-9]{10}|[0-9]{13})$",
            message = "The ISBN format must be valid"
    )
    @Column(unique = true)
    private String isbn;
    @NotBlank(message = "The book title must be defined")
    private String title;
    private String genre;
    private String description;
    @NotBlank(message = "The book author must be defined")
    private String author;
}
