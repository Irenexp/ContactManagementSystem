package org.example;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        ContactManager contactManager = new ContactManager();

        Scanner myScanner = new Scanner(System.in);
        System.out.println("Welcome to the Contact Management System.");

        while (true){
            System.out.println("Please select an option:");
            System.out.println("1. Go to Family Contact Category");
            System.out.println("2. Personal Contact");
            System.out.println("3. Work Contact");
            System.out.println("4. Quit");

            int categoryAnswer = new Scanner(System.in).nextInt();
            String categoryName;

            switch (categoryAnswer) {
                case 1: categoryName = contactManager.family; break;
                case 2: categoryName = contactManager.personal; break;
                case 3: categoryName = contactManager.work; break;
                default: categoryName = "Quit"; break;
            }

            if (categoryName.equalsIgnoreCase("Quit")){
                break;
            }
            System.out.println("Please select an option: ");
            System.out.println("1. Add contact");
            System.out.println("2. Remove contact");
            System.out.println("3. View contacts");
            System.out.println("4. Search contacts");
            System.out.println("5. Load contact files");
            System.out.println("6. Exit");
            int optionAnswer = myScanner.nextInt();

            Scanner newScanner = new Scanner(System.in);
            switch (optionAnswer) {
                case 1 :
                    System.out.println("Please enter name");
                    String addNameAnswer = newScanner.nextLine();
                    System.out.println("Please enter email");
                    String emailAnswer = newScanner.nextLine();
                    System.out.println("Please enter phone number");
                    String numberAnswer = newScanner.nextLine();

                    Contact contact = new Contact(addNameAnswer, emailAnswer, numberAnswer);
                    contactManager.addContact(categoryName, contact);

                    contactManager.writeContactsToFile(categoryName);

                    break;

                case 2 :
                    System.out.println("Please enter the name of the contact you want to remove");
                    String removeNameAnswer = myScanner.nextLine();

                    contactManager.removeContact(categoryName,removeNameAnswer);

                    contactManager.writeContactsToFile(categoryName);
                    break;

                case 3 :
                    contactManager.viewContact(categoryName);
                    break;

                case 4 :
                    System.out.println("Please enter the name you want to search");
                    String searchNameAnswer = myScanner.nextLine();
                    contactManager.searchContact(categoryName,searchNameAnswer);
                    break;

                case 5 :
                    contactManager.loadContactsFromFile(categoryName);
                    break;

                case 6 :
                    System.out.println("Great, goodbye!");
                    myScanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid input.");
            }
        }

    }
}