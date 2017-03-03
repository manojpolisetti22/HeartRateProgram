/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HeartRateProgram;

import HeartRateProgram.Libraries.*;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;
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
    HashMap<Double,Attribute> data;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO        
    }   
    
    public void initFiles(String participant_id, String rr_file, String behavior_file, 
            double rr_start, double rr_sync, double behav_sync) {
        mode = "Basic";
        
        // Parse Files
        MainParser parser = new MainParser();
        List<Double> rrList = parser.csvParserHeartRate(rr_file);
        List<Attribute> attrList = parser.csvParserBehavioral(behavior_file);
        HashMap<Double,Attribute> parsedData = parser.finalParser(rrList, 
                attrList, rr_start, rr_sync, behav_sync);
        
        // Analyze Dataset
        Algorithm algo = new Algorithm();
        parsedData = algo.calculate(parsedData);
        
        data = parsedData;
    }
    
    public void initFilesAdvanced(String file) {
        mode = "Advanced";
    }
    
    public void export() {
        // Getting filename
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Data");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Comma Delimited File(*.csv)", "*.csv"));
        File file = fileChooser.showSaveDialog(null);
        
        String path = file.getAbsolutePath();
        ConvertToCSV.convertToCSV(path,data);
    }
    public void setStage(Stage stage) {
        thisStage = stage;
    }
    
    public void showStage(){
        thisStage.setTitle("Replace this before the demo");
        thisStage.show();
    } 
}
