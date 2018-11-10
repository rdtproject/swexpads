package pl.webcache.swexpads.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AdIdException extends RuntimeException {

	public AdIdException(String message) {
		super(message);
	}

}
