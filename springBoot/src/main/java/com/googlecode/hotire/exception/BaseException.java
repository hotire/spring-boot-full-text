package com.googlecode.hotire.exception;


import lombok.Getter;

@SuppressWarnings("serial")
public class BaseException extends RuntimeException {
	@Getter
	private final String message;
	public BaseException(final String message) {
		this.message = message;
	}
}
