package se2203b.assignments.adminapp;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Administrator {

    // fields for class attributes
    private final StringProperty adminEmail;

    // constructor
    public Administrator(String email){
        this.adminEmail = new SimpleStringProperty(email);
    }

    // getter and setter for admin email
    public void setAdminEmail(String email){
        adminEmail.set(email);
    }
    public StringProperty adminEmailProperty(){
        return adminEmail;
    }
    public String getAdminEmail(){
        return adminEmail.get();
    }
}
