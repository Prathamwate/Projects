package com.example.User.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.User.Model.User;

public interface IUserRepo  extends JpaRepository<User,Integer>{

}
