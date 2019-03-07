package com.cg.mra.dao;
import java.sql.*;
import com.cg.mra.beans.Account;
public class AccountDaoImpl implements AccountDao {
	static Account a = new Account();

	/*public Account setInfo() {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter  mobile number");
		a.setMobile(sc.next());
		System.out.println("enter name");
		a.setCustomerName(sc.next());
		a.setAccountBalance(0);
		sc.close();
		return a;

	}

	public void Register() {
		AccountDaoImpl ad = new AccountDaoImpl();
		ad.setInfo();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bindu", "root", "root");

			PreparedStatement ps = con.prepareStatement("insert into customer values(?,?,?)");

			ps.setString(1, a.getMobile());
			ps.setString(2, a.getCustomerName());
			ps.setDouble(3, a.getAccountBalance());

			int i = ps.executeUpdate();
			if (i == 1) {
				System.out.println("done");
			} else {
				System.out.println("could not insert data");
			}
			System.out.println("bal is " + a.getAccountBalance());

			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Ato-generated catch block
			e.printStackTrace();
		}
	}*/

	@Override
	public Account getAccountDetails(String mobileNo) {
		//Register();
		a.setMobile(mobileNo);
		int c=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bindu", "root", "root");
			PreparedStatement ps = con.prepareStatement("select * from customer where mobile=?");
			ps.setString(1, a.getMobile());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("Welcome " + rs.getString(2));
				a.setCustomerName(rs.getString(2));
				a.setAccountBalance(rs.getDouble(3));
				c=1;
			} else {
				c=0;
			}

			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(c==1)
		return a;
		else
			return null;
	}

	@Override
	public int rechargeAccount(String mobileNo, double rechargeAmount) {
		int res=0,x=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bindu","root","root");
			 res=(int) (rechargeAmount+a.getAccountBalance());
			a.setAccountBalance(res);
			PreparedStatement ps= con.prepareStatement("update customer set bal=? where mobile=?");
			ps.setDouble(1,a.getAccountBalance());
			ps.setString(2,a.getMobile());
			System.out.println(a.getAccountBalance());
			 x=ps.executeUpdate();
	}catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		if(x==1)
		return res;
		else 
			return 0;

	}
}
