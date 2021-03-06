/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HeartRateProgram;

import HeartRateProgram.Libraries.*;
import java.io.File;
import java.io.FileInputStream;
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
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
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
    @FXML
    ScrollPane sp_stats;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void initFiles(String participant_id, String rr_file, String behavior_file, double rr_start, double rr_sync, double behav_sync) {
        mode = "Basic";

        System.out.println("Intialization");

        // Parse Files
        MainParser parser = new MainParser();
        List<Double> rrList = parser.csvParserHeartRate(rr_file);
        List<Attribute> attrList = parser.csvParserBehavioral(behavior_file);
        HashMap<Double, Attribute> parsedData = parser.finalParser(rrList,
                attrList, rr_start, rr_sync, behav_sync);

        // Analyze Dataset
        HashMap<Double, Attribute> processedData;
        Algorithm algo = new Algorithm();
        Trial trial = new Trial(participant_id, parsedData);
        try {
            processedData = algo.calculateAll(trial);
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
        rrCol.setCellValueFactory(new PropertyValueFactory<>("stringRr"));
        TableColumn eventTypeCol = new TableColumn("Event Type");
        eventTypeCol.setCellValueFactory(new PropertyValueFactory<>("stringEvent_type"));
        TableColumn rRChangeCol = new TableColumn("RR Change");
        rRChangeCol.setCellValueFactory(new PropertyValueFactory<>("stringRrChange"));
        TableColumn phaseCol = new TableColumn("Phase");
        phaseCol.setCellValueFactory(new PropertyValueFactory<>("stringPhase"));
        TableColumn codeTypeCol = new TableColumn("Code Type");
        codeTypeCol.setCellValueFactory(new PropertyValueFactory<>("stringCode_type"));
        TableColumn eventNumCol = new TableColumn("Event Num");
        eventNumCol.setCellValueFactory(new PropertyValueFactory<>("stringEvent_num"));
        TableColumn baselineCol = new TableColumn("Baseline");
        baselineCol.setCellValueFactory(new PropertyValueFactory<>("stringBaseLine"));

        // Add information to table
        table.setItems(contents);
        table.getColumns().addAll(timeStampCol, rrCol, phaseCol, eventTypeCol,
                rRChangeCol, codeTypeCol, eventNumCol, baselineCol);
        defaultTab.setText(participant_id);

        // Start adding things to scrollPane
        TrailStat stats = trial.getStats();

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        String s = Double.toString(stats.getDurationTask());
        vbox.getChildren().add(createHBox("Duration Task", s));
        vbox.getChildren().add(createHBox("Duration Looking", Double.toString(stats.getDurationLook())));
        vbox.getChildren().add(createHBox("Duration 0", Double.toString(stats.getDurationZero())));
        vbox.getChildren().add(createHBox("Duration 1", Double.toString(stats.getDurationOne())));
        vbox.getChildren().add(createHBox("Duration 2", Double.toString(stats.getDurationTwo())));
        vbox.getChildren().add(createHBox("Duration 3", Double.toString(stats.getDurationThree())));
        vbox.getChildren().add(createHBox("Proportion 0", Double.toString(stats.getProportionZero())));
        vbox.getChildren().add(createHBox("Proportion 1", Double.toString(stats.getProportionOne())));
        vbox.getChildren().add(createHBox("Proportion 2", Double.toString(stats.getProportionTwo())));
        vbox.getChildren().add(createHBox("Proportion 3", Double.toString(stats.getProportionThree())));
        vbox.getChildren().add(createHBox("RR Change 1", Double.toString(stats.getRrChangeOne())));
        vbox.getChildren().add(createHBox("RR Change 2", Double.toString(stats.getRrChangeTwo())));
        vbox.getChildren().add(createHBox("RR Change 3", Double.toString(stats.getRrChangeThree())));
        vbox.getChildren().add(createHBox("Phases N_0", Double.toString(stats.getPhaseNZero())));
        vbox.getChildren().add(createHBox("Phases N_1", Double.toString(stats.getPhaseNOne())));
        vbox.getChildren().add(createHBox("Phases N_2", Double.toString(stats.getPhaseNTwo())));
        vbox.getChildren().add(createHBox("Phases N_3", Double.toString(stats.getPhaseNThree())));
        vbox.getChildren().add(createHBox("Peak Duration Total", Double.toString(stats.getPeakDurationTotal())));
        vbox.getChildren().add(createHBox("Peak Duration 1", Double.toString(stats.getPeakDurationOne())));
        vbox.getChildren().add(createHBox("Peak Duration 2", Double.toString(stats.getPeakDurationTwo())));
        vbox.getChildren().add(createHBox("Peak Duration 3", Double.toString(stats.getPeakDurationThree())));
        vbox.getChildren().add(createHBox("Peak Proportion 1", Double.toString(stats.getProportionOne())));
        vbox.getChildren().add(createHBox("Peak Proportion 2", Double.toString(stats.getProportionTwo())));
        vbox.getChildren().add(createHBox("Peak Proportion 3", Double.toString(stats.getProportionThree())));
        sp_stats.setContent(vbox);

    }

    public void initFilesAdvanced(List<DataGrid> dataList) {
        mode = "Advanced";

        // Preliminary stuff
        tabPane.getTabs().remove(0);
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
            rrCol.setCellValueFactory(new PropertyValueFactory<>("StringRr"));
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
            TableColumn baselineCol = new TableColumn("Baseline");
            baselineCol.setCellValueFactory(new PropertyValueFactory<>("stringBaseLine"));

            // Add information to table
            table.setEditable(false);
            table.setItems(contents);
            table.getColumns().addAll(timeStampCol, rrCol, phaseCol, eventTypeCol,
                    rRChangeCol, codeTypeCol, eventNumCol, baselineCol);

            // Create stats viewer and encompassing containers
            AnchorPane statsPane = new AnchorPane();
            TrailStat stats = trial.getStats();
            VBox vbox = new VBox();
            vbox.setPadding(new Insets(10));
            vbox.setSpacing(8);
            vbox.getChildren().add(createHBox("Duration Task", Double.toString(stats.getDurationTask())));
            vbox.getChildren().add(createHBox("Duration Looking", Double.toString(stats.getDurationLook())));
            vbox.getChildren().add(createHBox("Duration 0", Double.toString(stats.getDurationZero())));
            vbox.getChildren().add(createHBox("Duration 1", Double.toString(stats.getDurationOne())));
            vbox.getChildren().add(createHBox("Duration 2", Double.toString(stats.getDurationTwo())));
            vbox.getChildren().add(createHBox("Duration 3", Double.toString(stats.getDurationThree())));
            vbox.getChildren().add(createHBox("Proportion 0", Double.toString(stats.getProportionZero())));
            vbox.getChildren().add(createHBox("Proportion 1", Double.toString(stats.getProportionOne())));
            vbox.getChildren().add(createHBox("Proportion 2", Double.toString(stats.getProportionTwo())));
            vbox.getChildren().add(createHBox("Proportion 3", Double.toString(stats.getProportionThree())));
            vbox.getChildren().add(createHBox("RR Change 1", Double.toString(stats.getRrChangeOne())));
            vbox.getChildren().add(createHBox("RR Change 2", Double.toString(stats.getRrChangeTwo())));
            vbox.getChildren().add(createHBox("RR Change 3", Double.toString(stats.getRrChangeThree())));
            vbox.getChildren().add(createHBox("Phases N_0", Double.toString(stats.getPhaseNZero())));
            vbox.getChildren().add(createHBox("Phases N_1", Double.toString(stats.getPhaseNOne())));
            vbox.getChildren().add(createHBox("Phases N_2", Double.toString(stats.getPhaseNTwo())));
            vbox.getChildren().add(createHBox("Phases N_3", Double.toString(stats.getPhaseNThree())));
            vbox.getChildren().add(createHBox("Peak Duration Total", Double.toString(stats.getPeakDurationTotal())));
            vbox.getChildren().add(createHBox("Peak Duration 1", Double.toString(stats.getPeakDurationOne())));
            vbox.getChildren().add(createHBox("Peak Duration 2", Double.toString(stats.getPeakDurationTwo())));
            vbox.getChildren().add(createHBox("Peak Duration 3", Double.toString(stats.getPeakDurationThree())));
            vbox.getChildren().add(createHBox("Peak Proportion 1", Double.toString(stats.getProportionOne())));
            vbox.getChildren().add(createHBox("Peak Proportion 2", Double.toString(stats.getProportionTwo())));
            vbox.getChildren().add(createHBox("Peak Proportion 3", Double.toString(stats.getProportionThree())));
            ScrollPane scroller = new ScrollPane();
            scroller.setContent(vbox);
            scroller.setVbarPolicy(ScrollBarPolicy.ALWAYS);
            statsPane.getChildren().add(scroller);
            AnchorPane.setBottomAnchor(scroller, 0.0);
            AnchorPane.setTopAnchor(scroller, 0.0);
            AnchorPane.setLeftAnchor(scroller, 0.0);
            AnchorPane.setRightAnchor(scroller, 0.0);

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
        if ("Basic".equals(mode)) {
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
        } else if ("Advanced".equals(mode)) {
            File file;
            try {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Save Data");
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Compressed ZIP File(*.zip)", "*.zip"));
                file = fileChooser.showSaveDialog(null);
                String parentPath = file.getParent();
                ZipOutputStream out = new ZipOutputStream(new FileOutputStream(file.getAbsolutePath()));
                System.out.println(file.getPath());
                for (Trial trial : data_list) {
                    // File Information
                    String filename = trial.getTrialID() + ".csv";
                    System.out.println(filename);

                    // Create output files
                    ConvertToCSV.convertToCSV(filename, trial.getAttributeTable());

                    // Zipping
                    //Create a file input stream using the first trial
                    File csvFile = new File(filename);
                    FileInputStream fis = new FileInputStream(csvFile);
                    //Write the file to a ZipEntry object
                    ZipEntry e = new ZipEntry(filename);
                    out.putNextEntry(e);
                    byte[] bytes = new byte[1024];
                    int length;
                    while ((length = fis.read(bytes)) >= 0) {
                        out.write(bytes, 0, length);
                    }
                    
                    // Close things
                    out.closeEntry();
                    fis.close();
                    //Remove excess file from parent directory
                    csvFile.delete();
                }
                out.close();
                //Remove the excess files from parent directory
                for (Trial trial : data_list) {
                    String filename = parentPath + "/" + trial.getTrialID() + ".csv";
                    File f = new File(filename);
                    
                }
            } catch (Exception e) {
                System.out.println("The data is unable to be exported.");
                e.printStackTrace();
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
        label.setPrefWidth(120.0);
        label.setMinWidth(label.getPrefWidth());
        label.setMaxWidth(label.getPrefWidth());
        textField.setEditable(false);
        textField.setMaxWidth(Integer.MAX_VALUE);
        textField.setMinWidth(120);
        textField.setPrefWidth(200.0);
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
