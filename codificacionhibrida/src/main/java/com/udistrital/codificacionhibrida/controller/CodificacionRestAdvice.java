package com.udistrital.codificacionhibrida.controller;

import com.udistrital.codificacionhibrida.exception.ErrorDto;
import com.udistrital.codificacionhibrida.exception.InvalidLengthException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@ControllerAdvice
public class CodificacionRestAdvice extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(new ErrorDto("Request invalido","Los datos de entrada no son válidos", LocalDate.now()), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, ErrorDto> errors = new HashMap<>();
        AtomicInteger cont = new AtomicInteger();
        ex.getBindingResult().getAllErrors().forEach((error) ->{

            String fieldName = cont + "_" + ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            cont.getAndIncrement();
            errors.put(fieldName, new ErrorDto("Argumentos invalidos",message, LocalDate.now()));

        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final ResponseEntity<ErrorDto> handleAllExceptions(WebRequest request) {
        ErrorDto exceptionResponse = new ErrorDto
                ("Error generaL",request.getDescription(true), LocalDate.now());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidLengthException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final ResponseEntity<ErrorDto> handleInvalidLengthException(WebRequest request, InvalidLengthException invalidLengthException) {
        ErrorDto exceptionResponse = new ErrorDto
                ("Argumentos invalidos",invalidLengthException.getMessage(), LocalDate.now());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
