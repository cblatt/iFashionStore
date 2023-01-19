package se2203b.assignments.adminapp;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Shipping {

    // fields for class attributes
    private final StringProperty shippingAddress;
    private final StringProperty shippingName;

    // constructor
    public Shipping(String address, String name){
        this.shippingAddress = new SimpleStringProperty(address);
        this.shippingName = new SimpleStringProperty(name);
    }

    // getter and setter for shipping address
    public void setShippingAddress(String address){
        shippingAddress.set(address);
    }
    public StringProperty shippingAddressProperty(){
        return shippingAddress;
    }
    public String getShippingAddress(){
        return shippingAddress.get();
    }

    // getter and setter for shipping name
    public void setShippingName(String name){
        shippingName.set(name);
    }
    public StringProperty shippingNameProperty(){
        return shippingName;
    }
    public String getShippingName(){
        return shippingName.get();
    }

}
