/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HeartRateProgram;

import HeartRateProgram.Libraries.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.util.Collections;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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
    HashMap<Double, Attribute> data;
    ArrayList<Trial> data_list = new ArrayList<Trial>();

    // Objects made in Scene Builder
    @FXML
    TableView table;
    @FXML
    TabPane tabPane;
    @FXML
    Tab defaultTab;
    @FXML
    TextField tb_durationTask;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void initFiles(String participant_id, String rr_file, String behavior_file, double rr_start, double rr_sync, double behav_sync) {
        mode = "Basic";

        // Parse Files
        MainParser parser = new MainParser();
        List<Double> rrList = parser.csvParserHeartRate(rr_file);
        List<Attribute> attrList = parser.csvParserBehavioral(behavior_file);
        HashMap<Double, Attribute> parsedData = parser.finalParser(rrList,
                attrList, rr_start, rr_sync, behav_sync);

        // Analyze Dataset
        HashMap<Double, Attribute> processedData;
        Algorithm algo = new Algorithm();
        try {
            processedData = algo.calculate(parsedData);
            processedData = algo.calculatePhases(processedData);
        } catch (DoubleStart e) {
            algorithmErrorAlert(e.getMessage());
            return;
        } catch (DoubleStop e) {
            algorithmErrorAlert(e.getMessage());
            return;
        } catch (Exception e) {
            algorithmErrorAlert("An unknown error has occured. Review your "
                    + "datasets and try again");
            return;
        }
        //algo.printTable(processedData);

        // Get contents of table
        data = processedData;
        List<Double> timeList = algo.sortKeys(processedData);
        Collections.sort(timeList);
        //List<Attribute> contents = new ArrayList();
        final ObservableList<Attribute> contents = FXCollections.observableArrayList();
        for (int i = 0; i < timeList.size(); i++) {
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
        defaultTab.setText(participant_id);

    }

    public void initFilesAdvanced(List<DataGrid> dataList) {
        mode = "Advanced";

        // Preliminary tab stuff
        //tabPane.getTabs().remove(0);
        MainParser parser = new MainParser();

        dataList.forEach((line) -> {
            // Create Pane inside tab
            SplitPane pane = new SplitPane();
            pane.setDividerPositions(0.5);
            pane.setPrefSize(790, 715);

            // Create table and encompassing pane
            AnchorPane tablePane = new AnchorPane();
            tablePane.setMinSize(0, 0);
            tablePane.setPrefSize(100, 160);
            TableView table = new TableView();
            table.setMinSize(0, 0);
            tablePane.getChildren().add(table);
            AnchorPane.setLeftAnchor(table, 0.0);
            AnchorPane.setRightAnchor(table, 0.0);

            // Get parser parameters
            String rr_file = line.getRR_PATH();
            String behavior_file = line.getBEH_PATH();
            List<Double> rrList = parser.csvParserHeartRate(rr_file);
            List<Attribute> attrList = parser.csvParserBehavioral(behavior_file);
            Double rr_start = line.getRR_START();
            Double rr_sync = line.getRR_SYNC();
            Double behav_sync = line.getBEH_SYNC();

            // Final parser
            HashMap<Double, Attribute> parsedData = parser.finalParser(rrList,
                    attrList, rr_start, rr_sync, behav_sync);
            Trial trial = new Trial(line.getParticipantID(), parsedData);

            // Analyze Dataset
            HashMap<Double, Attribute> processedData;
            Algorithm algo = new Algorithm();
            try {
                processedData = algo.calculateAll(trial);
            } catch (DoubleStart | DoubleStop e) {
                algorithmErrorAlert(e.getMessage());
                return;
            } catch (Exception e) {
                algorithmErrorAlert("An unknown error has occured. Review your "
                        + "datasets and try again");
                return;
            }

            // Get contents of table
            data_list.add(trial);
            List<Double> timeList = algo.sortKeys(processedData);
            Collections.sort(timeList);
            final ObservableList<Attribute> contents = FXCollections.observableArrayList();
            for (int i = 0; i < timeList.size(); i++) {
                Attribute attribute = processedData.get(timeList.get(i));
                contents.add(attribute);
            }

            // Initialize columns with data
            TableColumn timeStampCol = new TableColumn("Timestamp");
            timeStampCol.setCellValueFactory(new PropertyValueFactory<>("timestamp"));
            TableColumn rrCol = new TableColumn("RR");
            timeStampCol.setCellValueFactory(new PropertyValueFactory<>("StringRr"));
            TableColumn eventTypeCol = new TableColumn("Event Type");
            eventTypeCol.setCellValueFactory(new PropertyValueFactory<>("stringEvent_type"));
            TableColumn rRChangeCol = new TableColumn("RR Change");
            rRChangeCol.setCellValueFactory(new PropertyValueFactory<>("StringRrChange"));
            TableColumn phaseCol = new TableColumn("Phase");
            phaseCol.setCellValueFactory(new PropertyValueFactory<>("stringPhase"));
            TableColumn codeTypeCol = new TableColumn("Code Type");
            codeTypeCol.setCellValueFactory(new PropertyValueFactory<>("stringCode_type"));
            TableColumn eventNumCol = new TableColumn("Event Num");
            eventNumCol.setCellValueFactory(new PropertyValueFactory<>("stringEvent_num"));
            TableColumn baselineCol = new TableColumn("Code Type");
            baselineCol.setCellValueFactory(new PropertyValueFactory<>("stringBaseLine"));

            // Add information to table
            table.setEditable(false);
            table.setItems(contents);
            table.getColumns().addAll(timeStampCol, rrCol, phaseCol, eventTypeCol,
                    rRChangeCol, codeTypeCol, eventNumCol, baselineCol);

            // Create stats viewer and encompassing containers
            AnchorPane statsPane = new AnchorPane();
            statsPane.getChildren().add(createHBox("Hello", "World"));

            // Set up splitpane
            pane.getItems().add(0, tablePane);
            pane.getItems().add(1, statsPane);

            // Create and populate Tab
            Tab tab = new Tab(line.getParticipantID());
            try {
                tab.setContent(pane);
            } catch (Exception e) {
                System.out.println("Something went wrong");
                e.printStackTrace();
                return;
            }
            tabPane.getTabs().add(tab);
        });
    }

    public void export() {
        if ("basic".equals(mode)) {
            File file;
            try {
                // Getting filename
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Save Data");
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Comma Delimited File(*.csv)", "*.csv"));
                file = fileChooser.showSaveDialog(null);
                String path = file.getAbsolutePath();
                ConvertToCSV.convertToCSV(path, this.data);
            } catch (IOException e) {
                exportErrorAlert("The data is unable to be exported.");
                return;
            }
        } else if ("advanced".equals(mode)) {
            File file;
            try {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Save Data");
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Compressed ZIP File(*.zip)", "*.zip"));
                file = fileChooser.showSaveDialog(null);
                String parentPath = file.getParent();
                ZipOutputStream out = new ZipOutputStream(new FileOutputStream(file));
                for (Trial trial : data_list) {
                    String filename = parentPath + '/' + trial.getTrialID();
                    ConvertToCSV.convertToCSV(filename, trial.getAttributeTable());
                    ZipEntry e = new ZipEntry(filename);
                    out.putNextEntry(e);
                    out.closeEntry();
                }
                out.close();
            } catch (Exception e) {

                return;
            }
        }
    }

    HBox createHBox(String labelText, String textFieldText) {
        // Create box
        HBox box = new HBox();
        AnchorPane.setLeftAnchor(box, 0.0);
        AnchorPane.setRightAnchor(box, 0.0);
        
        // Fill in the blanks
        Label label = new Label(labelText);
        TextField textField = new TextField(textFieldText);
        box.getChildren().addAll(label, textField);
        label.setMaxWidth(50.0); label.setMinWidth(0.0); label.setPrefWidth(120.0);
        textField.setEditable(false); 
        textField.setMaxWidth(Integer.MAX_VALUE);
        textField.setMinWidth(120);
        textField.setPrefWidth(226.0);
        textField.setPrefHeight(25.0);
        
        return box;
    }

    void algorithmErrorAlert(String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("An Error Has Occured");
        alert.setHeaderText("There was an error when analyzing the input data");
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }

    void exportErrorAlert(String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("An Error Has Occured");
        alert.setHeaderText("There was an error when exporting the data");
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }
}
