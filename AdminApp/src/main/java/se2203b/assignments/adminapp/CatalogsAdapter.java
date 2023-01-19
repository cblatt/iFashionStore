package se2203b.assignments.adminapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.Objects;

public class CatalogsAdapter {

    static Connection connection;

    // creating the catalogs table, which will only have 1 column that represents the catalog name
    public CatalogsAdapter(Connection conn, Boolean reset) throws SQLException{
        connection = conn;
        if(reset){
            Statement stmt = connection.createStatement();
            try{
                stmt.execute("DROP TABLE Products");
                stmt.execute("DROP TABLE Catalogs");
            }
            catch(SQLException ex){}
            finally{
                stmt.execute("CREATE TABLE Catalogs (CatalogName STRING)");
            }
        }
    }

    // method that adds a catalog to the catalogs table
    public void addCatalog(String catalogToAdd) throws SQLException{
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO Catalogs (CatalogName) VALUES('" + catalogToAdd + "')");
    }
    // method that removes a catalog from the catalogs table
    public void deleteCatalog(String catalogToDelete) throws SQLException{
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("DELETE FROM Catalogs WHERE CatalogName = '" + catalogToDelete + "'");
        for(int i=0; i<ProductsAdapter.getProductsList().size(); i++){
            if(Objects.equals(ProductsAdapter.getProductCatalogs().get(i), catalogToDelete)){
                System.out.println("Cannot delete this catalog, since it is associated with a product");
                break;
            }

        }
    }
    // method to edit the name of a catalog
    public void editCatalog(String catalogToEdit, String newCatalogName) throws SQLException{
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("UPDATE Catalogs SET CatalogName = '" + newCatalogName + "' " +
                "WHERE CatalogName = '" + catalogToEdit + "'" );
    }

    // Get all catalogs Data
    public static ObservableList<Catalog> getCatalogsList() throws SQLException {
        ObservableList<Catalog> list = FXCollections.observableArrayList();
        ResultSet rs;

        // Create a Statement object
        Statement stmt = connection.createStatement();

        // Create a string with a SELECT statement
        String sqlStatement = "SELECT CatalogName FROM Catalogs";

        // Execute the statement and return the result
        rs = stmt.executeQuery(sqlStatement);

        while (rs.next()) {
            list.add(new Catalog(rs.getString("CatalogName")));
        }
        return list;
    }
    // method to get the catalog names
    public static ObservableList<String> getCatalogNames() throws SQLException{
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet rs;

        // create statement object
        Statement stmt = connection.createStatement();

        // create a string with SELECT statement
        String sqlStatement = "SELECT CatalogName FROM Catalogs";

        // execute the statement and return the result
        rs = stmt.executeQuery(sqlStatement);

        while(rs.next()){
            list.add(new String(rs.getString("CatalogName")));
        }
        return list;
    }






}
