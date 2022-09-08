package banking;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		@SuppressWarnings("resource")
		Scanner scn=new Scanner(System.in);
		while(true) {
			System.out.println("|----------------------------------------------------|");
			System.out.println("|                        Menu                        |");
			System.out.println("|----------------------------------------------------|");
			System.out.println("|             Choose what you want to do             |");
			System.out.println("|----------------------------------------------------|");
			System.out.println("| Press 1 For opening a new account                  |");
			System.out.println("| Press 2 For check the balance in your account      |");
			System.out.println("| Press 3 For Withdrawal an ammount form your account|");
			System.out.println("| Press 4 For deposit an ammount in your account     |");
			System.out.println("| Press 5 If you want to exit                        |");
			System.out.println("|----------------------------------------------------|");
			System.out.println("            Enter your option here                    ");

			int option=scn.nextInt();
			switch(option) {
				case 1:
					System.out.println("Enter the name of the account holder:");
					String name=scn.next();
					System.out.println("Enter the initial amount you want to deposit in you account");
					int balance=scn.nextInt();	
					System.out.println("Enter your phone number");
					String Phone=scn.next();
					BankManagement.AccountOpen(name,balance,Phone);
					scn.next();
					break;
				case 2:
					System.out.println("Enter you customer ID");
					int id1=scn.nextInt();
					BankManagement.checkBalance(id1);
					scn.next();
					break;
				case 3:
					System.out.println("Enter you customer ID");
					int id2=scn.nextInt();
					System.out.println("Enter amount you want to withdrawal");
					int amount=scn.nextInt();
					BankManagement.withdrawal(id2,amount);
					scn.next();
					break;
				case 4:
					System.out.println("Enter you customer ID");
					int id3=scn.nextInt();
					System.out.println("Enter amount you want to deposit");
					int amount1=scn.nextInt();
					BankManagement.deposit(id3,amount1);
					scn.next();
					break;
				case 5:
					System.out.println("Exit successfully");
					return;
				default:
					System.out.println("Wrong input enter again");
					scn.next();
					break;
			}
		}
	}
}
