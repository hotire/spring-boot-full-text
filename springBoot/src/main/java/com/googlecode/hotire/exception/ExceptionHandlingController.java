package com.googlecode.hotire.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ExceptionHandlingController {

	@ExceptionHandler(BaseException.class) 
	public void handleBaseError(final BaseException exception) {
		log.error(exception.getMessage());
	}

	@ExceptionHandler(ServiceException.class)
	public void handleServiceError(final ServiceException exception) {
		log.error(exception.getMessage());
	}
}
