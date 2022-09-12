package com.base.blog.exceptions;

import org.springframework.http.HttpStatus;

public class InternalServerErrorException extends SimpleBlogException {
	
	private static final long serialVersionUID = 1L;

	public InternalServerErrorException(String message) {
        super("ERROR-500", HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
    }
    
    public InternalServerErrorException(String code, String message) {
        super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
    }

}
