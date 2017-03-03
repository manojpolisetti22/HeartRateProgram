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


/**
 * FXML Controller class
 *
 * @author Rajith
 */
public class StartPageController implements Initializable {

    Stage thisStage;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void exit_app(ActionEvent event) {
        System.out.println("Exiting");
        Child c;
        
        Platform.exit();
    }
    
    @FXML
    public void openInputDataPage(ActionEvent event) {
        System.out.println("Opening Input Data Page");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InputData.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            stage.setResizable(false);
            stage.showAndWait();
        } catch(Exception e) {
           e.printStackTrace();
        }
    }
    
    public void setStage(Stage stage) {
        thisStage = stage;
    }
    
    public void showStage(){
        thisStage.setTitle("Replace this before the demo");
        thisStage.show();
    }
    
}
