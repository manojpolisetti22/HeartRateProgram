/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HeartRateProgram;

import HeartRateProgram.Libraries.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rajith
 */
public class DataViewController implements Initializable {
    Stage thisStage;
    /**
     * Initializes the controller class.
     */
    String mode; 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO        
    }   
    
    public void initFiles(String participant_id, String rr_file, String behavior_file, 
            double rr_start, double rr_sync, double behav_sync) {
        mode = "Basic";
        
        MainParser parser = new MainParser();
        List<Double> rrList = parser.csvParserHeartRate(rr_file);
        List<Attribute> attrList = parser.csvParserBehavioral(behavior_file);
        parser.finalParser(rrList, attrList, rr_start, rr_sync, behav_sync);
        
    }
    
    public void initFilesAdvanced(String file) {
        mode = "Advanced";
    }
    
    public void export() {
        //TODO  
    }
    public void setStage(Stage stage) {
        thisStage = stage;
    }
    
    public void showStage(){
        thisStage.setTitle("Replace this before the demo");
        thisStage.show();
    } 
}
