package com.user.userSecurity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.user.userSecurity.Model.User;
import com.user.userSecurity.Repository.IUserRepository;

@Service
public class UserService {

	@Autowired
	IUserRepository iUserRepository;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public ResponseEntity<String> createUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		User user1 = iUserRepository.save(user);
		return new ResponseEntity<String>(user1.toString(), HttpStatus.CREATED);
	}

	public ResponseEntity<String> loginUser(User user) {
		User user1 = iUserRepository.findById(user.getId()).get();
		if (bCryptPasswordEncoder.matches(user.getPassword(), user1.getPassword())) {
			return new ResponseEntity<String>("user and Password Valid", HttpStatus.FOUND);
		}
		return new ResponseEntity<String>("user and Password Not Valid", HttpStatus.NOT_FOUND);
	}

}
