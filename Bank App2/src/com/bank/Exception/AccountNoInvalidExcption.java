package com.bank.Exception;

import java.util.InputMismatchException;

public class AccountNoInvalidExcption extends InputMismatchException {

	public AccountNoInvalidExcption(String msg) {
		super("Enter Digits Only");
	}
}
