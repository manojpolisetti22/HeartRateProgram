/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HeartRateProgram;

import HeartRateProgram.Libraries.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;


/**
 * FXML Controller class
 *
 * @author Rajith
 */
public class StartPageController implements Initializable {

    @FXML Button pb_start;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        pb_start.setTooltip(new Tooltip("Launch a new program!"));
    }    
    
    @FXML
    public void exit_app(ActionEvent event) {
        //System.out.println("Exiting");        
        // Exit the program
        Platform.exit();
    }
    
    @FXML
    public void openInputDataPage(ActionEvent event) {
        System.out.println("Opening Input Data Page");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/InputData.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
           e.printStackTrace();
        }
        Stage starting = (Stage) pb_start.getScene().getWindow();
        starting.hide();

    }
    
    @FXML
    public void advanced(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/AdvancedTabInputData.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            stage.show();
        } catch(Exception e) {
           e.printStackTrace();
        }
        Stage starting = (Stage) pb_start.getScene().getWindow();
        starting.hide();    
    }
}
