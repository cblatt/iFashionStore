package se2203b.assignments.adminapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EditCatalogController  implements Initializable {

    private CatalogsAdapter catalogsAdapter;

    @FXML
    private ChoiceBox editBox, deleteBox;

    @FXML
    private TextField editTextField;

    @FXML
    private Button editButton, deleteButton;

    final ObservableList<String> data = FXCollections.observableArrayList();

    public void setModel(CatalogsAdapter catalog){
        catalogsAdapter = catalog;
        buildData();
    }
    // method to delete the selected catalog
    public void deleteCatalog() throws SQLException{
        catalogsAdapter.deleteCatalog((String)deleteBox.getValue());
        Stage stage = (Stage) deleteButton.getScene().getWindow();
        stage.close();
    }
    // method to rename the selected catalog
    public void editCatalog() throws SQLException{
        catalogsAdapter.editCatalog((String)editBox.getValue(), editTextField.getText());
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
    // method to build the catalog names data
    @FXML
    public void buildData() {
        try {
            data.addAll(CatalogsAdapter.getCatalogNames());
        }
        catch (SQLException ex) {
            displayAlert("ERROR: " + ex.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        editBox.setItems(data);
        deleteBox.setItems(data);
    }


}
