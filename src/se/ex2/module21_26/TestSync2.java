package se.ex2.module21_26;

import java.io.PrintWriter;

public class TestSync2 {
    static int balance = 1000; // simulate balance kept remotely

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);
        Account2 account = new Account2(out);
        DepositThread2 first, second;
        first = new DepositThread2(account, 1000, "#1");
        second = new DepositThread2(account, 1000, "\t\t\t\t#2");
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

class Account2 {
    PrintWriter out;

    Account2(PrintWriter out) {
        this.out = out;
    }

    void deposit(int amount, String name) {
        int balance;
        out.println(name + " trying to deposit " + amount);
        synchronized (this) { // method 內必需synchronized的片段程式碼
            out.println(name + " getting balance..."); //
            balance = getBalance(); //
            out.println(name + " balance got is " + balance); //
            balance += amount; //
            out.println(name + " setting balance..."); //
            setBalance(balance); //
        } //
        out.println(name + " new balance set to " + TestSync2.balance);
    }

    int getBalance() {
        // simulate the delay in getting balance remotely
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        return TestSync2.balance;
    }

    void setBalance(int balance) {
        // simulate the delay in setting new balance remotely
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        TestSync2.balance = balance;
    }
}

class DepositThread2 extends Thread {//宣告並定義despo類別繼承th類別
    Account2 account;
    int depositAmount;
    String message;

    DepositThread2(Account2 account, int amount, String message) {
        this.message = message;
        this.account = account;
        this.depositAmount = amount;
    }

    @Override
    public void run() {
        account.deposit(depositAmount, message);
    }
}
