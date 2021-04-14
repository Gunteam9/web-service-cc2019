package v1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CertificateNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 251062641895577960L;

	public CertificateNotFoundException() {
		super("Certificate not found");
		
	}

	public CertificateNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public CertificateNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public CertificateNotFoundException(String message) {
		super(message);
		
	}

	public CertificateNotFoundException(Throwable cause) {
		super(cause);
		
	}
}
