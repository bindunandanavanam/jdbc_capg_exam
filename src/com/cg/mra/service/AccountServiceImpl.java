package com.cg.mra.service;


import com.cg.mra.beans.Account;
import com.cg.mra.dao.AccountDao;
import com.cg.mra.dao.AccountDaoImpl;

public class AccountServiceImpl implements AccountService {
	AccountDao ad=new AccountDaoImpl();
	@Override
	public Account getAccountDetails(String mobileNo) {
		// TODO Auto-generated method stub
		
		Account a=ad.getAccountDetails(mobileNo);
		

		return a;
	}

	@Override
	public int rechargeAccount(String mobileno, double rechargeAmount) {
		int res=0;
		res=ad.rechargeAccount(mobileno, rechargeAmount);
		return res;
	}
}
