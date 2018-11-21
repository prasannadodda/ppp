package com.cg.DAO;

import java.util.List;

import com.cg.Exception.CustomerException;
import com.cg.bean.AccountBean;

public interface IAccountDao {

	  public boolean createAccount(AccountBean accountBean) ;
      public AccountBean findAccount(int accountId) ;
      public boolean deposit(AccountBean accountBean,double depositAmount)  ;
      public boolean withdraw(AccountBean accountBean,double withdrawAmount) ;
      public boolean fundTransfer(AccountBean transferingAccountBean, AccountBean beneficiaryAccountBean, double transferAmount) ;
	public List<String> getOperations();
	  
		
		 
	    
	}


