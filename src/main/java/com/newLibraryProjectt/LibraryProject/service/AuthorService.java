package com.newLibraryProjectt.LibraryProject.service;

import com.newLibraryProjectt.LibraryProject.Ecxeption.LibraryException;
import com.newLibraryProjectt.LibraryProject.convertor.AuthorDtoConvertor;
import com.newLibraryProjectt.LibraryProject.dto.AuthorDto;
import com.newLibraryProjectt.LibraryProject.entity.Author;
import com.newLibraryProjectt.LibraryProject.entity.User;
import com.newLibraryProjectt.LibraryProject.external.ErrorCodes;
import com.newLibraryProjectt.LibraryProject.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    AuthorDtoConvertor authorDtoConvertor;

    public AuthorDto saveAuthor(Author author){
        Author author1 = authorRepository.save(author);
        AuthorDto authorDto = authorDtoConvertor.toAuthorConvertor(author1);
        return authorDto;
    }

    public AuthorDto getAuthorById(Long id) throws Exception, LibraryException {
        Optional<Author> author = authorRepository.findById(id);
        if(!author.isPresent())
            throw  LibraryException.libraryExceptionIMPL(ErrorCodes.AUTHOR_NOT_FOUND);
        return authorDtoConvertor.toAuthorConvertor(author.get());
    }

    public String deleteAuthorById(Long id) throws Exception, LibraryException{
        Optional<Author> author = authorRepository.findById(id);
        if(!author.isPresent())
            throw  LibraryException.libraryExceptionIMPL(ErrorCodes.AUTHOR_NOT_FOUND);
        authorRepository.deleteById(id);
        return "DELETED SUCCESSFULLY";




    }
}

