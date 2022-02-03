package com.bankmanagment.Controler;

import java.util.Scanner;

import com.bank.Exception.InSuffitiantBalanceException;
import com.bankmanagment.service.Rbi;
import com.bankmanagment.service.Sbi;
import com.cjc.Bank_model.Account;

import Database.DBOperations;

public class Admin {
	
	public static void main(String[] args) throws Exception {
		Rbi i=new Sbi();
		DBOperations db=new DBOperations();
		int x;
		
		boolean flag=true;
		while(flag) {
			System.out.println("****************************");
			System.out.println("1 Craete Account");
			System.out.println("2.ViewAllAccountDetails");
			System.out.println("3.DepositeBalance");
			System.out.println("4.WithDrawal");
			System.out.println("5.UpdateAccountDetails");
			System.out.println("6.ViewSingleRecord");

			System.out.println("7.Exite");
			Scanner sc=new Scanner(System.in);
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				//db.createTable();
				Account a = i.createAccount();
							long acno=a.getAccountNo();
							String add = a.getAddres();
							double b = a.getBalance();
							String name = a.getName();
							String panno = a.getPanno();
							db.insertAccount(acno,add,b,name,panno);
							
				break;
			case 2:
				//i.viewAccountDetails();
				db.selectAllRecord();
				break;
			case 3:
				//i.depositeMoney();
				db.updateBalance();
				
				break;
			case 4:
					db.withDrawal();
					//i.withDrawal();
				break;
			case 5:
				db.upadteAccount();
				break;
			case 6:
				db.viewSigleRecord();
				break;
			case 7:
				flag=false;
				break;
			default:
				System.out.println("Enter Valid Choice");
			}
		}
	}
	
}
