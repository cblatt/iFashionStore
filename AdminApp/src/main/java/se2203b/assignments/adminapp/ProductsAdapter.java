package se2203b.assignments.adminapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.Objects;

public class ProductsAdapter {

    static Connection connection;

    // creating the products table, which will have 8 columns
    public ProductsAdapter(Connection conn, Boolean reset) throws SQLException{
        connection = conn;
        Statement stmt = connection.createStatement();
        if(reset){
            try{
                stmt.execute("DROP TABLE Products");
            }
            catch(SQLException ex){}
            finally{
                stmt.execute("CREATE TABLE Products(" +
                        "Price DOUBLE, " +
                        "Stock INT, " +
                        "Catalog STRING, " +
                        "Color STRING, " +
                        "Brand STRING, " +
                        "Size STRING, " +
                        "Category STRING, " +
                        "Name STRING)");
            }
        }
    }
    // method to add a product to the products table
    public void addProduct(double price, int stock, String catalog, String color, String brand, String size,
                           String category, String name) throws SQLException{
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO Products (Price, Stock, Catalog, Color, Brand, Size, Category, Name) " +
                "VALUES (" + price + ", " + stock + ", '" + catalog + "', '" + color + "', '" + brand + "', '" + size + "', '" + category + "', '" + name + "')");
    }

    // method to delete a product from the products table
    public void deleteProduct(String productToDelete) throws SQLException{
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("DELETE FROM Products WHERE Name = '" + productToDelete + "'");
    }
    // method to edit a product
    public void editProduct(String productToEdit, String attributeToEdit, Object newAttributeValue) throws SQLException{
        Statement stmt = connection.createStatement();
        // changing the specified attribute to the given attribute value
        if(Objects.equals(attributeToEdit, "NAME")){
            String nameValue = newAttributeValue.toString();
            stmt.executeUpdate("UPDATE Products SET Name = '" + nameValue + "' WHERE Name = '" + productToEdit + "'");
        }
        if(Objects.equals(attributeToEdit, "COLOR")){
            String colorValue = newAttributeValue.toString();
            stmt.executeUpdate("UPDATE Products SET Color = '" + colorValue + "' WHERE Name = '" + productToEdit + "'");
        }
        if(Objects.equals(attributeToEdit, "BRAND")){
            String brandValue = newAttributeValue.toString();
            stmt.executeUpdate("UPDATE Products SET Brand = '" + brandValue + "' WHERE Name = '" + productToEdit + "'");
        }
        if(Objects.equals(attributeToEdit, "SIZE")){
            String sizeValue = newAttributeValue.toString();
            stmt.executeUpdate("UPDATE Products SET Size = '" + sizeValue + "' WHERE Name = '" + productToEdit + "'");
        }
        if(Objects.equals(attributeToEdit, "CATEGORY")){
            String categoryValue = newAttributeValue.toString();
            stmt.executeUpdate("UPDATE Products SET Category = '" + categoryValue + "' WHERE Name = '" + productToEdit + "'");
        }
        if(Objects.equals(attributeToEdit, "PRICE")){
            double priceValue = Double.parseDouble(newAttributeValue.toString());
            stmt.executeUpdate("UPDATE Products SET Price = '" + priceValue + "' WHERE Name = '" + productToEdit + "'");
        }
        if(Objects.equals(attributeToEdit, "STOCK")){
            int stockValue = Integer.parseInt(newAttributeValue.toString());
            stmt.executeUpdate("UPDATE Products SET Stock = '" + stockValue + "' WHERE Name = '" + productToEdit + "'");
        }
        if(Objects.equals(attributeToEdit, "CATALOG")){
            String catalogValue = newAttributeValue.toString();
            stmt.executeUpdate("UPDATE Products SET Catalog = '" + catalogValue + "' WHERE Name = '" + productToEdit + "'");
        }
    }

    // method to get all products data
    public static ObservableList<Product> getProductsList() throws SQLException{
        ObservableList<Product> list = FXCollections.observableArrayList();
        ResultSet rs;

        // create a statement object
        Statement stmt = connection.createStatement();

        // create a String with a SELECT statement
        String sqlStatement = "SELECT * FROM Products";

        // execute the statement and return the results
        rs = stmt.executeQuery(sqlStatement);

        while(rs.next()){
            list.add(new Product(rs.getString("Name"), rs.getString("Color"), rs.getString("Brand"),
                    rs.getString("Size"), rs.getString("Category"), rs.getDouble("Price"),
                    rs.getInt("Stock"), rs.getString("Catalog")));
        }
        return list;
    }
    // method to get the product names
    public static ObservableList<String> getProductNames() throws SQLException{
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet rs;

        // create statement object
        Statement stmt = connection.createStatement();

        // create a string with SELECT statement
        String sqlStatement = "SELECT Name FROM Products";

        // execute the statement and return the result
        rs = stmt.executeQuery(sqlStatement);

        while(rs.next()){
            list.add(new String(rs.getString("Name")));
        }
        return list;
    }
    // method to get the catalogs associated with the products
    public static ObservableList<String> getProductCatalogs() throws SQLException{
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet rs;

        // create a statement object
        Statement stmt = connection.createStatement();

        // create a string with SELECT statement
        String sqlStatement = "SELECT Catalog FROM Products";

        // execute the statement and return the result
        rs = stmt.executeQuery(sqlStatement);

        while(rs.next()){
            list.add(new String(rs.getString("Catalog")));
        }
        return list;
    }

    // method to get the product attributes
    public static ObservableList<String> getProductAttributes() throws SQLException{
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet rs;

        // create statement object
        Statement stmt = connection.createStatement();

        // create a string with SELECT statement
        String sqlStatement = "SELECT * FROM Products";

        // execute statement and return the results
        rs = stmt.executeQuery(sqlStatement);

        // get meta data
        ResultSetMetaData rsMetaData = rs.getMetaData();

        // get column count
        int columnCount = rsMetaData.getColumnCount();

        // add all the column names to the list
        for(int i=1; i<columnCount+1; i++){
            list.add(rsMetaData.getColumnName(i));
        }
        return list;
    }
}
