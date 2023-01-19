package se2203b.assignments.adminapp;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class RegisteredUser {

    // fields for the class attributes
    private final StringProperty username;
    private final StringProperty password;
    private final StringProperty userEmail;

    // constructor
    public RegisteredUser(String name, String pass, String email){
        this.username = new SimpleStringProperty(name);
        this.password = new SimpleStringProperty(pass);
        this.userEmail = new SimpleStringProperty(email);
    }
    // getter and setter for username
    public void setUsername(String name){
        username.set(name);
    }
    public StringProperty usernameProperty(){
        return username;
    }
    public String getUsername(){
        return username.get();
    }

    // getter and setter for password
    public void setPassword(String pass){
        password.set(pass);
    }
    public StringProperty passwordProperty(){
        return password;
    }
    public String getPassword(){
        return password.get();
    }

    // getter and setter for user email
    public void setUserEmail(String email){
        userEmail.set(email);
    }
    public StringProperty emailProperty(){
        return userEmail;
    }
    public String getUserEmail(){
        return userEmail.get();
    }



}
