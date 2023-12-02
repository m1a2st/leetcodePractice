package se.ex2.module21_26;

import java.io.PrintWriter;

public class TestSync1 {
	static int balance = 1000; // simulate balance kept remotely

	public static void main(String args[]) {
		PrintWriter out = new PrintWriter(System.out, true);
		Account1 account = new Account1(out);
		DepositThread1 first, second;
		first = new DepositThread1(account, 1000, "#1");
		second = new DepositThread1(account, 1000, "\t\t\t\t#2");
		// start the transactions
		first.start();
		second.start();
		// wait for both transactions to finish
		try {
			first.join();
			second.join();
		} catch (InterruptedException e) {
		}
		// print the final balance
		out.println("*** Final balance is " + balance);
	}
}

class Account1 {
	PrintWriter out;

	Account1(PrintWriter out) {
		this.out = out;
	}

	synchronized void deposit(int amount, String name) { // synchronized 整個存款method
		int balance;
		out.println(name + " trying to deposit " + amount);
		out.println(name + " getting balance...");
		balance = getBalance();
		out.println(name + " balance got is " + balance);
		balance += amount;
		out.println(name + " setting balance...");
		setBalance(balance);
		out.println(name + " new balance set to " + TestSync1.balance);
	}

	int getBalance() {
		// simulate the delay in getting balance remotely
		try { 
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		return TestSync1.balance;
	}

	void setBalance(int balance) {
		// simulate the delay in setting new balance remotely
		try { 
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		TestSync1.balance = balance;
	}
}

class DepositThread1 extends Thread {
	Account1 account;
	int depositAmount;
	String message;

	DepositThread1(Account1 account, int amount, String message) {
		this.message = message;
		this.account = account;
		this.depositAmount = amount;
	}

	public void run() {
		account.deposit(depositAmount, message);
	}
}
