package org.example;

import java.util.ArrayList;
import java.util.List;

public class FamilyContactCategory implements ContactCategory {

    private List<Contact> contacts = new ArrayList<>();

    @Override
    public void addContact(Contact contact) {

        contacts.add(contact);
        System.out.println("The contact has been added successfully as family contact!");

    }

    @Override
    public void removeContact(String contactName) {

        contacts.removeIf(contact -> contact.getName().equalsIgnoreCase(contactName));
        System.out.println("The contact has been removed successfully from family contact!");

    }

    @Override
    public void viewContacts() {
        System.out.println("***************************************");
        if (contacts.isEmpty()) {
            System.out.println("Your contact list is vacant.");
        }else {
            System.out.println("Please see below for family contacts:");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
        System.out.println("***************************************");
    }

    @Override
    public Contact searchContacts (String contactName){
        System.out.println("Please see below for result of searching " + contactName + " in family contact: ");
        for (Contact contact : contacts) {

            if (contact.getName().equalsIgnoreCase(contactName)) {
                return contact;
            }

        }
        System.out.println("No such person found.");
        return null;
    }


    public List<Contact> getContacts () {
        return contacts;
    }


    public void setContacts (List < Contact > contactList) {
        contacts.addAll(contactList);

    }

}