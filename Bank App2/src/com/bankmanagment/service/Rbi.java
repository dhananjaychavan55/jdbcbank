package com.bankmanagment.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.bank.Exception.InSuffitiantBalanceException;
import com.cjc.Bank_model.Account;

public interface Rbi {

	public Account createAccount();
	public void viewAccountDetails();
	public void depositeMoney();
	public void withDrawal();
	public void viewBalance();
	public void updateAccountDetails();
	
	
}
