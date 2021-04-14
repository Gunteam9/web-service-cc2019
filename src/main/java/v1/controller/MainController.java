package v1.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import v1.exceptions.BadUriException;
import v1.facade.CertificateFacade;
import v1.facade.UserFacade;
import v1.model.Certificate;
import v1.model.User;

@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
public class MainController {
	
	@Autowired
	UserFacade userFacade;
	
	@Autowired
	CertificateFacade certificateFacade;
	
	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody User user, HttpServletRequest request) {
		try {
			User newUser = userFacade.register(user.getUsername(), user.getPassword(), user.getDate(), user.getPlace());
			
			HttpHeaders responseHeader = new HttpHeaders();
			responseHeader.setLocation(new URI("http://" + request.getRemoteHost() + "/user/" + newUser.getUsername()));
			
			return ResponseEntity.status(HttpStatus.CREATED).headers(responseHeader).body(newUser);
		} catch (URISyntaxException e) {
			throw new BadUriException();
		}
	}
	
	@PostMapping("/user/{name}/certificate/new")
	public ResponseEntity<UUID> createNewCertificate(@PathVariable String name, @RequestBody Certificate body, HttpServletRequest request) {
		try {
			User user = userFacade.getUser(name);
			
			Certificate newCertificate = certificateFacade.newCertificate(user, body.getDate(), body.getTime(), body.getReason());
			
			HttpHeaders responseHeader = new HttpHeaders();
			responseHeader.setLocation(new URI("http://" + request.getRemoteHost() + "/certificate/" + newCertificate.getUuid().toString()));
			
			return ResponseEntity.status(HttpStatus.CREATED).headers(responseHeader).body(newCertificate.getUuid());
		} catch (URISyntaxException e) {
			throw new BadUriException();
		}
	}
	
	@GetMapping("/certificate/{id}")
	public ResponseEntity<Certificate> getCertificate(@PathVariable UUID id) {
		Certificate c = certificateFacade.getCertificate(id);
		return ResponseEntity.ok(c);
	}

}
