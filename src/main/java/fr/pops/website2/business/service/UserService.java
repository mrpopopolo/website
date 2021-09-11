package fr.pops.website2.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.pops.website2.persistence.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRep;
	
	private PasswordEncoder passEnc;
	
	public boolean testPassword(String email, String password) {
		return passEnc.encode(password).equals(userRep.findOneByUsername(email).getPassword());
	}
}
