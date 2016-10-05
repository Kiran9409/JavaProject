package com.capgemini.service;

import com.capgemini.exceptions.InsufficientInitialBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.model.Account;
import com.capgemini.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {

	private AccountRepository accountRepository;
	
	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository=accountRepository;
	}
	@Override
	public Account createAccount(int accountNumber, int amount) throws InsufficientInitialBalanceException ,InvalidAccountNumberException
	{
		if(amount<500)
		{
			throw new InsufficientInitialBalanceException();
		}
		
		
		/*if(accountNumber<0)
		{
			throw new InvalidAccountNumberException();
		}
*/		
		Account account = new Account();
		account.setAccountNumber(accountNumber);
		account.setAmount(amount);
		
		if(accountRepository.save(account))
		{
			return account;
		}
		
		return null;
	}

	@Override
	public int showBalance(int accountNumber) throws InvalidAccountNumberException {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int withdrawl(int accountNumber, int amount) throws InsufficientInitialBalanceException {
		
		if(amount<=100)
		{
			throw new InsufficientInitialBalanceException();
		}
		else
		{
			
		Account account = new Account();
		account.setAccountNumber(accountNumber);
		account.setAmount(amount);
		}
		
		
		return 0;
	}

}
