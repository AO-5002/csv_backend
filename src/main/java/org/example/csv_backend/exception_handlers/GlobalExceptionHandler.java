package org.example.csv_backend.exception_handlers;

import org.example.csv_backend.exceptions.CsvException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CsvException.class)
    public ResponseEntity<ErrorResponse> handleApplicationException(CsvException e) {
        ErrorResponse error = new ErrorResponse(e.getMessage(), e.getHttpStatus().value());
        return ResponseEntity.status(e.getHttpStatus()).body(error);
    }
}
