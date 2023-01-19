package se2203b.assignments.adminapp;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Contact {

    // fields for class attributes
    private final StringProperty message;
    private final StringProperty dateOfContact;

    // constructor
    public Contact(String mess, String date){
        message = new SimpleStringProperty(mess);
        dateOfContact = new SimpleStringProperty(date);
    }

    // getter and setter for message
    public void setMessage(String mess){
        message.set(mess);
    }
    public StringProperty messageProperty(){
        return message;
    }
    public String getMessage(){
        return message.get();
    }

    // getter and setter for date of contact
    public void setDateOfContact(String date){
        dateOfContact.set(date);
    }
    public StringProperty dateOfContactProperty(){
        return dateOfContact;
    }
    public String getDateOfContact(){
        return dateOfContact.get();
    }
}
