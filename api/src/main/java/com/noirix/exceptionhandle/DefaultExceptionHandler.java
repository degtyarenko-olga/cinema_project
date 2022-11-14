package com.noirix.exceptionhandle;

import com.noirix.exception.NoSuchEntityException;
import com.noirix.util.UUIDGenerator;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.NoSuchElementException;

@ControllerAdvice
public class DefaultExceptionHandler {
    public static final int ERROR_CODE = 2;
    public static final int ERROR_CODE1 = 1;
    public static final String GENERAL_ERROR = "General error";
    public static final int ERROR_CODE2 = 3;
    public static final String ERROR = "error";

    @ExceptionHandler({NoSuchEntityException.class, EmptyResultDataAccessException.class, NoSuchElementException.class})
    public ResponseEntity<Object> handleEntityNotFountException(Exception e) {

        ErrorContainer error = ErrorContainer
                .builder()
                .exceptionId(UUIDGenerator.generateUUID())
                .errorCode(ERROR_CODE)
                .errorMessage(e.getMessage())
                .e(e.getClass().toString())
                .build();

        return new ResponseEntity<>(Collections.singletonMap(ERROR, error), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception e) {

        ErrorContainer error = ErrorContainer
                .builder()
                .exceptionId(UUIDGenerator.generateUUID())
                .errorCode(ERROR_CODE1)
                .errorMessage(GENERAL_ERROR)
                .e(e.getClass().toString())
                .build();

        return new ResponseEntity<>(Collections.singletonMap(ERROR, error), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<Object> handlerNumberFormatException(Exception e) {

        ErrorContainer error = ErrorContainer
                .builder()
                .exceptionId(UUIDGenerator.generateUUID())
                .errorCode(ERROR_CODE2)
                .errorMessage(e.getMessage())
                .e(e.getClass().toString())
                .build();

        return new ResponseEntity<>(Collections.singletonMap(ERROR, error), HttpStatus.BAD_REQUEST);
    }

}
