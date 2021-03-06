package pl.webcache.swexpads.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Exceptions can come here for advice. Than it will be handled properly. Global
 * exception handling.
 */

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler
	public final ResponseEntity<Object> handleAddIdException(AdIdException ex, WebRequest request) {
		AdIdExceptionResponse exceptionResponse = new AdIdExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public final ResponseEntity<Object> handleAdNotFoundException(AdNotFoundException ex, WebRequest request) {
		AdNotFoundExceptionResponse exceptionResponse = new AdNotFoundExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

}
