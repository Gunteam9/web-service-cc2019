package v1.facade;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;

import v1.exceptions.CertificateNotFoundException;
import v1.exceptions.UserNotFoundException;
import v1.model.Certificate;
import v1.model.User;

@Component("CertificateFacade")
public class CertificateFacadeImpl implements CertificateFacade {

	private final Map<UUID, Certificate> certificates = new HashMap<UUID, Certificate>();
	
	@Override
	public Certificate newCertificate(User user, LocalDate date, LocalTime time, String reason) throws UserNotFoundException {
		
		Certificate c = new Certificate(user, date, time, reason);
		
		certificates.put(c.getUuid(), c);
		
		return c;
		
	}

	@Override
	public Certificate getCertificate(UUID uuid) throws CertificateNotFoundException {
		if (!certificates.containsKey(uuid))
			throw new CertificateNotFoundException();
		
		return certificates.get(uuid);
	}

}
