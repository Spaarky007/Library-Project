package com.newLibraryProjectt.LibraryProject.service;

import com.newLibraryProjectt.LibraryProject.convertor.AuthorDtoConvertor;
import com.newLibraryProjectt.LibraryProject.convertor.BookDtoConvertor;
import com.newLibraryProjectt.LibraryProject.dto.AuthorDto;
import com.newLibraryProjectt.LibraryProject.dto.BookDto;
import com.newLibraryProjectt.LibraryProject.entity.Author;
import com.newLibraryProjectt.LibraryProject.entity.Book;
import com.newLibraryProjectt.LibraryProject.repository.AuthorRepository;
import com.newLibraryProjectt.LibraryProject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookDtoConvertor bookDtoConvertor;

    @Autowired
    AuthorRepository authorRepository;
    public BookDto saveBook(Book book) {
        Long authorId = book.getAuthor().getId();
        if(authorId!=null) {
            Optional<Author> author = authorRepository.findById(authorId);
            if (author.isPresent()) {
                book.setAuthor(author.get());
            }
        }
        Book book1 = bookRepository.save(book);
        return bookDtoConvertor.toBookConvertor(book1);
    }

    public List<BookDto> searchBook(BookDto bookDto) {
        List<Book> books = bookRepository.searchBook(bookDto.getAuthorName(), bookDto.getBookName(),
                bookDto.getTags(), bookDto.getLanguage());
        List<BookDto> bookDto1 = books.stream().map(b->bookDtoConvertor.
                toBookConvertor(b)).collect(Collectors.toList());
        return bookDto1;
    }
}
