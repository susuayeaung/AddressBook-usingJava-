/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.addressbook;

import java.util.Scanner;

/**
 *
 * @author Su, Rohan, Kanwar
 */
public class ContactManager {
    private int numContact;
    private int maxContact;
    private Contact[] contactList;
    
    public ContactManager(int max){
        numContact = 0;
        maxContact = max;
        contactList = new Contact[maxContact];
    }
    public Boolean addContact(String fn, String ln, String hPh, String wPh, Address add, String email, MyDate bday, String notes){
    if(findContact(fn,ln) != null){
        System.out.println("Contact with the same name is already been added!");
        return false;
    }
    contactList[numContact] = new Contact(fn, ln, hPh, wPh, add, email, bday, notes);
    numContact++;
        System.out.println("Contact " + fn +" " + ln + " with home phone " + hPh + " is successfully been added!");
    return true;
    }
    public boolean editContact(String fname1, String lname1, String fname2, String lname2, String hph, String wph, Address add, String email, MyDate bday, String notes){
        Contact c = findContact(fname1,lname1);
        c.setFirstName(fname2);
        c.setLastName(lname2);
        c.setHomePhone(hph);
        c.setEmail(email);
        c.setWorkPhone(wph);
        c.setAddress(add);
        c.setDate(bday);
        c.setNote(notes);
        return true;
    }
    public void deleteContact(){
        Scanner keyboard = new Scanner(System.in);
        String firstNm, lastNm;
        int contactIndex = -1;
        System.out.println("Please Enter the Contact's first name you want to delete:");
        firstNm = keyboard.nextLine();
        System.out.println("Please Enter the Contact's last name you want to delete:");
        lastNm = keyboard.nextLine();
        for(int x = 0; x < numContact; x++){
            if(contactList[x].getFirstName() == firstNm && contactList[x].getLastName() == lastNm){
                contactIndex =  x;
            }
        }
        if(contactIndex >=0){
            contactList[contactIndex] = contactList[contactIndex-1];
            numContact--;
        }
    }
    
    public String viewContact(){
        String info = "List of all the contacts are: ";
        for(int x = 0; x < numContact; x++){
            info += contactList[x].toString() + "\n";
        }
        return info;
    }
    public Contact findContact(String fname, String lname){
        Contact c = null;
        for(int x = 0; x < numContact; x++){
            if(contactList[x].getFirstName() == fname && contactList[x].getLastName() == lname){
                c = contactList[x];
                break;
            }
        }
        return c;
    }
    public Contact findContactByCity(String city){
        Contact c = null;
        for(int x = 0; x < numContact; x++){
            if(contactList[x].getAddress().city == city){
               c = contactList[x];
            }
        }
        return c;
    }
    public String viewContactInCity(){
        String info = "";
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter the city you want to view the contacts live in: ");
        String city = keyboard.nextLine();
        info += " city " + "The contacts live in the " + city;
        for(int x = 0; x < numContact; x++){
            if(contactList[x].getCity() == city){
                info +=  contactList[x].toString();
            }
            else{
                info += "is not found.";
            }
        }
        return info;
    }
}
