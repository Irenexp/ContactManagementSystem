# ContactManagementSystem


Project Overview: Developed a contact management system in Java that allows users to add, view, search, and manage contacts. Contacts can be organized into different categories, and users can perform various operations on them.


Contact Class:
A base class called Contact that includes common attributes like name, email, and phone number.

ContactCategory Interface:
An interface called ContactCategory that includes methods like addContact(), removeContact(), viewContacts(), and searchContacts(). 

ContactCategory Classes:
3 classes that implement the ContactCategory interface, representing different categories of contacts (e.g., PersonalContactCategory, WorkContactCategory, FamilyContactCategory). These classes maintain a list of contacts using an ArrayList. 

ContactManager Class:
A class that acts as a central hub for managing different categories of contacts. The ContactManager class allows users to switch between contact categories and perform operations like adding, removing, viewing, and searching for contacts across categories. Used a HashMap to map category names to their respective ContactCategory objects.

File I/O:
Implemented file I/O operations to read and write contacts to a file. Each contact category has its file for storing contacts. Users are able to load existing contacts from files when the program starts and save contacts when they make changes. The file I/O operations are also error-handled.

User Interface:
Users can interact with the contact management system through the scanner Use a menu-driven approach to provide options for adding, removing, viewing, and searching for contacts. Project Structure:

lua Copy code src/ |-- Contact/ | |-- Contact.java | |-- ContactCategories/ | |-- ContactCategory.java | |-- PersonalContactCategory.java | |-- WorkContactCategory.java | |-- ContactManager.java |-- Main.java Project Guidelines:
