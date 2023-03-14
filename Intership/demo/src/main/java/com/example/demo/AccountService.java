package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService extends ExceptionClass{
	
	@Autowired
	IAccountRepo iAccountRepo;

	public String addAccount(Account account) {
		String strmsg="";
		try {
			iAccountRepo.save(account);
			strmsg="Account Open";
		}
		catch (Exception e) {
			strmsg=e.getMessage();
		}
		return strmsg;
	}

	public List<Account> getAccount() {
		List<Account> aList=new ArrayList<>();
		try {
			aList=iAccountRepo.findAll();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return aList;
	}

	public String sendMoney(SendMoney sendMoney)  {
		String msgString="";
		try {
			Account sender=iAccountRepo.findById(sendMoney.getSender()).get();
			Account recevier=iAccountRepo.findById(sendMoney.getRecevier()).get();
			double pay=sendMoney.getAmount();
				try {
				    iAccountRepo.withdrowMoney(pay, sender.getAccno());
					iAccountRepo.depositeMoney(pay, recevier.getAccno());
					msgString="MoneySend Done";
				}
				catch (Exception e) {
					// TODO: handle exception
					msgString=e.getLocalizedMessage();
				}
	       }
		catch (Exception e) {
			msgString="sender or reciver not found";
		}
		return msgString;
	}
	
	

}
