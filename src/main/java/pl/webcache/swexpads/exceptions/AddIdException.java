package pl.webcache.swexpads.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AddIdException extends RuntimeException {

	public AddIdException(String message) {
		super(message);
	}

}
