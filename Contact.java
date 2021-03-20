/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.addressbook;

/**
 *
 * @author Su Rohan, Kanwar
 */
public class Contact {
    private String firstName;
    private String lastName;
    private String homePhone;
    private String workPhone;
    private Address homeAddress;
    private String email;
    private MyDate birthday;
    private String notes;
    
    public Contact(String fname, String lname, String hph, String wph, Address add, String email, MyDate bday, String notes){
        firstName = fname;
        lastName = lname;
        homePhone = hph;
        workPhone = wph;
        homeAddress = add;
        this.email = email;
        birthday = bday;
        this.notes = notes;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String fn){
        firstName = fn;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String ln){
        lastName = ln;
    }
    public String getHomePhone(){
        return homePhone;
    }
    public void setHomePhone(String hph){
        homePhone = hph;
    }
    public String getWorkPhone(){
        return workPhone;
    }
    public void setWorkPhone(String wph){
        workPhone = wph;
    }
    public Address getAddress(){
        return homeAddress;
    }
    public void setAddress(Address address){
        homeAddress = address;
    }
    public String getCity(){
        return homeAddress.city;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public MyDate getDate(){
        return birthday;
    }
    public void setDate(MyDate bday){
        birthday = bday;
    }
    public String getNote(){
        return notes;
    }
    public void setNote(String nt){
        notes = nt;
    }
    @Override
    public String toString(){
        String info = "First Name: " + firstName + "\tLast Name: " + lastName +
                      "\nHome Phone: " + homePhone + "\tWork Phone: " + workPhone +
                      "\nHome Address: " + homeAddress + "\tEmail: " + email +
                      "\nBirthday: " + birthday + "\tNotes: " + notes;
        return info;
    }
}
