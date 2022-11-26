package com.newLibraryProjectt.LibraryProject.controller;

import com.newLibraryProjectt.LibraryProject.dto.AuthorDto;
import com.newLibraryProjectt.LibraryProject.dto.BookDto;
import com.newLibraryProjectt.LibraryProject.entity.Author;
import com.newLibraryProjectt.LibraryProject.entity.Book;
import com.newLibraryProjectt.LibraryProject.repository.BookRepository;
import com.newLibraryProjectt.LibraryProject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/book")
@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping
    public BookDto saveBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @PostMapping("search")
    public List<BookDto> searchBook(@RequestBody BookDto bookDto){
        return bookService.searchBook(bookDto);
    }
}
