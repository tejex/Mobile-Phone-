import java.util.ArrayList;

public class MobilePhone {

    private ArrayList<Contacts> mobilePhone = new ArrayList<Contacts>();


    public void printContacts(){
        for(int i=0;i<mobilePhone.size();i++){
            System.out.println(i+1 + ")- Contact Name: " + mobilePhone.get(i).getName());
            System.out.println("Contact Number: " +mobilePhone.get(i).getPhoneNumber());
            System.out.println(" ");
        }
    }

    //Creating a new contact in the phone and storing it.
    public void  createContact(String name, String phoneNum){
        newContact(name, phoneNum);
    }
    private void newContact(String name, String phoneNum){
        if(mobilePhone.contains(name)){
            System.out.println("Contact Name already exists. Try again.");
            return;
        }
        Contacts newContact = new Contacts(name,phoneNum);
        this.mobilePhone.add(newContact);
    }
    //modify / update an existing contact
    public void modifyContactName(String currentName, String newName){
        if(mobilePhone.contains(newName)){
            System.out.println("Contact Name already exists, update failed");
            return;
        }
        Contacts contact = findContact(currentName);
        int position = mobilePhone.indexOf(contact);

        if(position >= 0){
            Contacts currContact = mobilePhone.get(position);
            changeContactName(currContact, newName);
        }
        else{
            System.out.println("Contact not in phone");

        }
    }
    private Contacts findContact(String name){
        for(int i=0;i<mobilePhone.size();i++){
            if(mobilePhone.get(i).getName().equals(name)){
                return mobilePhone.get(i);
            }
        }
        return null;
    }
    private void changeContactName(Contacts contact,String newName){
        contact.setName(newName);
    }
    public void modifyContactNumber(String ContactName, String newPhone){
        Contacts contact = findContact(ContactName);
        changeContactNumber(contact,newPhone);
    }

    private void changeContactNumber(Contacts contact,String newNumber){
        contact.setPhoneNumber(newNumber);
    }
    //Searching for and finding contact

    public boolean searchContact(String name){
        Contacts contact  = findContact(name);

        int position = mobilePhone.indexOf(contact);
        if(position>=0){
           return true;
        }
        return false;
    }

    public void getContact(String name){
        boolean searchContact = searchContact(name);

        if(searchContact){
           Contacts contact = findContact(name);
            System.out.println("Contact Found: ");
            System.out.println("Name: " + contact.getName());
            System.out.println("Phone: " + contact.getPhoneNumber());
        }
        else{
            System.out.println("Contact not found");
        }
    }


    //Deleting contact
    public void deleteContact(String name){
        Contacts contact  = findContact(name);
        int position = mobilePhone.indexOf(contact);
        if(position>=0){
            deleteContact(contact);
        }
    }
    private void deleteContact(Contacts contact){
        mobilePhone.remove(contact);
    }
    //








}
