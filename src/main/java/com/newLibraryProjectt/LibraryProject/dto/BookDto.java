package com.newLibraryProjectt.LibraryProject.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BookDto {
    private String authorName;
    private String bookName;
    private String tags;
    private String language;
    private Long noOfCopies;
}
