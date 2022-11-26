package com.newLibraryProjectt.LibraryProject.convertor;

import com.newLibraryProjectt.LibraryProject.dto.AuthorDto;
import com.newLibraryProjectt.LibraryProject.entity.Author;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class AuthorDtoConvertor {

    @Autowired
    private AuthorDto authorDto;

    public AuthorDto toAuthorConvertor(Author author){
        AuthorDto authorDto = new AuthorDto();
        authorDto.setName(author.getName());
        authorDto.setAddress(author.getAddress());
        return authorDto;
    }

}
