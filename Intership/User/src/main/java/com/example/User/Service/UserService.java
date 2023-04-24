package com.example.User.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.User.Model.User;
import com.example.User.Repository.IUserRepo;

@Service
public class UserService {
	@Autowired
	IUserRepo iuserRepo;

	public int addUser(User user) {
		
	      User user1=iuserRepo.save(user);
	      return user1.getUserId();
		
		
	}

	public List<User> getUser(Integer userId) {
		List<User> userlist;
		if(userId!=null) {
			userlist=new ArrayList<>();
			userlist.add(iuserRepo.findById(userId).get());
		}
		else {
			userlist=iuserRepo.findAll();
		}
		return userlist;
	}
	
}
