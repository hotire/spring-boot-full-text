package com.googlecode.hotire.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ExceptionHandlingController {

	@ExceptionHandler(BaseException.class) 
	public void handleError(final Exception exception) {
		log.error(exception.getMessage());
	}
}
