package org.capg.bank.test;

import static org.junit.Assert.*;

import org.cap.dao.AccountDao;
import org.cap.dao.AccountDaoImpl;
import org.cap.dto.Account;
import org.cap.dto.Address;
import org.cap.dto.Customer;
import org.cap.exception.InsufficientBalanceException;
import org.cap.service.AcccountService;
import org.cap.service.AccountServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class BankAppTest {

	private AcccountService accService;
	@Mock
	private AccountDao acc;
	
	
	@Before
	public void beforeMethod()
	{
		MockitoAnnotations.initMocks(this);
		accService=new AccountServiceImpl(acc);
		
	}
	@Test
	public void test_withdraw() throws InsufficientBalanceException 
	{
		Account account=new Account();
		account.setAccountNo(1001);
		account.setAmount(3000);
		Customer customer=new Customer();
		customer.setCustName("Laxmi");
		customer.setCustAddress(new Address());
		account.setCustomer(customer);
		
		//declaration
		Mockito.when(acc.findAccountById(1001)).thenReturn(account);
		
		//actual business logic
	     Account account2=accService.withdraw(1001, 500);
	     
	     Mockito.verify(acc).findAccountById(1001);
	     assertEquals(2500, account2.getAmount(),0.0);
	        
		
		
	}
}
