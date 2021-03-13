package com.ishwor.newp.spring.boot.controller.advices;

import com.ishwor.newp.spring.boot.comon.util.exception.DataNotFoundExeption;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ControllerAdvices extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value = DataNotFoundExeption.class)
	protected ResponseEntity<Object> handleConfilt(DataNotFoundExeption ex, WebRequest request) {
		String bodyOfResponse = ex.getMessage();
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}
}
