package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exception.DomainException;

//Utilizando o conceito de excepitons para otimização do código
//#Part2: Com tratamento das exceções/validações delegadas para a classe account

public class Program {
	public static void main (String [] args) {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			System.out.print("Initial Balance: ");
			double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
		
			Account account = new Account(number,holder, balance, withdrawLimit);
		
			System.out.print("\nEnter amount for withdraw: ");
			double amount = sc.nextDouble();
			account.withdraw(amount);
			System.out.println("New balance: " +  String.format("%.2f", account.getBalance()));
		}
		catch (DomainException e) {
			System.out.println("Witdraw error: " +  e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected Error: " + e.getMessage());
		}
		
		sc.close();
	}
}
