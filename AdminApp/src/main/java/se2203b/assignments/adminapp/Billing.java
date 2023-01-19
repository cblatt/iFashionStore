package se2203b.assignments.adminapp;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Billing {

    // fields for the class attributes
    private final DoubleProperty cardNumber;
    private final StringProperty cardName;
    private StringProperty billingAddress;

    // constructor
    public Billing(double number, String name, String address){
        this.cardNumber = new SimpleDoubleProperty(number);
        this.cardName = new SimpleStringProperty(name);
        this.billingAddress = new SimpleStringProperty(address);
    }

    // getter and setter for card number
    public void setCardNumber(double number){
        cardNumber.set(number);
    }
    public DoubleProperty cardNumberProperty(){
        return cardNumber;
    }
    public double getCardNumber(){
        return cardNumber.get();
    }

    // getter and setter for card name
    public void setCardName(String name){
        cardName.set(name);
    }
    public StringProperty cardNameProperty(){
        return cardName;
    }
    public String getCardName(){
        return cardName.get();
    }

    // getter and setter for billing address
    public void setBillingAddress(String address){
        billingAddress.set(address);
    }
    public StringProperty billingAddressProperty(){
        return billingAddress;
    }
    public String getBillingAddress(){
        return billingAddress.get();
    }
}
