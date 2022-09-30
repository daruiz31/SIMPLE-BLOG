package com.base.blog.exceptions;

import java.util.ArrayList;
import java.util.List;

import com.base.blog.dtos.ErrorDTO;

public class SimpleBlogException extends Exception {

	private static final long serialVersionUID = 1L;

	private final String code;

	private final int responseCode;
	
	private final List<ErrorDTO> errors = new ArrayList<>();

	public SimpleBlogException(String code, int responseCode, String message) {
		super(message);
		this.code = code;
		this.responseCode = responseCode;
	}
	
	public SimpleBlogException(String code, int responseCode, String message, List<ErrorDTO> errors) {
		super(message);
		this.code = code;
		this.responseCode = responseCode;
		this.errors.addAll(errors);
	}

	public String getCode() {
		return code;
	}

	public int getResponseCode() {
		return responseCode;
	}

	
	public List<ErrorDTO> getErrors() {
		return errors;
	}

	@Override
	public String toString() {
		return "SimpleBlogException [code=" + code + ", responseCode=" + responseCode + "]";
	}

}
