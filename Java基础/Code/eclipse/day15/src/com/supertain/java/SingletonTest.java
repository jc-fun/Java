package com.supertain.java;

public class SingletonTest {
	public static void main(String[] args) {
		Bank bank1 = Bank.instance;
		Bank bank2 = Bank.instance;
//		Bank.instance = null;
		System.out.println(bank1 = bank2);
	}
}


class Bank {
	
	private Bank() {
		
	}
	
	public static final Bank instance = new Bank();
}