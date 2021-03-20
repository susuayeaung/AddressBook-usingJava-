/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.addressbook;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Su, Rohan, Kanwar
 */
public class Main extends Application {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    private ContactManager cm = new ContactManager(10);
    
    public void init(){
        cm.addContact("Jenifer", "Stribell","4161111111","4162222222",new Address("123", "any Street", "Toronto", "X1X2X3", "Ontario", "Canada"), "jenifer.stribell@email.com", new MyDate(13,12,00), "friend");
        cm.addContact("Joel", "Morgan","6473333333","6474444444",new Address("456", "Royal Street", "Tornto", "Y4Y5Y6", "Ontario", "Canada"), "joel.morgan@email.com", new MyDate(03,05,95), "friend");
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Address Book");
        
        String fn, ln, hph, wph, mail, nt;
        MyDate day = new MyDate(3,10,20);
               
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        
        grid.setPadding(new Insets(25,25,25,25));
        
        Scene scene = new Scene(grid,600,500);
        primaryStage.setScene(scene);
        
        Text scenetitle = new Text("Welcome to the Address book!");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0);
        
        //add button
        Button addBtn = new Button("Add Contact");
        grid.add(addBtn, 0, 9);
        //edit button
        Button editBtn = new Button("Edit Contact");
        grid.add(editBtn, 0, 10);
        //delete button
        Button delBtn = new Button("Delete Contact");
        grid.add(delBtn, 0, 11);
        //save button
        Button saveBtn = new Button("Save Contact");
        grid.add(saveBtn, 0, 12);
        //main page button
        Button mainPgBtn = new Button();
        mainPgBtn.setText("Return");
        //exit button
        Button exitBtn = new Button("Exit");
        grid.add(exitBtn, 0, 13);
        
        Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        
        //label for first name
        Label firstName = new Label("First Name: ");
        grid.add(firstName, 0, 1);
        TextField fnField = new TextField();
        fnField.setPrefColumnCount(20);
        fnField.setPromptText("e.g John");
        grid.add(fnField, 1, 1);
        //label for last name
        Label lastName = new Label("Last Name: ");
        grid.add(lastName, 0, 2);
        TextField lnField = new TextField();
        lnField.setPrefColumnCount(20);
        lnField.setPromptText("e.g Doe");
        grid.add(lnField, 1, 2);
        //label for home phone
        Label homePh = new Label("Home Phone: ");
        grid.add(homePh, 0, 3);
        TextField hPhField = new TextField();
        hPhField.setPrefColumnCount(20);
        hPhField.setPromptText("e.g 6471111111");
        grid.add(hPhField, 1, 3);
        //label for work phone
        Label workPh = new Label("Work Phone: ");
        grid.add(workPh, 0, 4);
        TextField wPhField = new TextField();
        wPhField.setPrefColumnCount(20);
        wPhField.setPromptText("e.g 11111111");
        grid.add(wPhField, 1, 4);
        //label for home address
        Label homeAddress = new Label("Home Address: ");
        grid.add(homeAddress, 0, 5);
        TextField hAddressField = new TextField();
        hAddressField.setPrefColumnCount(20);
        hAddressField.setPromptText("e.g 123, Royal Street, Toronto, X1X2X3, Ontario, Canada");
        grid.add(hAddressField, 1, 5);
        //label for email
        Label email = new Label("Email: ");
        grid.add(email, 0, 6);
        TextField emailField = new TextField();
        emailField.setPrefColumnCount(20);
        emailField.setPromptText("e.g johndoe@email.com");
        grid.add(emailField, 1, 6);
        //label for birthday
        Label birthday = new Label("Birthday: ");
        grid.add(birthday, 0, 7);
        TextField bdayField = new TextField();
        bdayField.setPrefColumnCount(20);
        bdayField.setPromptText("e.g 01/01/2000");
        grid.add(bdayField, 1, 7);
        //label for note
        Label note = new Label("Note: ");
        grid.add(note, 0, 8);
        TextField noteField = new TextField();
        noteField.setPrefColumnCount(20);
        noteField.setPromptText("e.g John");
        grid.add(noteField, 1, 8);
            
        fn = fnField.getText();
        ln = lnField.getText();
        hph = hPhField.getText();
        wph = wPhField.getText();
        
        Address add = new Address(hAddressField.getText(), null, null, null, null, null);        
        mail = emailField.getText();
        nt = noteField.getText();
        
        fnField.clear();
        lnField.clear();
        hPhField.clear();
        wPhField.clear();
        hAddressField.clear();
        emailField.clear();
        bdayField.clear();
        noteField.clear(); 
            
        //when add button clicks
        addBtn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                // Validation that the text is entered into the field and it's valid.
                 cm.addContact(fn, ln, hph, wph, add, mail, day, nt);         
            } 
        });
        editBtn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                
                //label for first name you want to edit
                Label fName = new Label("First Name: ");
                grid.add(fName, 0, 1);
                TextField fnField2 = new TextField();
                fnField2.setPrefColumnCount(20);
                fnField2.setPromptText("e.g John");
                grid.add(fnField2, 1, 1);
                //label for last name you want to edit
                Label lName = new Label("Last Name: ");
                grid.add(lName, 0, 2);
                TextField lnField2 = new TextField();
                lnField2.setPrefColumnCount(20);
                lnField2.setPromptText("e.g Doe");
                grid.add(lnField2, 1, 2);
                
                Address address = new Address(hAddressField.getText(),null,null,null,null,null);
                String birthday = bdayField.getText(); 
                String [] x = birthday.split("/");
                MyDate bDay = new MyDate ( Integer.parseInt(x [0]), Integer.parseInt(x [1]),Integer.parseInt(x [2])  );
                    System.out.println(cm.toString());
                    cm.editContact(
                            fnField.getText(),
                        lnField.getText(),
                        fnField2.getText(),
                        lnField2.getText(),
                        hPhField.getText(),
                        wPhField.getText(),
                        address,
                        emailField.getText(),
                        bDay,
                        noteField.getText()
                    );
                    System.out.println(cm.toString());
            }
        });
        
        //when delete button clicks
        delBtn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                cm.deleteContact();
            }
        });
        //When save button clicks
        saveBtn.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent e){
                    Address address = new Address(hAddressField.getText(),null,null,null,null,null);
                String birthday = bdayField.getText(); 
                String [] x = birthday.split("/");
                MyDate bDay = new MyDate ( Integer.parseInt(x [0]), Integer.parseInt(x [1]),Integer.parseInt(x [2])  );
                    System.out.println(cm.toString());
                    cm.addContact(
                            fnField.getText(),
                        lnField.getText(),
                        hPhField.getText(),
                        wPhField.getText(),
                        address,
                        emailField.getText(),
                        bDay,
                        noteField.getText()
                    );
                    System.out.println(cm.toString());
                            
                }    
            });
        
        //when exit button clicks
        exitBtn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                // Validation that the text is entered into the field and it's valid.
                primaryStage.hide();         
            } 
        });
        primaryStage.show(); 
    }
}