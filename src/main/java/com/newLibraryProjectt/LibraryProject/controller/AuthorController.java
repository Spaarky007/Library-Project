package com.newLibraryProjectt.LibraryProject.controller;

import com.newLibraryProjectt.LibraryProject.dto.AuthorDto;
import com.newLibraryProjectt.LibraryProject.dto.UserDto;
import com.newLibraryProjectt.LibraryProject.entity.Author;
import com.newLibraryProjectt.LibraryProject.entity.User;
import com.newLibraryProjectt.LibraryProject.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/author")
@RestController
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping
    public AuthorDto saveAuthor(@RequestBody Author author){
        return authorService.saveAuthor(author);
    }

    @GetMapping("{id}")
    public AuthorDto getAuthorById(@PathVariable Long id) throws Exception{
        return authorService.getAuthorById(id);
    }

    @GetMapping("delete/{id}")
    public String deleteAuthorById(Long id)throws Exception{
        return authorService.deleteAuthorById(id);
    }

}
