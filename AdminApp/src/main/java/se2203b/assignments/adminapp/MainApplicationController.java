package se2203b.assignments.adminapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainApplicationController implements Initializable {

    private Connection conn;

    private CatalogsAdapter catalogs;

    private ProductsAdapter products;

    @FXML
    private MenuBar mainMenu;

    @FXML
    private MenuItem addCatalog;


    public void showAbout() throws Exception {
        // load the fxml file (the UI elements)
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplicationController.class.getResource("About-view.fxml"));
        // create the root node
        Parent About =  fxmlLoader.load();
        // create new stage
        Stage stage = new Stage();
        // add the about's UI elements to the stage
        stage.setScene(new Scene(About));
        // add icon to the About window
        stage.getIcons().add(new Image("file:src/main/resources/se2203b/assignments/adminapp/WesternLogo.png"));
        stage.setTitle("About Us");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
    // method to show the add catalog stage
    @FXML
    public void showAddCatalog() throws Exception {
        // create catalogs and products model
        catalogs = new CatalogsAdapter(conn, false);
        products = new ProductsAdapter(conn, false);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddCatalog.fxml"));
        Parent addCatalog = (Parent) fxmlLoader.load();

        AddCatalogController addCatalogController = (AddCatalogController) fxmlLoader.getController();
        addCatalogController.setModel(catalogs);

        Scene scene = new Scene(addCatalog);
        Stage stage = new Stage();

        stage.setScene(scene);

        stage.setTitle("Add Catalog");
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.show();
    }
    // method to show the edit/delete catalog stage
    @FXML
    public void showEditCatalog() throws Exception {
        // create catalogs and products model
        catalogs = new CatalogsAdapter(conn, false);
        products = new ProductsAdapter(conn, false);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditCatalog.fxml"));
        Parent editCatalog = (Parent) fxmlLoader.load();

        EditCatalogController editCatalogController = (EditCatalogController) fxmlLoader.getController();
        editCatalogController.setModel(catalogs);

        Scene scene = new Scene(editCatalog);
        Stage stage = new Stage();

        stage.setScene(scene);

        stage.setTitle("Edit/Delete Catalog");
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.show();
    }

    // method to show the add product stage
    @FXML
    public void showAddProducts() throws Exception {


        // create catalogs and products model
        products = new ProductsAdapter(conn, false);
        catalogs = new CatalogsAdapter(conn, false);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddProduct.fxml"));
        Parent addProducts = (Parent) fxmlLoader.load();

        AddProductController addProductController = (AddProductController) fxmlLoader.getController();
        addProductController.setModel(products);

        Scene scene = new Scene(addProducts);
        Stage stage = new Stage();

        stage.setScene(scene);

        stage.setTitle("Add Product");
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.show();
    }

    // method to show the edit/delete product stage
    @FXML
    public void showEditProducts() throws Exception {
        // create catalogs and products model
        products = new ProductsAdapter(conn, false);
        catalogs = new CatalogsAdapter(conn, false);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditProduct.fxml"));
        Parent standings = (Parent) fxmlLoader.load();

        EditProductController editProductController = (EditProductController) fxmlLoader.getController();
        editProductController.setModel(products);

        Scene scene = new Scene(standings);
        Stage stage = new Stage();

        stage.setScene(scene);

        stage.setTitle("Edit/Delete Product");
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.show();
    }



    public void exit() {
        // Get current stage reference
        Stage stage = (Stage) mainMenu.getScene().getWindow();
        // Close stage
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

            stage.getIcons().add(new Image("file:src/main/resources/se2203b/assignments/adminapp/WesternLogo.png"));
            controller.setAlertText(msg);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

        } catch (IOException ex1) {

        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // Create a named constant for the URL
            // NOTE: This value is specific for Java DB
            String DB_URL = "jdbc:derby:DB;create=true";
            // Create a connection to the database
            conn = DriverManager.getConnection(DB_URL);

        }
        catch (SQLException ex) {
            displayAlert(ex.getMessage());
        }
    }

}
