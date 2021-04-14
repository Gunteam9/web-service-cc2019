package v1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import v1.facade.UserFacade;
import v1.model.User;

@Component
public class CustomUserDetailsService implements UserDetailsService {
	private static final String[] ROLES_ADMIN = {"USER", "POLICE"};
	private static final String[] ROLES_USER = {"USER"};
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserFacade userFacade;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userFacade.getUser(username);
		if (user == null)
			throw new UsernameNotFoundException("User " + username + " not found");
		String[] roles = user.isPolice() ? ROLES_ADMIN : ROLES_USER;
		System.out.println(roles);
		UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
				.username(user.getUsername())
				.password(passwordEncoder.encode(user.getPassword()))
				.roles(roles)
				.build();
		
		return userDetails;
	}
}
