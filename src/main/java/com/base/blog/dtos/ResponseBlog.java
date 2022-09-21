package com.base.blog.dtos;

import java.io.Serializable;

public class ResponseBlog<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private Boolean stateProcess;
	private String responseMessage;
	private transient T data;

	public ResponseBlog() {
		super();
	}

	public ResponseBlog(Boolean status, String message) {
		super();
		this.stateProcess = status;
		this.responseMessage = message;
	}

	public ResponseBlog(Boolean status, String message, T data) {
		super();
		this.stateProcess = status;
		this.responseMessage = message;
		this.data = data;
	}

	public Boolean getStateProcess() {
		return stateProcess;
	}

	public void setStateProcess(Boolean status) {
		this.stateProcess = status;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String message) {
		this.responseMessage = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "RespuestaGenerica [stateProcess=" + stateProcess + ", responseMessage=" + responseMessage + ", data="
				+ data + "]";
	}

}
