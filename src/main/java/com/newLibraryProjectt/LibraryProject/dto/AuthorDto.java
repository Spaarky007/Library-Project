package com.newLibraryProjectt.LibraryProject.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class AuthorDto {
    private String name;
    private String address;
}
