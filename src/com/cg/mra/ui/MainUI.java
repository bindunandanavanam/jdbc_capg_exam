package com.cg.mra.ui;

import java.util.Scanner;

import com.cg.mra.beans.Account;
import com.cg.mra.service.AccountService;
import com.cg.mra.service.AccountServiceImpl;
import com.cg.mra.userexception.AccountException;
import com.cg.mra.userexception.InvalidMobileNoException;
import com.cg.mra.userexception.UserException;

public class MainUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account a = new Account();
		AccountService as = new AccountServiceImpl();
		do {
			System.out.println("Select the option");
			System.out.println("1. Account Balance Enquiry \n 2. Recharge Account \n 3. Exit");
			Scanner sc = new Scanner(System.in);
			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				System.out.println("enter mobile number");
				String mobileNo = sc.next();
				if (mobileNo.length() != 10) {
					try {
						throw new InvalidMobileNoException();
					} catch (Exception e) {

					}
				}
				a = as.getAccountDetails(mobileNo);
				if (a != null) {
					System.out.println("Hello "+a.getCustomerName()+" ,current balance is " + a.getAccountBalance());
				} else {
					try {
						throw new UserException();
					} catch (Exception e) {

					}
				}
				break;
			case 2:
				System.out.println("enter mobile number");
				String mobile = sc.next();
				if (mobile.length() != 10) {
					try {
						throw new InvalidMobileNoException();
					} catch (Exception e) {

					}
				}

				a = as.getAccountDetails(mobile);
				if (a != null) {
					System.out.println("enter amt to recharge");
					double amt = sc.nextDouble();
					int res = as.rechargeAccount(mobile, amt);
					if (res != 0) {
						System.out.println("Your Account Recharged Successfully ");
						System.out.println("Hello " + a.getCustomerName() + ", Available Bal is " + res);
					}
				} else {
					try {
						throw new AccountException();
					} catch (Exception e) {

					}
				}

				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("invalid choice");
			}
		} while (true);

	}

	public void disp(String string, double double1) {
		// TODO Auto-generated method stub
		
	}

}
