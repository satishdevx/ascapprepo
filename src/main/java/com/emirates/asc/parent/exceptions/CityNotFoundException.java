package com.emirates.asc.parent.exceptions;

public class CityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CityNotFoundException(Long id) {
		super(String.format("City with Id %d not found", id));
	}
}