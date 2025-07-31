import java.io.*;
import java.util.ArrayList;

class contact {
    public static void main(String args[]) throws IOException {
        DataInputStream in = new DataInputStream(System.in);
        ArrayList<String> contacts = new ArrayList<>();
        int choice;
        String name, phone, delName, delPhone;

        do {
            System.out.println("\n1. Add Contact");
            System.out.println("2. View Contact");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
        
            System.out.print("Enter Your Choice: ");
            choice = Integer.parseInt(in.readLine());

            switch (choice) {
                case 1:
                    System.out.println("Enter Your Name:");
                    name = in.readLine();
                    System.out.println("Enter the Mobile Number:");
                    phone = in.readLine();
                    contacts.add(name + " - " + phone);
                    System.out.println("Successfully added contact.");
                    break;

                case 2:
                    System.out.println("\n--- Contact List ---");
                    if (contacts.isEmpty()) {
                        System.out.println("No contacts found.");
                    } else {
                        for (int i = 0; i < contacts.size(); i++) {
                            System.out.println((i + 1) + ". " + contacts.get(i));
                        }
                    }
                    break;

                case 3:
                    System.out.println("Enter the contact number to update:");
                    int updateIndex = Integer.parseInt(in.readLine()) - 1;
                    if (updateIndex >= 0 && updateIndex < contacts.size()) {
                        System.out.println("Enter New Name:");
                        name = in.readLine();
                        System.out.println("Enter New Mobile Number:");
                        phone = in.readLine();
                        contacts.set(updateIndex, name + " - " + phone);
                        System.out.println("Contact updated successfully!");
                    } else {
                        System.out.println("Invalid contact number.");
                    }
                    break;

                case 4:
                    System.out.println("Enter Name to Delete:");
                    delName = in.readLine();
                    System.out.println("Enter Phone to Delete:");
                    delPhone = in.readLine();
                    String entryToDelete = delName + " - " + delPhone;
                    if (contacts.remove(entryToDelete)) {
                        System.out.println("Contact deleted successfully.");
                    } else {
                        System.out.println("Invalid contact.");
                    }
                    break;

               

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);
    }
}
