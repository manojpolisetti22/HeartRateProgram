/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HeartRateProgram;

import HeartRateProgram.Libraries.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;
import javafx.scene.control.TextField;
import java.io.File;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * FXML Controller class
 *
 * @author Rajith
 */
public class AdvancedTabInputDataController implements Initializable {

    @FXML
    private TextField tb_dataGrid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Foe debugging
        tb_dataGrid.setText("C:\\Users\\Rajith\\Documents\\Programming\\HBAT\\"
                + "HeartRateProgram\\docs\\dataSamples\\Sample_DataGrid_Rajith.csv");
    }

    @FXML
    public void getFileName_excel(ActionEvent event) {
        try {

            FileChooser fileChooser = new FileChooser();

            fileChooser.setTitle("Open Excel File");
            File excel = fileChooser.showOpenDialog(null);

            tb_dataGrid.setText(excel.getPath());
        } catch (Exception e) {

        }
    }

    @FXML
    public void done(ActionEvent event) {
        // Get string from textbox
        String file = tb_dataGrid.getText();

        // Error check the filenames
        File f1 = new File(file);
        if (!f1.exists()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Something went wrong!");
            alert.setHeaderText(null);
            alert.setContentText("File does not exist");
            alert.showAndWait();
            return;
        }

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/DataView.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            DataViewController controller = fxmlLoader.<DataViewController>getController();
            System.out.println("Window opened"); // For debugging
            try {
                controller.initFilesAdvanced(file);
            } catch (Exception e) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Something went wrong!");
                alert.setHeaderText(null);
                alert.setContentText("There was a problem parsing/analyzing the file.");
                alert.showAndWait();
                return;
            }
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
