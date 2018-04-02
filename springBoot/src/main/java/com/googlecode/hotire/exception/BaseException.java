package com.googlecode.hotire.exception;

/**
 * 
 * @author hoTire
 * @comment : RuntimeException 
 */
@SuppressWarnings("serial")
public class BaseException extends RuntimeException {
	private String message;
	public BaseException(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
