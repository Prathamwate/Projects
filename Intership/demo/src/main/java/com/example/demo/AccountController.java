package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("api/account")
public class AccountController {
		
	@Autowired
	AccountService accountService;
	
	@PostMapping(name = "/addAccount")
	public ResponseEntity<String> addAccount(@RequestBody Account account){
		String msg=accountService.addAccount(account);
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
	
	@GetMapping(name="/getAccount")
	public List<Account> getAccount(){
		List<Account> account=accountService.getAccount();
		return account;
	}
	
	@PutMapping(name="/sendMoney")
	public ResponseEntity<String> sendMoney(@RequestBody SendMoney sendMoney){
		String msgString=accountService.sendMoney(sendMoney);
		return new ResponseEntity<String>(msgString,HttpStatus.OK) ;
	}
}