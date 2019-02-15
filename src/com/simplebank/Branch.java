package com.simplebank;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean addCustomer(String name, double initialAmount) {
        if (findCustomer(name) != null) {
            return false;
        }

        customers.add(Customer.createCustomer(name, initialAmount));
        return true;
    }

    public static Branch createBranch(String name) {
        return new Branch(name);
    }

    public boolean addTransaction(String name, double amount) {
        Customer customer = findCustomer(name);
        if (customer == null) {
            return false;
        }

        customer.addTransaction(amount);
        return true;
    }

    private Customer findCustomer(String name) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().equals(name)) {
                return customers.get(i);
            }
        }

        return null;
    }
}
