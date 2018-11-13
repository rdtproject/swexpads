package pl.webcache.swexpads.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AdNotFoundException extends RuntimeException {

	public AdNotFoundException(String message) {
		super(message);
	}

}
