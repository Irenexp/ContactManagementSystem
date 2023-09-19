package org.example;

import java.util.List;

public interface ContactCategory {

    void addContact(Contact contact);

    void removeContact(String contactName);

    void viewContacts();

    Contact searchContacts(String contactName);


    List<Contact> getContacts();

    void setContacts(List<Contact> contactList);

}
