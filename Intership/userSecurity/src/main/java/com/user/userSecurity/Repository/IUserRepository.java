package com.user.userSecurity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.userSecurity.Model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer>{

}
