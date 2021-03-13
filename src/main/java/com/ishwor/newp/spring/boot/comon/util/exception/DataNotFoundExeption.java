package com.ishwor.newp.spring.boot.comon.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DataNotFoundExeption extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DataNotFoundExeption() {
		
	}
	
	public DataNotFoundExeption(String message) {
		super(message);
	}

	public DataNotFoundExeption(String message, Throwable cause) {
		super(message, cause);
	}

	public DataNotFoundExeption(Throwable cause) {
		super(cause);
	}

}
