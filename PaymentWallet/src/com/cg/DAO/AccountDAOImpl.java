package com.cg.DAO;


	import java.util.List;

import javax.persistence.EntityManager;

import com.cg.Exception.CustomerException;
import com.cg.Exception.CustomerExceptionMessage;
import com.cg.bean.AccountBean;
import com.cg.util.Database;

	/*import com.capg.paymentwallet.bean.AccountBean;
	import com.capg.paymentwallet.exception.CustomerException;
	import com.capg.paymentwallet.exception.CustomerExceptionMessage;
	import com.capg.paymentwallet.util.Database;
*/
	public class AccountDAOImpl implements IAccountDao {

		
		EntityManager em;
		
		@Override
		public boolean createAccount(AccountBean accountBean) {
			try{
				
				this.em=JPAManager.createEntityManager();
				em.getTransaction().begin();
				
				em.persist(accountBean);
				
				em.getTransaction().commit();
				JPAManager.closeResources(em);
				
				return true;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
		
		}

		public boolean updateAccount(AccountBean accountBean) throws Exception {
			try{
				this.em=JPAManager.createEntityManager();
				em.getTransaction().begin();
				
				em.merge(accountBean);
				
				em.getTransaction().commit();
				JPAManager.closeResources(em);
				return true;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
		
		}

		@Override
		public AccountBean findAccount(int accountId)  {
			
			try{
				em=JPAManager.createEntityManager();
				AccountBean accountBean2=em.find(AccountBean.class,accountId);
				JPAManager.closeResources(em);
				return accountBean2;
				
			}catch(Exception e){
				return null;

			}
		}
		@Override
		public List<String> getOperations() 
		{
				return Database.getOperations();
		}

		@Override
		public boolean deposit(AccountBean accountBean, double depositAmount)
				 {
			
			try {
				accountBean.setBalance(accountBean.getBalance() + depositAmount);
				return updateAccount(accountBean);
			} catch (Exception e) {
				
			return false;
			}
		}

		@Override
		public boolean withdraw(AccountBean accountBean, double withdrawAmount)
				{
			try{
			accountBean.setBalance(accountBean.getBalance()- withdrawAmount);
			return updateAccount(accountBean);
			}catch(Exception e){
			return false;
		}
				}

		@Override
		public boolean fundTransfer(AccountBean transferingAccountBean,
				AccountBean beneficiaryAccountBean, double transferAmount)
				 {
			try{
			transferingAccountBean.setBalance(transferingAccountBean .getBalance() -transferAmount); 
			  beneficiaryAccountBean.setBalance(beneficiaryAccountBean.getBalance() + transferAmount);
			  return true;
		}catch(Exception e)
			{
			return false;
			}

	}
	}
