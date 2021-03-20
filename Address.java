/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.addressbook;

import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Su, Rohan, Kanwar
 */
public class Address {
    public String streetInfo1;
    public String streetInfo2;
    public String city;
    public String postalCode;
    public String province;
    public String country;
    
    public Address(String st1, String st2, String city, String postCode, String prov, String country){
        streetInfo1 = st1;
        streetInfo2 = st2;
        this.city = city;
        this.postalCode = postCode;
        province = prov;
        this.country = country;
    }
    @Override
    public String toString(){
        String info = "Street Info 1: " + streetInfo1 + "\tStreet Info 2: " + streetInfo2 +
                      "\nCity: " + city + "\tPostal Code: " + postalCode +
                      "\nProvince: " + province + "\tCountry: " + country;
        return info;
    }

    void setCellValueFactory(PropertyValueFactory<Object, Object> propertyValueFactory) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
