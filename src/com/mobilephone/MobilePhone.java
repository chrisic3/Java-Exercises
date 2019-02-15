package com.mobilephone;

import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contact> contacts;

    public MobilePhone() {
        this.contacts = new ArrayList<Contact>();
    }
    // add contact
    public boolean addContact(Contact contact) {
        if (findContact(contact.getName()) < 0) {
            return false;
        }

        contacts.add(contact);
        return true;
    }

    // modify contact
    public boolean modifyContact(Contact contact, Contact newContact) {
        int index = findContact(contact);
        if (index < 0) {
            return false;
        }

        contacts.set(index, newContact);
        return true;
    }

//    private void modifyContact(int index, Contact contact) {
//        contacts.set(index, contact);
//    }

    // remove contact
    public boolean removeContact(Contact contact) {
        int index = findContact(contact);
        if (index < 0) {
            return false;
        }

        contacts.remove(contact);
        return true;
    }

//    private void removeContact(int index) {
//        contacts.remove(index);
//    }

    // find contact
    private int findContact(Contact contact) {
        return contacts.indexOf(contact);
    }

    private int findContact(String name) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(name)) {
                return i;
            }
        }

        return -1;
    }

//    public boolean contactExists(Contact contact) {
//        int index = findContact(contact);
//        return (index < 0);
//    }

    public Contact contactExists(String name) {
        int index = findContact(name);
        if (index >= 0) {
            return contacts.get(index);
        }

        return null;
    }

    // print contact list
    public void printContactList() {
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i).getName() + " " + contacts.get(i).getPhoneNumber());
        }
    }
}
