package com.emirates.asc.parent.exceptions;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	String msg;

	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(String msg) {
		this.msg = msg;
	}

	public void setMessage(String msg) {
		this.msg = msg;
	}

	public String getMessage() {
		return this.msg;
	}

}
