package v1.facade;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import v1.exceptions.CertificateNotFoundException;
import v1.exceptions.UserNotFoundException;
import v1.model.Certificate;
import v1.model.User;

public interface CertificateFacade {

	public Certificate newCertificate(User user, LocalDate date, LocalTime time, String reason) throws UserNotFoundException;
	public Certificate getCertificate(UUID uuid) throws CertificateNotFoundException;
	
}
