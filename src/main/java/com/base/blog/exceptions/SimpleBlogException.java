package com.base.blog.exceptions;

public class SimpleBlogException extends Exception {

	private static final long serialVersionUID = 1L;

	private final String code;

	private final int responseCode;

	public SimpleBlogException(String code, int responseCode, String message) {
		super(message);
		this.code = code;
		this.responseCode = responseCode;
	}

	public String getCode() {
		return code;
	}

	public int getResponseCode() {
		return responseCode;
	}

	@Override
	public String toString() {
		return "SimpleBlogException [code=" + code + ", responseCode=" + responseCode + "]";
	}

}
