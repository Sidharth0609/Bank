package banking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BankManagement {
	static Connection con = connection.getConnection();
	public static void AccountOpen(String name,int balance,String Phone) throws ClassNotFoundException, SQLException {
		try {
			Statement stmt = con.createStatement();
			String query="Insert INTO Customer(Cname,Balance,Phone_No) VALUES('"+name+"',"+ balance +","+Phone+")";			
			int count = stmt.executeUpdate(query);
			String queryy="SELECT Cid from Customer"+ " where Phone_No = "+Phone+"";
			ResultSet rest=stmt.executeQuery(queryy);
			int id=0;
			while(rest.next()) {
				id=rest.getInt("Cid");
			}
			if(count>0) {
				System.out.println("Your Account created successfully! \nyour customer id is : "+id +"\nBalance : Rs"+balance);
			} else {
				System.out.println("There is some error while creating your account");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void checkBalance(int id) throws ClassNotFoundException, SQLException {
		try {
			Statement stmt = con.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT Cname,balance FROM Customer" + " where Cid= "+id+"");
			int amt=0;
			String name="";
			while (rset.next()) {
				name=rset.getString("Cname");
			    amt=rset.getInt("balance");
			}
				System.out.println("Customer name : " +name+ "\nCustomer id : "+ id + "\nCurrent balance : Rs."+amt);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void withdrawal(int id,int amount) throws ClassNotFoundException, SQLException {
		try {
			Statement stmt = con.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT balance FROM Customer" + " where Cid= "+id+"");
			int amt=0;
			while (rset.next())
			    amt=rset.getInt(1);
			if(amt<amount) {
				System.out.println("You Don't have sufficient balance");
			}else {
					amt-=amount;
					stmt.executeUpdate("UPDATE Customer " + "SET balance="+amt+" where Cid="+id+"");
					ResultSet rsett = stmt.executeQuery("SELECT Cname ,balance FROM Customer" + " where Cid= "+id+"");
					int amtt=0;
					String name="";
					while(rsett.next()) {
					name=rsett.getString("Cname");
			        amtt = rsett.getInt("balance");
					}
					System.out.println("Customer name : " +name+ "\nCustomer id : "+ id + "\nWithdrawal amount Rs."+amount+"\nCurrent balance : Rs."+amtt);
				}
			} catch(Exception e) {
				e.printStackTrace();
		}
	}		
	public static void deposit(int id,int amount) throws SQLException, ClassNotFoundException {
		try {
			Statement stmt = con.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT balance FROM Customer" + " where Cid= "+id+"");
			int amt=0;
			while (rset.next())
			    amt=rset.getInt("balance");
			amt+=amount;
			stmt.executeUpdate("UPDATE Customer " + "SET balance="+amt+" where Cid="+id+"");
			ResultSet rsett = stmt.executeQuery("SELECT Cname,balance FROM Customer" + " where Cid="+id+"");
			int amtt=0;
			String name="";
			while(rsett.next()) {
				name=rsett.getString("Cname");
				amtt = rsett.getInt("balance");
			}
			System.out.println("Customer name : " +name+ "\nCustomer id : "+ id + "\nDeposited amount Rs."+amount+"\nCurrent balance : Rs."+amtt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
