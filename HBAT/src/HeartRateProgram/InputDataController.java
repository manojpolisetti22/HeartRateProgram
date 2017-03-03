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
public class InputDataController implements Initializable {

    @FXML private TextField tb_rr;
    @FXML private TextField tb_behav;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
    }    
    
    @FXML
    public void getFileName_rr(ActionEvent event) {
        System.out.println("Getting Filename");
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File rr = fileChooser.showOpenDialog(null);
        
        tb_rr.setText(rr.getPath());
    }
    
    public void getFileName_behav(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Behavioral File");
        File behav = fileChooser.showOpenDialog(null);
        
        tb_behav.setText(behav.getPath());
    }
    
    @FXML
    public void advanced(ActionEvent event) {
    
    }
    
    @FXML 
    public void done(ActionEvent event) {
        // Get strings from textboxes
        String file1 = tb_rr.getText();
        String file2 = tb_rr.getText();
        
        // Error check the filenames
        File f1 = new File(file1);
        File f2 = new File(file2);
        if (f1.exists() && f2.exists()) {
            
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
