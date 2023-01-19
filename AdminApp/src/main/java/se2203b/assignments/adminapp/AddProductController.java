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

public class AddProductController implements Initializable{

    private ProductsAdapter productsAdapter;

    @FXML
    private TextField nameText, colorText, brandText, sizeText, categoryText, priceText, stockText;

    @FXML
    private ChoiceBox catalogBox;

    @FXML
    private Button addButton;

    @FXML
    private TableView<Product> tableView;

    @FXML
    private TableColumn<Product, String> nameCol;
    @FXML
    private TableColumn<Product, String> colorCol;
    @FXML
    private TableColumn<Product, String> brandCol;
    @FXML
    private TableColumn<Product, String> sizeCol;
    @FXML
    private TableColumn<Product, String> categoryCol;
    @FXML
    private TableColumn<Product, Double> priceCol;
    @FXML
    private TableColumn<Product, Integer> stockCol;
    @FXML
    private TableColumn<Product, String> catalogCol;

    // list to hold all the product data
    final ObservableList<Product> data = FXCollections.observableArrayList();

    // list to hold the catalog names for the catalogs choice box
    final ObservableList<String> catalogData = FXCollections.observableArrayList();

    public void setModel(ProductsAdapter product){
        productsAdapter = product;
        buildData();
        buildCatalogData();
    }
    // method to add a product to the products table
    public void addProduct() throws SQLException{
        productsAdapter.addProduct(Double.parseDouble(priceText.getText()), Integer.parseInt(stockText.getText()),
                (String)catalogBox.getValue(), colorText.getText(), brandText.getText(), sizeText.getText(),
                categoryText.getText(), nameText.getText());
        Stage stage = (Stage) addButton.getScene().getWindow();
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

    // method to build the products data
    @FXML
    public void buildData(){
        try{
            data.addAll(ProductsAdapter.getProductsList());
        }
        catch(SQLException ex){
            displayAlert("ERROR: " + ex.getMessage());
        }
    }
    // method to build the catalogs data
    @FXML
    public void buildCatalogData(){
        try{
            catalogData.addAll(CatalogsAdapter.getCatalogNames());
        }
        catch(SQLException ex){
            displayAlert("ERROR: " + ex.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        nameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        colorCol.setCellValueFactory(cellData -> cellData.getValue().colorProperty());
        brandCol.setCellValueFactory(cellData -> cellData.getValue().brandProperty());
        sizeCol.setCellValueFactory(cellData -> cellData.getValue().sizeProperty());
        categoryCol.setCellValueFactory(cellData -> cellData.getValue().categoryProperty());
        priceCol.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        stockCol.setCellValueFactory(cellData -> cellData.getValue().stockProperty().asObject());
        catalogCol.setCellValueFactory(cellData -> cellData.getValue().catalogProperty());

        tableView.setItems(data);

        catalogBox.setItems(catalogData);
    }



}
