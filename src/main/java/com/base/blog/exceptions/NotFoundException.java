package com.base.blog.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends SimpleBlogException {

	private static final long serialVersionUID = 1L;

	public NotFoundException(String message) {
		super("ERROR-404", HttpStatus.NOT_FOUND.value(), message);
	}

	public NotFoundException(String code, String message) {
		super(code, HttpStatus.NOT_FOUND.value(), message);
	}

}
