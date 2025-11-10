package org.example.csv_backend.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public class CsvException extends RuntimeException{
    private final HttpStatus httpStatus;

    public CsvException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

}
