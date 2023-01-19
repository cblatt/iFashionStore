package se2203b.assignments.adminapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EditProductController implements Initializable{

    private ProductsAdapter productsAdapter;

    @FXML
    private ChoiceBox editBox, deleteBox, attributeBox;

    @FXML
    private TextField attributeText;

    @FXML
    private Button editButton, deleteButton;

    // list to hold the product names
    final ObservableList<String> productNamesData = FXCollections.observableArrayList();

    // list to hold the product attribute names
    final ObservableList<String> productAttributesData = FXCollections.observableArrayList();

    public void setModel(ProductsAdapter product){
        productsAdapter = product;
        buildProductNamesData();
        buildProductAttributesData();
    }
    // method to delete a product
    public void deleteProduct() throws SQLException{
        productsAdapter.deleteProduct((String)deleteBox.getValue());
        Stage stage = (Stage) deleteButton.getScene().getWindow();
        stage.close();
    }
    // method to edit a product
    public void editProduct() throws SQLException{
        productsAdapter.editProduct((String)editBox.getValue(), (String)attributeBox.getValue(), attributeText.getText());
        Stage stage = (Stage) editButton.getScene().getWindow();
        stage.close();
    }



    private void displayAlert(String msg) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Alert.fxml"));
            Parent ERROR = loader.load();
            AlertController controller = (AlertController) loader.getController();

            Scene scene = new Scene(ERROR);
            Stage stage = new Stage();
            stage.setScene(scene);

            controller.setAlertText(msg);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

        } catch (IOException ex1) {

        }
    }
    // method to build the product names data
    @FXML
    public void buildProductNamesData(){
        try{
            productNamesData.addAll(ProductsAdapter.getProductNames());
        }
        catch(SQLException ex){
            displayAlert("ERROR: " + ex.getMessage());
        }
    }
    // method to build the product attributes data
    @FXML
    public void buildProductAttributesData(){
        try{
            productAttributesData.addAll(ProductsAdapter.getProductAttributes());
        }
        catch(SQLException ex){
            displayAlert("ERROR: " + ex.getMessage());
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb){
        editBox.setItems(productNamesData);
        attributeBox.setItems(productAttributesData);
        deleteBox.setItems(productNamesData);
    }




}
