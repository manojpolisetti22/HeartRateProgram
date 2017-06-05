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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rajith
 */
public class InputDataController implements Initializable {

    @FXML private TextField tb_part;
    @FXML private TextField tb_rr;
    @FXML private TextField tb_behav;
    @FXML private TextField tb_delay1;
    @FXML private TextField tb_delay2;
    @FXML private TextField tb_delay3;
    
    Stage thisStage;
    
    boolean tooltips;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tooltips = false;
        
        // For debugging
        tb_part.setText("Person");
        tb_delay1.setText("10");
        tb_delay2.setText("10");
        tb_delay3.setText("10");
    }    
    
    @FXML
    public void getFileName_rr(ActionEvent event) {
        System.out.println("Getting Filename");
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File rr = fileChooser.showOpenDialog(null);
        
        if (rr != null) {
            tb_rr.setText(rr.getPath());
        }
    }
    
    public void getFileName_behav(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Behavioral File");
        File behav = fileChooser.showOpenDialog(null);
        
        if (behav != null) {
            tb_behav.setText(behav.getPath());
        }
    }
    
    @FXML 
    public void done(ActionEvent event) {
        // Get values from textboxes
        String participant_id = tb_part.getText();
        String file1 = tb_rr.getText();
        String file2 = tb_behav.getText();
        Double rr_start = Double.valueOf(tb_delay1.getText());
        Double rr_sync = Double.valueOf(tb_delay2.getText());
        Double behav_sync = Double.valueOf(tb_delay3.getText());
        
        // Check that data is valid
        if ("".equals(participant_id)) {
            inputErrorAlert("Participant ID may not be left blank");
        } 
        File file = new File(file1);
        if (!file.exists()) {
            inputErrorAlert("RR Data file does not exist");
        }
        file = new File(file2);
        if(!file.exists()) {
            inputErrorAlert("Behavioral Data file does not exist");
        }
        if (rr_start < 0.0) {
            inputErrorAlert("RR_START time should be greater than 0.0");
        }
        if (behav_sync < 0.0) {
            inputErrorAlert("BEHAVIORAL_START time should be greater than 0.0");
        }

        // Open DataView Window
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/DataView.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            DataViewController controller = fxmlLoader.<DataViewController>getController();
            controller.initFiles(participant_id,file1,file2,rr_start,rr_sync,behav_sync);
            stage.show();
            
        } catch(Exception e) {
           e.printStackTrace();
        }
        Stage here = (Stage) tb_part.getScene().getWindow();
        here.hide();
    }
    
    public void toggleTooltips() {
        System.out.println("TOOLTIPS");
        this.tooltips = !this.tooltips;
        if (this.tooltips) {
            tb_part.setTooltip(new Tooltip("Unique ID for participant"));
            tb_rr.setTooltip(new Tooltip("Filepath for heart-rate CSV file"));
            tb_behav.setTooltip(new Tooltip("Filepath for behavioral  CSV file"));
            tb_delay1.setTooltip(new Tooltip("Start time of the RR Data")); //rrstart
            tb_delay2.setTooltip(new Tooltip("Start time of the Behavioral Data")); //behstart
            tb_delay3.setTooltip(new Tooltip("The relative Behavioral sync time with respect to the RR time")); //beh sync
            
        } else {
            tb_part.setTooltip(null);    
            tb_rr.setTooltip(null); 
            tb_behav.setTooltip(null); 
            tb_delay1.setTooltip(null); 
            tb_delay2.setTooltip(null); 
            tb_delay3.setTooltip(null); 
        }
    }
    
    void inputErrorAlert(String errorMessage) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText("There was an error in your parameters");
        alert.setContentText(errorMessage);
        alert.showAndWait();
        return;
    }
    
}
