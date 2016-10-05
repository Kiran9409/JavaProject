package com.capgemini.test;

import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.capgemini.exceptions.InsufficientInitialBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.repository.AccountRepository;
import com.capgemini.service.AccountService;
import com.capgemini.service.AccountServiceImpl;

public class AccountTest 
{
	AccountService accountService;
	@Mock
	AccountRepository accountRepository;
	@Before
	public void setUp() throws Exception
	{
		MockitoAnnotations.initMocks(this);
		accountService = new AccountServiceImpl(accountRepository);
	}

	/*
	 * test cases for create account
	 * 1. when the amount is less than 500 system should throw exception
	 * 2. when the valid info is passed account should be created successfully
	 */
	
	@Test(expected = com.capgemini.exceptions.InsufficientInitialBalanceException.class)
	public void whenTheAmountIsLessThan500SystemShouldThrowException() throws InsufficientInitialBalanceException, InvalidAccountNumberException
	{
		accountService.createAccount(101, 0);
	}
	
	@Test(expected=com.capgemini.exceptions.InvalidAccountNumberException.class)
	public void whenTheAccountisAlreadyExistSystemshouldThrowException() throws InsufficientInitialBalanceException, InvalidAccountNumberException
	{
		accountService.createAccount(10, 100);
	}
	
	@Test(expected=com.capgemini.exceptions.InvalidAccountNumberException.class)
	public void whenThInvalideAccountNoSystemshouldThrowException() throws InsufficientInitialBalanceException, InvalidAccountNumberException
	{
		accountService.createAccount(102, 800);
	}
	
	@Test(expected=com.capgemini.exceptions.InvalidAccountNumberException.class)
	public void whenThInvalideCustomerSystemshouldThrowException() throws InsufficientInitialBalanceException, InvalidAccountNumberException
	{
		accountService.createAccount(102, 800);
	}
	@Test(expected=com.capgemini.exceptions.InvalidAccountNumberException.class)
	public void whenvalideInfoSystemshouldDisplaySuccess() throws InsufficientInitialBalanceException, InvalidAccountNumberException
	{
		accountService.createAccount(102, 800);
	}
	
	/*test cases for withdraw
	 * 1.When the amount is less than 100 system should throw an exception
	 * 2.When the amount is greater than 100 amount should be withdrawn
	 * 3.When the Invalid Amount is entered system should throw an exception
	 * 4.When the valid Amount is entered amount Should be withdrawn.
	 * */
	
	@Test(expected=com.capgemini.exceptions.InsufficientBalanceException.class)
	public void WhenTheAmountisLessThan100SystemShouldThrowanexception() throws InsufficientInitialBalanceException
	{
		accountService.withdrawl(101, 100);
	}
}
