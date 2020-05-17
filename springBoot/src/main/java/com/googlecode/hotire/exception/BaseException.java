package com.googlecode.hotire.exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "INTERNAL SERVER ERROR")
@SuppressWarnings("serial")
public class BaseException extends RuntimeException {
	@Getter
	private final String message;
	public BaseException(final String message) {
		this.message = message;
	}
}
