package com.newLibraryProjectt.LibraryProject.Ecxeption;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {
    private String errorMessage;
    private String userErrorMessage;
    private int errorCode;
    private HttpStatus httpstatus;
}
