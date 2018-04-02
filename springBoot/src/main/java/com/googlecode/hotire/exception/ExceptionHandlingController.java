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
public class ExceptionHandingController {
	
	private static Logger logger = LoggerFactory.getLogger(ExceptionHandingController.class);
	
	@ExceptionHandler(BaseException.class) 
	public void handleError(Exception exception) { 
		logger.error(exception.getMessage());
	}
}
