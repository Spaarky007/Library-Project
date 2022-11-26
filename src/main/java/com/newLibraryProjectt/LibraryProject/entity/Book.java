package com.newLibraryProjectt.LibraryProject.entity;

import com.newLibraryProjectt.LibraryProject.entity.Author;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Book {
    @Id
    @SequenceGenerator(name = "book_generator", sequenceName = "book_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_generator")
    private Long id;
    private String name;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Author author;
    private String  tags;
    private String language;
    private Long noOfCopies;
}
