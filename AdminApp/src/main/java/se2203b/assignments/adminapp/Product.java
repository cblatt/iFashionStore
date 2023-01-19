package se2203b.assignments.adminapp;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Product {

    // fields for the class attributes
    private final StringProperty name;
    private final StringProperty color;
    private final StringProperty brand;
    private final DoubleProperty price;
    private final StringProperty size;
    private final StringProperty category;
    private final IntegerProperty stock;
    private final StringProperty catalog;

    // constructor
    public Product(String na, String co, String br, String si, String ca, double pr, int st, String catalog){
        this.name = new SimpleStringProperty(na);
        this.color = new SimpleStringProperty(co);
        this.brand = new SimpleStringProperty(br);
        this.price = new SimpleDoubleProperty(pr);
        this.size = new SimpleStringProperty(si);
        this.category = new SimpleStringProperty(ca);
        this.stock = new SimpleIntegerProperty(st);
        this.catalog = new SimpleStringProperty(catalog);
    }

    // getter and setter for name
    public void setName(String na){
        name.set(na);
    }
    public StringProperty nameProperty(){
        return name;
    }
    public String getName(){
        return name.get();
    }

    // getter and setter for color
    public void setColor(String co){
        color.set(co);
    }
    public StringProperty colorProperty(){
        return color;
    }
    public String getColor(){
        return color.get();
    }

    // getter and setter for brand
    public void setBrand(String br){
        brand.set(br);
    }
    public StringProperty brandProperty(){
        return brand;
    }
    public String getBrand(){
        return brand.get();
    }

    // getter and setter for price
    public void setPrice(double pr){
        price.set(pr);
    }
    public DoubleProperty priceProperty(){
        return price;
    }
    public double getPrice(){
        return price.get();
    }

    // getter and setter for size
    public void setSize(String si){
        size.set(si);
    }
    public StringProperty sizeProperty(){
        return size;
    }
    public String getSize(){
        return size.get();
    }

    // getter and setter for category
    public void setCategory(String ca){
        category.set(ca);
    }
    public StringProperty categoryProperty(){
        return category;
    }
    public String getCategory(){
        return category.get();
    }

    // getter and setter for stock
    public void setStock(int st){
        stock.set(st);
    }
    public IntegerProperty stockProperty(){
        return stock;
    }
    public int getStock(){
        return stock.get();
    }

    // getter and setter for catalog
    public void setCatalog(String cat){
        catalog.set(cat);
    }
    public StringProperty catalogProperty(){
        return catalog;
    }
    public String getCatalog(){
        return catalog.get();
    }






}
