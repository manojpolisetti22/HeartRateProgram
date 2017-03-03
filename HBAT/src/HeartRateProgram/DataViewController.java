/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HeartRateProgram;

import HeartRateProgram.Libraries.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Rajith
 */
public class DataViewController implements Initializable {

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
    }
    
    public void initFilesAdvanced(String file) {
        mode = "Advanced";
    }
    
    public void export() {
        //TODO  
    }
    
}
