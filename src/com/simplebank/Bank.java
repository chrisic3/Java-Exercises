package com.simplebank;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String name) {
        if (findBranch(name) != null) {
            return false;
        }

        branches.add(Branch.createBranch(name));
        return true;
    }

    public boolean addCustomer(String branchName, String name, double initialAmount) {
        Branch branch = findBranch(branchName);
        if (branch == null) {
            return false;
        }

        return branch.addCustomer(name, initialAmount);
    }


    public boolean addCustomerTransaction(String branchName, String name, double amount) {
        Branch branch = findBranch(branchName);
        if (branch == null) {
            return false;
        }

        return branch.addTransaction(name, amount);
    }

    public boolean listCustomers(String branchName, boolean showTransactions) {
        Branch branch = findBranch(branchName);
        if (branch == null) {
            return false;
        }

        System.out.println(branch.getName());

        ArrayList<Customer> branchCustomers = branch.getCustomers();

        for (int i = 0; i < branchCustomers.size(); i++) {
            Customer customer = branchCustomers.get(i);
            System.out.println(i + ": " + customer.getName());

            if (showTransactions) {
                ArrayList<Double> transactions = customer.getTransactions();
                for (int j = 0; j < transactions.size(); j++) {
                    System.out.println("\t" + transactions.get(j));
                }
            }
        }

        return true;
    }

    private Branch findBranch(String name) {
        for (int i = 0; i < branches.size(); i++) {
            if (branches.get(i).getName().equals(name)) {
                return branches.get(i);
            }
        }

        return null;
    }
}
