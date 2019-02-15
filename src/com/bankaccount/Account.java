package com.bankaccount;

public class Account {
    private int number;
    private double balance;
    private String customerName;
    private String customerEmail;
    private String customerPhone;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public void deposit(double deposit) {
        this.balance += deposit;
        System.out.println("$" + deposit + " was deposited, balance now $" + this.balance);
    }

    public void withdrawal(double withdrawal) {
        if (this.balance < withdrawal) {
            System.out.println("Insufficient funds. Withdrawal cancelled.");
        } else {
            this.balance -= withdrawal;
            System.out.println("$" + withdrawal + " was withdrawn, balance now $" + this.balance);
        }
    }
}
