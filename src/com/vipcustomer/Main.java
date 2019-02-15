/*
    Create a new class VipCustomer
    it should have 3 fields name, credit limit, and email address.
    create 3 constructors
    1st constructor empty should call the constructor with 3 parameters with default values
    2nd constructor should pass on the 2 values it receives and add a default value for the 3rd
    3rd constructor should save all fields.
    create getters only for this using code generation of intellij as setters wont be needed
    test and confirm it works.
 */

package com.vipcustomer;

public class Main {

    public static void main(String[] args) {
        VipCustomer bob = new VipCustomer("Bob", "bob@test.com");

        System.out.println(bob.getName());
        System.out.println(bob.getEmail());
        System.out.println(bob.getCreditLimit());

        VipCustomer jim = new VipCustomer();

        System.out.println(jim.getName());
        System.out.println(jim.getEmail());
        System.out.println(jim.getCreditLimit());

        VipCustomer bill = new VipCustomer("Bill", "bill@test.com");

        System.out.println(bill.getName());
        System.out.println(bill.getEmail());
        System.out.println(bill.getCreditLimit());
    }
}
