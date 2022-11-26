package com.newLibraryProjectt.LibraryProject.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_generator")
    @SequenceGenerator(name = "author_generator", sequenceName = "author_sequence", allocationSize = 1)
    private Long id;
    private String name;
    private String address;
    private Boolean isActive;
}
