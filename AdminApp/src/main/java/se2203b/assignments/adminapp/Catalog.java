package se2203b.assignments.adminapp;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Catalog {

    // fields for the class attributes
    private final StringProperty catalogName;

    // constructor
    public Catalog(String name){
        this.catalogName = new SimpleStringProperty(name);
    }

    // getter and setter for catalog name
    public void setCatalogName(String name){
        catalogName.set(name);
    }
    public StringProperty catalogNameProperty(){
        return catalogName;
    }
    public String getCatalogName(){
        return catalogName.get();
    }
}
