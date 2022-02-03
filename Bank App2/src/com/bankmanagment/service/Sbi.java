package com.bankmanagment.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.naming.InsufficientResourcesException;
import javax.security.auth.login.AccountNotFoundException;

import com.bank.Exception.AccountNoInvalidExcption;
import com.bank.Exception.InSuffitiantBalanceException;
import com.bank.Exception.NameInvalidException;
import com.cjc.Bank_model.Account;

public class Sbi implements Rbi  {

	Scanner sc = new Scanner(System.in);
	
	List l=new ArrayList<>();
	@Override
	public Account createAccount() {
		Account ac=new Account();

		System.out.println("Enter Account No");
		long acno=sc.nextLong();
		ac.setAccountNo(acno);
		
		System.out.println("Enter the Account Holder Name");
		String name=sc.next();
		name=name+sc.nextLine();
		String p=name.substring(0,2);
		
		if(p.equals("Mr")||p.equals("Ms")||p.equals("mr")){
			ac.setName(name);
		}
		else {
			throw new NameInvalidException("Enter Mr or Mis");
			}
		
		System.out.println("Enter the Account Holder Addres");
		ac.setAddres(sc.next());
		
		System.out.println("Enter the Account Holder Balance");
		ac.setBalance(sc.nextDouble());
		
		System.out.println("Enter the Account Holder PanNo");
		ac.setPanno(sc.next().toUpperCase());
		return ac;
		
		}

	

	@Override
	public void viewAccountDetails() {
		//System.out.println(l.size());
		Iterator itr=l.iterator();
		while(itr.hasNext()) {
				Account ac=(Account)itr.next();
				//System.out.println(ac);
			System.out.println("********************");
			System.out.println("Account No: "+ac.getAccountNo());
			System.out.println("Name: "+ac.getName());
			System.out.println("Addres: "+ac.getAddres());
			System.out.println("Balance: "+ac.getBalance());
			System.out.println("PanNo: "+ac.getPanno());
			System.out.println("********************");
	}
	}
	@Override
	public void depositeMoney() {
		Iterator itr=l.iterator();
		System.out.println("Enter Account No for Deposite");
		long acno=sc.nextLong();
		System.out.println("Enter the Mony");
		long cbal=sc.nextLong();
		boolean flag=true;
		while(itr.hasNext()) 
		{
				Account ac=(Account)itr.next();		
				if(ac.getAccountNo()==acno) {
					
					ac.setBalance(ac.getBalance()+cbal);
					System.out.println("Money Deposited Successfully....");
					System.out.println("Updated Balance is: "+ac.getBalance());
					flag=false;
				}
			}
		if(flag) {
			System.out.println("Account No Not Match");
		}
			
		
	}

	@Override
	public void withDrawal() throws InSuffitiantBalanceException {
				Iterator it1=l.iterator();
				System.out.println("Enter Account No for Withdrawal");
				long acno=sc.nextLong();
				System.out.println("Enter the Mony for withdrawl");
				long cbal=sc.nextLong();
				boolean f3=true;
				while(it1.hasNext()) {
						Account ac=(Account)it1.next();
						if(ac.getAccountNo()==acno) 
						{
							
							if(ac.getBalance()>=cbal)
							{
							     ac.setBalance(ac.getBalance()-cbal);
							     f3=false;
							     System.out.println("Money withdrawl Succesfully...");
							}
							else{
								System.out.println("Insufitiant balance");				//throw new InSuffitiantBalanceException("Insufitiant balance");
							}			
						}
				}
				if(f3) {
					System.out.println("Account No Not Match");
				}
						
				}	
		
	

	@Override
	public void viewBalance() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAccountDetails() {
		
		System.out.println("Enter Account Number for Updation");
		long acno=sc.nextLong();
		
		Iterator itr1=l.iterator();
		boolean flag=true;
		while(itr1.hasNext()) {
				Account account=(Account)itr1.next();
				if(acno==account.getAccountNo()) {
					System.out.println("Enter 1 to Change AccountNo");
					System.out.println("Enter 2 to Change Name");
					System.out.println("Enter 3 to Change Addres");
					System.out.println("Enter 4 to Exit");

					System.out.println("Enter the Choice..");
					int choice=sc.nextInt();
					switch(choice) {
					case 1:
						System.out.println("Enter New Account No");
						long nacno=sc.nextLong();
						account.setAccountNo(nacno);
						System.out.println("AccountNo updated Successfully.."+account.getAccountNo());
						break;
					case 2:
						System.out.println("Enter New Name");
						String nname=sc.next();
						account.setName(nname);
						System.out.println("Name updated Successfully.."+account.getName());
						break;
					case 3:
						System.out.println("Enter New Addres");
						String nadd=sc.next();
						account.setAddres(nadd);
						break;
					default:
						System.out.println("Incorrect choice");
						break;
						
					}
				}
				
		}
		
	}

}



	