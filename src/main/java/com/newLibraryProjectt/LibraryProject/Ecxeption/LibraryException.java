package com.newLibraryProjectt.LibraryProject.Ecxeption;

import com.newLibraryProjectt.LibraryProject.external.ErrorCodes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LibraryException extends Exception{
    private String errorMessage;
    private String userErrorMessage;
    private int errorCode;
    private HttpStatus httpstatus;

    public static LibraryException libraryExceptionIMPL(ErrorCodes errorCodes){
       return  LibraryException.builder().errorMessage(errorCodes.getErrorMessage()).userErrorMessage(errorCodes.getUserErrorMessage())
                .errorCode(errorCodes.getErrorCode()).httpstatus(HttpStatus.INTERNAL_SERVER_ERROR).build();

    }
}
