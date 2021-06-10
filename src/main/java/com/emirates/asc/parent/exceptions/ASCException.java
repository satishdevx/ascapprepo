package com.emirates.asc.parent.exceptions;

public class ASCException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ASCException() {
		super();
	}

	public ASCException(String msg) {
		super(msg);
	}
}