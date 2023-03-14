package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;



@Repository

public interface IAccountRepo extends JpaRepository<Account, Integer>{
	
	@Modifying
	@Transactional
    @Query(value = "update tbl_account set balance=balance-:amt where accno =:sender",
    		 countQuery = "SELECT count(*) FROM tbl_account", nativeQuery = true)
	public void withdrowMoney(double amt,int sender);

	@Modifying
	@Transactional
    @Query(value = "update tbl_account set balance=balance+:amt where accno =:recevier",
    		countQuery = "SELECT count(*) FROM tbl_account", nativeQuery = true)
    public void depositeMoney(double amt,int recevier);
    
    

}
