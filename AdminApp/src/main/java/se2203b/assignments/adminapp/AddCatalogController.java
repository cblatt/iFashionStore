package se2203b.assignments.adminapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddCatalogController implements Initializable {

    private CatalogsAdapter catalogsAdapter;

    @FXML
    private TextField addCatalogText;

    @FXML
    private Button saveButton, addButton;

    @FXML
    private TableView<Catalog> tableView;

    @FXML
    private TableColumn<Catalog, String> catalogNameCol;

    final ObservableList<Catalog> data = FXCollections.observableArrayList();

    public void setModel(CatalogsAdapter catalog){
        catalogsAdapter = catalog;
        buildData();
    }
    // method to add a catalog to the catalogs table
    public void addCatalog() throws SQLException {
        catalogsAdapter.addCatalog(addCatalogText.getText());
        Stage stage = (Stage) tableView.getScene().getWindow();
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

    // method to build the catalogs data
    @FXML
    public void buildData() {
        try {
            data.addAll(CatalogsAdapter.getCatalogsList());
        }
        catch (SQLException ex) {
            displayAlert("ERROR: " + ex.getMessage());
        }
    }

    // initialized the controller class
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        catalogNameCol.setCellValueFactory(cellData -> cellData.getValue().catalogNameProperty());
        tableView.setItems(data);

    }

}
