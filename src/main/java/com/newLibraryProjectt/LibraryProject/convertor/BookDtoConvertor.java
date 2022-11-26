package com.newLibraryProjectt.LibraryProject.convertor;

import com.newLibraryProjectt.LibraryProject.dto.AuthorDto;
import com.newLibraryProjectt.LibraryProject.dto.BookDto;
import com.newLibraryProjectt.LibraryProject.entity.Author;
import com.newLibraryProjectt.LibraryProject.entity.Book;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class BookDtoConvertor {

    @Autowired
    private BookDto bookDto;

    public BookDto toBookConvertor(Book book){
        BookDto bookDto = new BookDto();
        bookDto.setAuthorName(book.getAuthor().getName());
        bookDto.setBookName(book.getName());
        bookDto.setTags(book.getTags());
        bookDto.setLanguage(book.getLanguage());
        bookDto.setNoOfCopies(book.getNoOfCopies());
        return bookDto;

    }

}
