package com.googlecode.hotire.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "ServiceException")
@SuppressWarnings("serial")
public class ServiceException extends BaseException {
	public ServiceException(final String message) {
		super(message);
	}
}
