package v1.facade;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import v1.exceptions.UserAlreadyExistException;
import v1.exceptions.UserNotFoundException;
import v1.model.User;

@Component("UserFacade")
public class UserFacadeImpl implements UserFacade {

	private final Map<String, User> users = new HashMap<String, User>();
	
	public UserFacadeImpl() {
		User classic = register("test", "test", null, null);
		User police = register("admin", "admin", null, null);
		police.setPolice(true);
	}
	
	@Override
	public User register(String username, String password, LocalDate date, String place) throws UserAlreadyExistException {
		if (users.containsKey(username))
			throw new UserAlreadyExistException();
		
		User user = new User(username, password, date, place);
		
		users.put(username, user);
		
		return user;
	}
	

	@Override
	public User getUser(String username) throws UserNotFoundException {
		if (!users.containsKey(username))
			throw new UserNotFoundException();
		return users.get(username);
	}

}
