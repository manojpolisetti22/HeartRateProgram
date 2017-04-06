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
import java.util.ArrayList;
import java.util.Collections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
    @FXML TableView table;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO        
        /*
            Test data 
        */
        
        /*ArrayList<Book> books = new ArrayList<>();
        ObservableList<Book> b = FXCollections.observableArrayList(books);

        books.add(new Book("Brave New World", "Aldous Huxely"));
        books.add(new Book("To Kill a Mockingbird","Harper Lee"));
        books.add(new Book("East of Eden","John Steinbeck"));
        
        TableColumn author = new TableColumn("Author");
        table.getColumns().add(author); */
        
        
        
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
        HashMap<Double,Attribute> processedData = algo.calculate(parsedData);
        processedData = algo.calculatePhases(processedData);
        //algo.printTable(processedData); 
        
        // Get contents of table
        data = processedData;
        List<Double> timeList = algo.sortKeys(processedData);
        Collections.sort(timeList);
        //List<Attribute> contents = new ArrayList();
        final ObservableList<Attribute> contents = FXCollections.observableArrayList();
        for(int i = 0; i < timeList.size(); i++) {
            Attribute attribute = processedData.get(timeList.get(i));
            contents.add(attribute);
        }
        
        // Initialize table
        table.setEditable(false);
        
        // Initialize columns with data
        TableColumn timeStampCol = new TableColumn("Timestamp");
        timeStampCol.setCellValueFactory(new PropertyValueFactory<>("timestamp"));
        TableColumn rrCol = new TableColumn("RR");
        timeStampCol.setCellValueFactory(new PropertyValueFactory<>("Rr"));
        TableColumn eventTypeCol = new TableColumn("Event Type");
        eventTypeCol.setCellValueFactory(new PropertyValueFactory<>("Event_type"));
        TableColumn rRChangeCol = new TableColumn("RR Change");
        rRChangeCol.setCellValueFactory(new PropertyValueFactory<>("rrChange")); 
        TableColumn phaseCol = new TableColumn("Phase");
        phaseCol.setCellValueFactory(new PropertyValueFactory<>("phase"));
        TableColumn codeTypeCol = new TableColumn("Code Type");
        codeTypeCol.setCellValueFactory(new PropertyValueFactory<>("code_type"));
        TableColumn eventNumCol = new TableColumn("Event Num");
        eventNumCol.setCellValueFactory(new PropertyValueFactory<>("event_num"));
        TableColumn baselineCol = new TableColumn("Code Type");
        baselineCol.setCellValueFactory(new PropertyValueFactory<>("baseLine"));
                
        // Add information to table
        table.setItems(contents);
        table.getColumns().addAll(timeStampCol, rrCol, phaseCol, eventTypeCol,
                rRChangeCol, codeTypeCol, eventNumCol, baselineCol);
        
    }
    
    public void initFilesAdvanced(String file) {
        mode = "Advanced";
        
        // Add junk data
        
    }
    
    public void export() {
        // Getting filename
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Data");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Comma Delimited File(*.csv)", "*.csv"));
        File file = fileChooser.showSaveDialog(null);
        
        String path = file.getAbsolutePath();
        ConvertToCSV.convertToCSV(path,this.data);
    }

}
