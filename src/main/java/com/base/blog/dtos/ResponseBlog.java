package com.base.blog.dtos;

import java.io.Serializable;
import java.util.Objects;

public class ResponseBlog<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private Boolean status;
	private String message;
	private transient T data;

	public ResponseBlog() {
		super();
	}

	public ResponseBlog(Boolean status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public ResponseBlog(Boolean status, String message, T data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		return Objects.hash(message, status);
	}

	@Override
	public String toString() {
		return "RespuestaGenerica [status=" + status + ", message=" + message + ", data=" + data + "]";
	}

}
