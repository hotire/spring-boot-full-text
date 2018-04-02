package com.googlecode.hotire.exception;






import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 
 * @author hoTire
 *
 */
@ControllerAdvice
public class ExceptionHandlingController {
	
	private static Logger logger = LoggerFactory.getLogger(ExceptionHandlingController.class);
	
	@ExceptionHandler(BaseException.class) 
	public void handleError(Exception exception) { 
		logger.error(exception.getMessage());
	}
}
