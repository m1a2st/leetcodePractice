package practice.se.ex2.module21_26;

import java.io.PrintWriter;

public class TestSync3 {
    static int balance = 1000; // simulate balance kept remotely

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);
        Account3 account = new Account3(out);
        DepositThread3 first, second;
        first = new DepositThread3(account, 1000, "#1");
        second = new DepositThread3(account, 1000, "\t\t\t\t#2");
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

class Account3 {
    PrintWriter out;

    Account3(PrintWriter out) {
        this.out = out;
    }

    void deposit(int amount, String name) {
        int balance;
        out.println(name + " trying to deposit " + amount);
        out.println(name + " getting balance...");
        balance = getBalance();
        out.println(name + " balance got is " + balance);
        balance += amount;
        out.println(name + " setting balance...");
        setBalance(balance);
        out.println(name + " new balance set to " + TestSync3.balance);
    }

    int getBalance() {
        // simulate the delay in getting balance remotely
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        return TestSync3.balance;
    }

    void setBalance(int balance) {
        // simulate the delay in setting new balance remotely
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        TestSync3.balance = balance;
    }
}

class DepositThread3 extends Thread {
    Account3 account;
    int depositAmount;
    String message;

    DepositThread3(Account3 account, int amount, String message) {
        this.message = message;
        this.account = account;
        this.depositAmount = amount;
    }

    public void run() {
        synchronized (account) { // synchronized 於執行緒 run() method 內 //TestSync3.class
            account.deposit(depositAmount, message);
        }
    }
}
