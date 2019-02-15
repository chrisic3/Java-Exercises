/*
    Create a program that implements a simple mobile phone with the following capabilities.
    Able to store, modify, remove and query contact names.
    You will want to create a separate class for Contact (name and phone number).
    Create a master class (MobilePhone) that holds the ArrayList of Contact
    The MobilePhone class has the functionality listed above.
    Add a menu of options that are available.
    Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
    and search/find contact.
    When adding or updating be sure to check if the contact already exists (use name)
    Be sure not to expose the inner workings of the Arraylist to MobilePhone
    e.g. no ints, no .get(i) etc
    MobilePhone should do everything with Contact objects only.
 */

package com.mobilephone;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;

        printInstructions();

        while (!quit) {
            System.out.println("Enter your choice:");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    mobilePhone.printContactList();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    modifyContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    findContact();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

    // instructions
    public static void printInstructions() {
        System.out.println("\nSelections:");
        System.out.println("\t0. Print choices");
        System.out.println("\t1. Print contact list");
        System.out.println("\t2. Add new contact");
        System.out.println("\t3. Modify existing contact");
        System.out.println("\t4. Remove existing contact");
        System.out.println("\t5. Search for contact");
        System.out.println("\t6. Power off");
    }

    // add contact
    public static void addContact() {
        System.out.println("Enter new contact name:");
        String name = scanner.nextLine();

        System.out.println("Enter new contact phone number (format (000) 000-0000):");
        String phoneNumber = scanner.nextLine();

        Contact contact = Contact.createContact(name, phoneNumber);

        if (mobilePhone.addContact(contact)) {
            System.out.println(name + " added.");
        } else {
            System.out.println("Contact already exists.");
        }
    }

    // modify contact
    public static void modifyContact() {
        System.out.println("Enter name to modify:");
        String currentName = scanner.nextLine();
        Contact existingContact = mobilePhone.contactExists(currentName);

        if (existingContact == null) {
            System.out.println("Contact not found.");
            return;
        }

        System.out.println("Enter new name:");
        String newName = scanner.nextLine();

        System.out.println("Enter new phone number:");
        String newNumber = scanner.nextLine();

        Contact newContact = Contact.createContact(newName, newNumber);

        mobilePhone.modifyContact(existingContact, newContact);
    }

    // remove contact
    public static void removeContact() {
        System.out.println("Enter name to be removed:");
        String name = scanner.nextLine();

        Contact contact = mobilePhone.contactExists(name);

        if (contact == null) {
            System.out.println("Cannot find contact.");
        } else {
            mobilePhone.removeContact(contact);
        }
    }

    // search for contact
    public static void findContact() {
        System.out.println("Enter name to find:");
        String name = scanner.nextLine();

        Contact contact = mobilePhone.contactExists(name);

        if (contact != null) {
            System.out.println(name + " exists.");
        } else {
            System.out.println(name + " does not exist.");
        }
    }
}
