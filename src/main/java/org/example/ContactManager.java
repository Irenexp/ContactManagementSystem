package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class ContactManager {
    private HashMap<String, ContactCategory> categories = new HashMap<>();
    public final String family = "family";
    public final String personal = "personal";
    public final String work = "work";

    public ContactManager() {

        this.categories.put(family, new FamilyContactCategory());
        this.categories.put(personal, new PersonalContactCategory());
        this.categories.put(work, new WorkContactCategory());

    }

    public void addCategory(String categoryName, ContactCategory category) {
        categories.put(categoryName, category);
    }

    //option 1, there will be 2 steps
    public ContactCategory getCategory(String categoryName) {
        return categories.get(categoryName);
    }

    //option 2
    public void addContact(String targetCategory, Contact contact) {
        categories.get(targetCategory.toLowerCase()).addContact(contact);

    }

    public void removeContact(String targetCategory, String contactName) {
        categories.get(targetCategory.toLowerCase()).removeContact(contactName);

    }

    public void viewContact(String targetCategory) {
        categories.get(targetCategory.toLowerCase()).viewContacts();
    }

    public void searchContact(String targetCategory, String contactName) {
        categories.get(targetCategory.toLowerCase()).searchContacts(contactName);
    }

    String fileText;

    //Write contacts to a file
    public void writeContactsToFile(String categoryName) {
        ContactCategory categoryToSave = categories.get(categoryName);
        String csvFileName = "/Users/haochuan/Dev/workspace/ContactManagementSystem/src/main/resources/Contacts.csv";
        if (categoryToSave != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFileName))) {
                // Write the header row
                writer.write("Name,Email,Phone");
                writer.newLine();

                for (Contact contact : categoryToSave.getContacts()) {
                    writer.write(contact.getName() + "," + contact.getEmail() + "," + contact.getPhoneNumber());
                    writer.newLine();
                }
                System.out.println("Contacts saved successfully.");

            } catch (IOException e) {
                System.out.println("Error saving contacts: " + e.getMessage());
            }
        } else {
            System.out.println("Category not found.");
        }
    }

    public void loadContactsFromFile(String categoryName) {
        ContactCategory loadedCategory = categories.get(categoryName);
        List<Contact> contactList = new ArrayList<>();
        if (loadedCategory != null) {
            try {
                FileReader fileReader = new FileReader("/Users/haochuan/Dev/workspace/ContactManagementSystem/src/main/resources/Contacts.csv");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                //Read the header
                fileText = bufferedReader.readLine();
                while ((fileText = bufferedReader.readLine()) != null) {
                    String[] data = fileText.split(",");
                    if (data.length == 3) {
                        String name = data[0];
                        String email = data[1];
                        String phoneNumber = data[2];
                        contactList.add(new Contact(name, email, phoneNumber));
                    }
                }
                bufferedReader.close();
                for (Contact contact: contactList) {
                    loadedCategory.addContact(contact);
                }
                System.out.println("Contacts loaded successfully.");

            } catch (IOException e) {
                System.out.println("Error loading contacts: " + e.getMessage());
            }

        } else {
            System.out.println("Category not found.");
        }
    }

}