package com.cg.service;

	import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.cg.Exception.CustomerException;
import com.cg.bean.AccountBean;

	
	public interface IAccountService {

	          public boolean createAccount(AccountBean accountBean) throws CustomerException;
	          public AccountBean findAccount(int accountId) throws CustomerException, Exception;
	          public boolean deposit(AccountBean accountBean,double depositAmount) throws  CustomerException ;
	          public boolean withdraw(AccountBean accountBean,double withdrawAmount) throws  CustomerException;
	          public boolean fundTransfer(AccountBean transferingAccountBean, AccountBean beneficiaryAccountBean, double transferAmount) throws  CustomerException;
			public List<String> getOperations();
			public String gender(String g);
	         
			 
	          
		
}
