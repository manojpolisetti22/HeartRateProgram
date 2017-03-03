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

/**
 * FXML Controller class
 *
 * @author Rajith
 */
public class AdvancedTabInputDataController implements Initializable {

    @FXML private TextField tb_excel;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
    }    
    
    @FXML
    public void getFileName_excel(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Excel File");
        File excel = fileChooser.showOpenDialog(null);
        
        tb_excel.setText(excel.getPath());
    }
    
    @FXML 
    public void done(ActionEvent event) {
        // Get string from textbox
        String file = tb_excel.getText();
        
        // Error check the filenames
        File f1 = new File(file);
        if (f1.exists()) {
            //Send to next step
        }

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DataView.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            DataViewController controller = fxmlLoader.<DataViewController>getController();
            controller.initFiles();
            stage.show();
        } catch(Exception e) {
           e.printStackTrace();
        }
    }
    
}