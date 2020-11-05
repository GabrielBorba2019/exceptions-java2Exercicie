package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;

//Utilizando o conceito de excepitons para otimização do código
//#Part1: Sem tratamento da exceções, validações no main program

public class Program {
	public static void main (String [] args) {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
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
		Double withdraw = sc.nextDouble();
		
		if(withdraw > withdrawLimit) {
			System.out.println("Withdraw error: The amout exceeds withdraw limit" );
		}
		
		else {
			System.out.println("Nem balance: " + account.getBalance());
		}
	
		sc.close();
	}
}
