package v1.facade;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import v1.exceptions.UserAlreadyExistException;
import v1.exceptions.UserNotFoundException;
import v1.model.User;

@Component
public interface UserFacade {
	
	public User register(String username, String password, LocalDate date, String place) throws UserAlreadyExistException;
	public User getUser(String username) throws UserNotFoundException;
}
