package com.newLibraryProjectt.LibraryProject.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
public class IssueDto {
    private Long userID;
    private List<Long> bookId;
}
