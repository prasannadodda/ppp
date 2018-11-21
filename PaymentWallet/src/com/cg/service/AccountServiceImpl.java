package com.cg.service;

import java.util.List;

import com.cg.DAO.AccountDAOImpl;
import com.cg.DAO.IAccountDao;
import com.cg.Exception.CustomerException;
import com.cg.Exception.CustomerExceptionMessage;
import com.cg.bean.AccountBean;

public class AccountServiceImpl implements IAccountService {

	IAccountDao accountDao = new AccountDAOImpl();

	@Override
	public boolean createAccount(AccountBean accountBean)
			throws CustomerException {

		try {
			return accountDao.createAccount(accountBean);

		} catch (Exception e) {

			throw new CustomerException(CustomerExceptionMessage.ERROR);
		}

	}

	@Override
	public boolean deposit(AccountBean accountBean, double depositAmount)
			throws CustomerException {

		
		boolean result;
		try {
			result = accountDao.deposit(accountBean, depositAmount);
			return result;
		} catch (Exception e) {

			throw new CustomerException(CustomerExceptionMessage.BALERROR);
		}

	}

	@Override
	public boolean withdraw(AccountBean accountBean, double withdrawAmount)
			throws CustomerException {
		try {
			if (accountBean.getBalance() > withdrawAmount) {

				
				boolean result;

				result = accountDao.withdraw(accountBean, withdrawAmount);
				return result;
			} else
				throw new CustomerException(CustomerExceptionMessage.BALERROR);

		} catch (Exception e) {
			throw new CustomerException(CustomerExceptionMessage.BALERROR);
		}

	}
    
                    @Override
    public boolean fundTransfer(AccountBean transferingAccountBean,AccountBean beneficiaryAccountBean, double transferAmount) throws CustomerException 
    {
                    
                    if(transferingAccountBean.getBalance()>transferAmount)
                    {
                   
                    
                 
                    boolean result1=accountDao.fundTransfer(transferingAccountBean, beneficiaryAccountBean, transferAmount);
                    boolean result2=accountDao.fundTransfer(transferingAccountBean, beneficiaryAccountBean, transferAmount);
                    return result1 && result2;
                    }
                    else
                    {
                                    throw new CustomerException(CustomerExceptionMessage.BALERROR);
                    }
                    
                    

    }




	
	@Override
	public AccountBean findAccount(int accountId) throws CustomerException {
		
		
		AccountBean bean = accountDao.findAccount(accountId);
		return bean;
	}

	public boolean isValidMail(String mail) {
		if ((mail.matches("[A-Z0-9a-z.]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}"))) {
			return true;
		}

		System.out.println("Email Address should be in abc@def.as format");

		return false;

	}

	public boolean isValidAddr(String addr) {
		if (addr.length() < 3) {
			System.out.println("Address should be atleast 3 characters");

			return false;

		}
		return true;

	}

	public boolean isValidPhoneNum(String phone) {
		if (phone.matches("(0)?[6-9][0-9]{9}")) {
			return true;
		}
		System.out.println("phone number should be 10 digits only");

		return false;

	}

	public boolean isValidPan(String pan) {
		if (pan.matches("^[A-Z]{4}[0-9]{5}[A-Z]{1}")) {
			return true;
		}
		System.out.println("PAN should be 10 digits and valid one");

		return false;

	}

	public boolean isValidLName(String lname) {
		if (lname.trim().length() < 3) {
			System.out.println("Last Name should be more than 2 characters");

			return false;
		}
		return true;
	}

	public boolean isValidFName(String fname) {

		if (fname.trim().length() < 3) {
			System.out.println("First Name should be more than 2 characters");

			return false;

		}

		return true;
	}

	public boolean isValidGender(String gender) {

		if (((gender.equalsIgnoreCase("M")) || (gender.equalsIgnoreCase("F")))) {
			return true;

		}
		System.out.println("Gender should be either 'M' or 'F' ");

		return false;

	}

	@Override
	public String gender(String g) {

		if (g.equals("F")) {
			return "Mrs";
		}

		return "Mr";

	}

	@Override
	public List<String> getOperations() {
		IAccountDao dao = new AccountDAOImpl();

		return dao.getOperations();
	}

}
