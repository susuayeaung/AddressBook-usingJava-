/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.addressbook;

import java.text.DateFormatSymbols;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Su, Rohan, Kanwar
 */
public class MyDate {
    private int day;
    private int month;
    private int year;
    
    public MyDate(int d, int m, int y){
        day = d;
        month = m;
        year = y;
    }
    public int getDay(){
        return day;
    }
    public void setDay(int d){
        day = d;
    }
    public String getMonthShortForm(){
        return new DateFormatSymbols().getShortMonths()[month-1];
    }
    public String getMonthLongForm(){
        return new DateFormatSymbols().getMonths()[month-1];
    }
    public void setMonth(int m){
        month = m;
    }
    public void setYear(int y){
        year = y;
    }
    public int getYear(){
        return year;
    }
    @Override
    public String toString(){
        String info = "Day: " + day + "\tMonth: " + month + "\tYear: " + year;
        return info;
    }

    void setCellValueFactory(PropertyValueFactory<Object, Object> propertyValueFactory) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
