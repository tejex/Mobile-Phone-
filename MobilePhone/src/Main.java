import java.util.Scanner;

public class Main {


    private static  Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone =  new MobilePhone();

    public static void main(String[] args) {
        boolean quit  = false;
        int choice = 0;
        printInstructions();
        while(!quit) {
            System.out.println("Enter Your Choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    createContact();
                    break;

                case 3:
                    modifyContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    searchContact();
                    break;
                case 6:
                    quit = true;
                    break;

            }
        }
    }
    public  static void  printInstructions(){
        System.out.println("\n Press ");
        System.out.println("\t 0- Print the choice of options");
        System.out.println("\t 1- Print contact list");
        System.out.println("\t 2- Add item to contacts");
        System.out.println("\t 3- Modify Item in List");
        System.out.println("\t 4- Remove an item from the list");
        System.out.println("\t 5- Search for an item in the list");
        System.out.println("\t 6- Quit application");
    }
    public static void createContact(){
        System.out.println("Enter Name of Contact");
        String name = scanner.nextLine();
        System.out.println("Enter Number of Contact");
        String phone = scanner.nextLine();
        mobilePhone.createContact(name,phone);
    }
    public static void modifyContact(){
        System.out.print("Enter name of contact to change: ");
        String currentName = scanner.nextLine();
        String newName;

        boolean found = mobilePhone.searchContact(currentName);

        if(found){
            System.out.print("Enter new Name for contact: ");
            newName = scanner.nextLine();
            mobilePhone.modifyContactName(currentName, newName);
            System.out.print("Update phone number as well? Enter Y or N: ");
            String changePhone = scanner.nextLine();
            System.out.println("Contact Successfully Updated.");
            if(changePhone.equals("Y")){
                System.out.print("Enter New Phone number: ");
                String newPhone = scanner.nextLine();
                mobilePhone.modifyContactNumber(newName,newPhone);
            }
            else{
                System.out.println("Contact Successfully Updated.");
            }
        }
        else{
            System.out.println("Contact Not Found.");
        }
    }
    public static void deleteContact(){
        System.out.println("Enter name of contact you wish to delete: ");
        String gonner = scanner.nextLine();

        boolean found = mobilePhone.searchContact(gonner);
        if(found){
            mobilePhone.deleteContact(gonner);
            System.out.println("Contact successfully deleted.");
        }
        else{
            System.out.println("Contact Not Found.");
        }
    }
    public static void searchContact(){
        System.out.println("Enter name of contact you wish to find: ");
        String searchFor = scanner.nextLine();
        mobilePhone.getContact(searchFor);
    }



}