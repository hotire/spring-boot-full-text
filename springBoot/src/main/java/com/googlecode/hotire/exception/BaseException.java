package com.googlecode.hotire.exception;


@SuppressWarnings("serial")
public class BaseException extends RuntimeException {
	private final String message;
	public BaseException(final String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
}
