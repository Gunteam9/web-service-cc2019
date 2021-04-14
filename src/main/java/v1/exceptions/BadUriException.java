package v1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class BadUriException extends RuntimeException {

	public BadUriException() {
		super("Error during URI creation");
		
	}

	public BadUriException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public BadUriException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public BadUriException(String message) {
		super(message);
		
	}

	public BadUriException(Throwable cause) {
		super(cause);
		
	}
	
	

}
