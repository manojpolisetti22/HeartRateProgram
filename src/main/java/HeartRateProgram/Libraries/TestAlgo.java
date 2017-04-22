package HeartRateProgram.Libraries;

import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
//import difflib.*;

import static org.junit.Assert.*;
//import static org.testng.AssertJUnit.assertFalse;

/**
 * Created by ruhana on 4/4/17.
 */
public class TestAlgo {
    private String testPath = "/Users/ruhana/IdeaProjects/HeartRateDeceleration/src/HeartRateProgram/src/main" +
            "/java/HeartRateProgram/Libraries/Test_Outputs/";


    @Test
    public void testNormalBaseLine() {
        LinkedList<Double> timestamps = new LinkedList();
        Trial trail = new Trial("1000" ,"ChildA", new Date(2017,2,28), new Date(2017,2,28), Sex.FEMALE);
        HashMap<Double, Attribute> table = new HashMap<>();


        double currStamp = (double) 71000;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.TASK));
        currStamp = (double) 71680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 400));
        currStamp = (double) 72897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 403));
        currStamp = (double) 73303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 73713;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 453));
        currStamp = (double) 74167;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 410));
        currStamp = (double) 74500;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 75657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 490));
        currStamp = (double) 75680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 75093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 75493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 409));
        currStamp = (double) 75897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 408));
        currStamp = (double) 75303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 76657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 390));
        currStamp = (double) 76680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 309));
        currStamp = (double) 76897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 308));
        currStamp = (double) 76303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 307));
        currStamp = (double) 78700;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));


        Algorithm s = new Algorithm();
        trail.setAttributeTable(table);


        HashMap<Double, Attribute> output= null;
        try {
            output = s.calculate( trail.getAttributeTable());
        } catch (DoubleStop doubleStop) {
            doubleStop.printStackTrace();
        } catch (DoubleStart doubleStart) {
            doubleStart.printStackTrace();
        }
        //s.printTable(output);

        String path = testPath + "testNormalBaseLineOut";

        try {
            ConvertToCSV.convertToCSV(path, output);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int status = ConvertToCSV.compare(testPath + "testNormalBaseLine",path);
        assertTrue(status == 1);

    }

    @Test
    public void quickLookBaseline() {
        LinkedList<Double> timestamps = new LinkedList();
        Trial trail = new Trial("1000" ,"ChildA", new Date(2017,2,28), new Date(2017,2,28), Sex.FEMALE);
        HashMap<Double, Attribute> table = new HashMap<>();




        double currStamp = (double) 71000;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START , CODE_TYPE.TASK));
        currStamp = (double) 71680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 400));
        currStamp = (double) 72897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 403));
        currStamp = (double) 73303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 73713;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 453));
        currStamp = (double) 74167;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 410));
        currStamp = (double) 74500;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 75657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 490));
        currStamp = (double) 75680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 75093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 75493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 409));
        currStamp = (double) 75897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 408));
        currStamp = (double) 75303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 76657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 390));
        currStamp = (double) 76680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 309));
        currStamp = (double) 76897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 308));
        currStamp = (double) 76303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 307));
        currStamp = (double) 77500;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));

        currStamp = (double) 78013;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 453));
        currStamp = (double) 78167;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 410));
        currStamp = (double) 78500;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 78657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 490));
        currStamp = (double) 78700;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));


        Algorithm s = new Algorithm();
        trail.setAttributeTable(table);
        s.printTable(trail.getAttributeTable());


        HashMap<Double, Attribute> output= null;
        try {
            output = s.calculate( trail.getAttributeTable());
        } catch (DoubleStop doubleStop) {
            doubleStop.printStackTrace();
        } catch (DoubleStart doubleStart) {
            doubleStart.printStackTrace();
        }
        s.printTable(output);



        String path = testPath + "quickLookBaseLineOut";

        try {
            ConvertToCSV.convertToCSV(path, output);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int status = ConvertToCSV.compare(testPath + "quickLookBaseLine",path);
        assertTrue(status == 1);
    }

    @Test
    public void testNormalPhases() {
        LinkedList<Double> timestamps = new LinkedList();
        Trial trail = new Trial("1000" ,"ChildA", new Date(2017,2,28), new Date(2017,2,28), Sex.FEMALE);
        HashMap<Double, Attribute> table = new HashMap<>();

        double currStamp = (double) 71000;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.TASK));
        currStamp = (double) 71680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 400));
        currStamp = (double) 72897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 403));
        currStamp = (double) 73303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 73713;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 453));
        currStamp = (double) 74167;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 410));
        currStamp = (double) 74500;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 75657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 490));
        currStamp = (double) 75680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 75093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 75493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 409));
        currStamp = (double) 75897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 408));
        currStamp = (double) 75303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 76657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 390));
        currStamp = (double) 76680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 309));
        currStamp = (double) 76897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 308));
        currStamp = (double) 76303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 307));
        currStamp = (double) 78700;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));


        Algorithm s = new Algorithm();
        trail.setAttributeTable(table);


        HashMap<Double, Attribute> output= null;
        try {
            output = s.calculate( trail.getAttributeTable());
        } catch (DoubleStop doubleStop) {
            doubleStop.printStackTrace();
        } catch (DoubleStart doubleStart) {
            doubleStart.printStackTrace();
        }
        output = s.calculatePhases(output);

        String path = testPath + "testNormalPhaseOut";

        try {
            ConvertToCSV.convertToCSV(path, output);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int status = ConvertToCSV.compare("/Users/ruhana/IdeaProjects/HeartRateDeceleration/src/HeartRateProgram/src/main/java/HeartRateProgram/Libraries/Test_Outputs/testNormalPhases",path);
        assertTrue(status == 1);
    }

    @Test
    public void quickLookPhases() {
        LinkedList<Double> timestamps = new LinkedList();
        Trial trail = new Trial("1000" ,"ChildA", new Date(2017,2,28), new Date(2017,2,28), Sex.FEMALE);
        HashMap<Double, Attribute> table = new HashMap<>();

        double currStamp = (double) 71000;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START , CODE_TYPE.TASK));
        currStamp = (double) 71680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 400));
        currStamp = (double) 72897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 403));
        currStamp = (double) 73303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 73713;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 453));
        currStamp = (double) 74167;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 410));
        currStamp = (double) 74500;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 75657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 490));
        currStamp = (double) 75680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 75093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 75493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 409));
        currStamp = (double) 75897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 408));
        currStamp = (double) 75303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 76657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 390));
        currStamp = (double) 76680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 309));
        currStamp = (double) 76897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 308));
        currStamp = (double) 76303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 307));
        currStamp = (double) 77500;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));

        currStamp = (double) 78013;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 453));
        currStamp = (double) 78167;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 410));
        currStamp = (double) 78500;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 78657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 490));
        currStamp = (double) 78700;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));


        Algorithm s = new Algorithm();
        trail.setAttributeTable(table);


        HashMap<Double, Attribute> output= null;
        try {
            output = s.calculate( trail.getAttributeTable());
        } catch (DoubleStop doubleStop) {
            doubleStop.printStackTrace();
        } catch (DoubleStart doubleStart) {
            doubleStart.printStackTrace();
        }
        output = s.calculatePhases(output);
        //s.printTable(output);

        String path = testPath + "quickLookPhasesOut";

        try {
            ConvertToCSV.convertToCSV(path, output);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int status = ConvertToCSV.compare(testPath + "quickLookPhases",path);
        assertTrue(status == 1);


    }

    @Test
    public void testCSV() {
        //List<String> orginal = fileToLines("adf");
        int status = ConvertToCSV
                .compare("/Users/ruhana/IdeaProjects/HeartRateDeceleration/src/HeartRateProgram" +
                                "/src" +
                                "/main/java/HeartRateProgram/Libraries/Test_Outputs/test1.txt",
                        "/Users/ruhana/IdeaProjects/HeartRateDeceleration/src/HeartRateProgram/src" +
                                "/main/java/HeartRateProgram/Libraries/Test_Outputs/test2.txt");




        assertTrue(status == 1);
    }

    @Test
    public void tonsenFile1() {
        MainParser mp = new MainParser();

        String rfilename = "/Users/ruhana/IdeaProjects/HeartRateDeceleration/src/HeartRateProgram/docs/dataSamples/Sample_RR.csv";
        String afilename = "/Users/ruhana/IdeaProjects/HeartRateDeceleration/src/HeartRateProgram/docs/dataSamples" +
                "/Sample_Behavior.csv";
        //List of RR's
        List<Double> rrList = mp.csvParserHeartRate(rfilename);


        //List of Attributes
        List<Attribute> attributeList = mp.csvParserBehavioral(afilename);


        HashMap<Double, Attribute> finalMap = mp.finalParser(rrList, attributeList, 21.7, 67, 23);


        Algorithm al = new Algorithm();
        Trial trail = new Trial("1000" ,"ChildA", new Date(2017,2,28), new Date(2017,2,28), Sex.FEMALE);
        trail.setAttributeTable(finalMap);
        try {
            trail.setAttributeTable(al.calculate(finalMap));
        } catch (DoubleStop doubleStop) {
            doubleStop.printStackTrace();
        } catch (DoubleStart doubleStart) {
            doubleStart.printStackTrace();
        }
        trail.setAttributeTable(al.calculatePhases(trail.getAttributeTable()));

        //al.printTable(trail.getAttributeTable());
        String path = testPath + "tonsenFile1";

        try {
            ConvertToCSV.convertToCSV(path, trail.getAttributeTable());
        } catch (IOException e) {
            e.printStackTrace();
        }

        int status = ConvertToCSV.compare(testPath + "tonsenFile1",path);
        assertTrue(status == 1);
    }

    @Test
    public void doubleStart() {
        LinkedList<Double> timestamps = new LinkedList();
        Trial trail = new Trial("1000" ,"ChildA", new Date(2017,2,28), new Date(2017,2,28), Sex.FEMALE);
        HashMap<Double, Attribute> table = new HashMap<>();


        double currStamp = (double) 71000;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.TASK));
        currStamp = (double) 71680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 400));
        currStamp = (double) 72897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 403));
        currStamp = (double) 73303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 73713;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 453));
        currStamp = (double) 74167;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 410));
        currStamp = (double) 74500;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 75657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 490));
        currStamp = (double) 75680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 75093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 75493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 409));
        currStamp = (double) 75897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 408));
        currStamp = (double) 75303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 76657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 76680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 309));
        currStamp = (double) 76897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 308));
        currStamp = (double) 76303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 307));
        currStamp = (double) 78700;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));


        Algorithm s = new Algorithm();
        trail.setAttributeTable(table);



        HashMap<Double, Attribute> output= null;
        int error = 0;
        try {
            output = s.calculate( trail.getAttributeTable());
        } catch (DoubleStop doubleStop) {
            doubleStop.printStackTrace();
        } catch (DoubleStart doubleStart) {
            error = 1;
            //doubleStart.printStackTrace();
        }
        assertTrue(error == 1);
    }

    @Test
    public void doubleStop() {
        LinkedList<Double> timestamps = new LinkedList();
        Trial trail = new Trial("1000" ,"ChildA", new Date(2017,2,28), new Date(2017,2,28), Sex.FEMALE);
        HashMap<Double, Attribute> table = new HashMap<>();


        double currStamp = (double) 71000;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.TASK));
        currStamp = (double) 71680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 400));
        currStamp = (double) 72897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 403));
        currStamp = (double) 73303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 73713;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 453));
        currStamp = (double) 74167;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 410));
        currStamp = (double) 74500;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 75657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 490));
        currStamp = (double) 75680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 75093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 75493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 409));
        currStamp = (double) 75897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 408));
        currStamp = (double) 75303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 76657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));
        currStamp = (double) 76680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 309));
        currStamp = (double) 76897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 308));
        currStamp = (double) 76303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 307));
        currStamp = (double) 78700;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));


        Algorithm s = new Algorithm();
        trail.setAttributeTable(table);



        HashMap<Double, Attribute> output= null;
        int error = 0;
        try {
            output = s.calculate( trail.getAttributeTable());
        } catch (DoubleStop doubleStop) {
            error = 1;
            //doubleStop.printStackTrace();
        } catch (DoubleStart doubleStart) {
            //error = 1;
            doubleStart.printStackTrace();
        }
        assertTrue(error == 1);
    }

    @Test
    public void phaseOne(){
        LinkedList<Double> timestamps = new LinkedList();
        Trial trail = new Trial("1000" ,"ChildA", new Date(2017,2,28), new Date(2017,2,28), Sex.FEMALE);
        HashMap<Double, Attribute> table = new HashMap<>();


        double currStamp = (double) 71000;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.TASK));
        currStamp = (double) 71680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 400));
        currStamp = (double) 72897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 403));
        currStamp = (double) 73303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 73713;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 453));
        currStamp = (double) 74167;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 410));
        currStamp = (double) 74500;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 75657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 490));
        currStamp = (double) 75680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 75093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 406));
        currStamp = (double) 75493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 409));
        currStamp = (double) 75897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 406));
        currStamp = (double) 75303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 76657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 390));
        currStamp = (double) 76680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 309));
        currStamp = (double) 76897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 308));
        currStamp = (double) 76303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 307));
        currStamp = (double) 78700;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));


        Algorithm s = new Algorithm();
        trail.setAttributeTable(table);


        HashMap<Double, Attribute> output= null;
        try {
            output = s.calculate( trail.getAttributeTable());
            output = s.calculatePhases(output);
        } catch (DoubleStop doubleStop) {
            doubleStop.printStackTrace();
        } catch (DoubleStart doubleStart) {
            doubleStart.printStackTrace();
        }
         //s.printTable(output);

        String path = testPath + "phaseOneOut";

        try {
            ConvertToCSV.convertToCSV(path, output);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int status = ConvertToCSV.compare(testPath + "phaseOne",path);
        assertTrue(status == 1);
    }

    @Test
    public void phaseThreeToTwo() {
        LinkedList<Double> timestamps = new LinkedList();
        Trial trail = new Trial("1000" ,"ChildA", new Date(2017,2,28), new Date(2017,2,28), Sex.FEMALE);
        HashMap<Double, Attribute> table = new HashMap<>();


        double currStamp = (double) 71000;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.TASK));
        currStamp = (double) 71680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 400));
        currStamp = (double) 72897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 403));
        currStamp = (double) 73303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 73713;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 453));
        currStamp = (double) 74167;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 410));
        currStamp = (double) 74500;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 75657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 490));
        currStamp = (double) 75680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 75093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 75493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 409));
        currStamp = (double) 75897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 408));
        currStamp = (double) 75303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 76657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 390));
        currStamp = (double) 76680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 309));
        currStamp = (double) 76897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 308));
        currStamp = (double) 76303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 307));
        currStamp = (double) 77680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 77093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 77493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 309));
        currStamp = (double) 77897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 308));
        currStamp = (double) 77303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 307));
        currStamp = (double) 79657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 490));
        currStamp = (double) 79680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 79093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 79493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 409));
        currStamp = (double) 79897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 408));
        currStamp = (double) 79997;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 408));
        currStamp = (double) 80000;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));


        Algorithm s = new Algorithm();
        trail.setAttributeTable(table);


        HashMap<Double, Attribute> output= null;
        try {
            output = s.calculate( trail.getAttributeTable());
            output = s.calculatePhases(output);
        } catch (DoubleStop doubleStop) {
            doubleStop.printStackTrace();
        } catch (DoubleStart doubleStart) {
            doubleStart.printStackTrace();
        }
        //s.printTable(output);

        String path = testPath + "phaseThreeToTwoOut";

        try {
            ConvertToCSV.convertToCSV(path, output);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int status = ConvertToCSV.compare(testPath + "phaseThreeToTwo", path);
        assertTrue(status == 1);

    }

    @Test
    public void durationLooking() {
        LinkedList<Double> timestamps = new LinkedList();
        Trial trail = new Trial("1000" ,"ChildA", new Date(2017,2,28), new Date(2017,2,28), Sex.FEMALE);
        HashMap<Double, Attribute> table = new HashMap<>();


        double currStamp = (double) 71000;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.TASK));
        currStamp = (double) 71680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 400));
        currStamp = (double) 72897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 403));
        currStamp = (double) 73303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 73713;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 453));
        currStamp = (double) 74167;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 410));
        currStamp = (double) 74500;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 75657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 490));
        currStamp = (double) 75680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 75093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));
        currStamp = (double) 75493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 409));
        currStamp = (double) 75897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 408));
        currStamp = (double) 75303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 76657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 390));
        currStamp = (double) 76680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 76897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 308));
        currStamp = (double) 76303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 307));
        currStamp = (double) 77680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 77093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 77493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 309));
        currStamp = (double) 77897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 308));
        currStamp = (double) 77303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 307));
        currStamp = (double) 79657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 490));
        currStamp = (double) 79680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 79093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 79493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 409));
        currStamp = (double) 79897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 408));
        currStamp = (double) 79997;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 408));
        currStamp = (double) 80000;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));


        Algorithm s = new Algorithm();
        trail.setAttributeTable(table);

        double duration = s.durationLooking(trail.getAttributeTable());
        assertTrue(duration == 4100);


    }



    @Test
    public void durationPhaseZero() {
        LinkedList<Double> timestamps = new LinkedList();
        Trial trail = new Trial("1000" ,"ChildA", new Date(2017,2,28), new Date(2017,2,28), Sex.FEMALE);
        HashMap<Double, Attribute> table = new HashMap<>();


        double currStamp = (double) 71000;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.TASK));
        currStamp = (double) 71680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 400));
        currStamp = (double) 72897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 403));
        currStamp = (double) 73303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 73713;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 453));
        currStamp = (double) 74167;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 410));
        currStamp = (double) 74500;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 75657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 490));
        currStamp = (double) 75680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 75093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));
        currStamp = (double) 75493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 409));
        currStamp = (double) 75897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 408));
        currStamp = (double) 75303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 76657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 390));
        currStamp = (double) 76680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 76897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 308));
        currStamp = (double) 76303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 307));
        currStamp = (double) 77680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 77093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 77493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 309));
        currStamp = (double) 77897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 308));
        currStamp = (double) 77303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 307));
        currStamp = (double) 79657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 490));
        currStamp = (double) 79680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 79093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 79493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 409));
        currStamp = (double) 79897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 408));
        currStamp = (double) 79997;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 408));
        currStamp = (double) 80000;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));

        Algorithm s = new Algorithm();
        trail.setAttributeTable(table);
        try {
            trail.setAttributeTable(s.calculate(trail.getAttributeTable()));
            trail.setAttributeTable(s.calculatePhases(trail.getAttributeTable()));
            double duration = s.durationPhase(trail.getAttributeTable(), 0);
            assertTrue(duration == 4900);

            s.printTable(trail.getAttributeTable());
            System.out.println(duration);

        } catch (DoubleStop doubleStop) {
            doubleStop.printStackTrace();
        } catch (DoubleStart doubleStart) {
            doubleStart.printStackTrace();
        }

    }

    @Test
    public void durationPhaseOne() {
        LinkedList<Double> timestamps = new LinkedList();
        Trial trail = new Trial("1000" ,"ChildA", new Date(2017,2,28), new Date(2017,2,28), Sex.FEMALE);
        HashMap<Double, Attribute> table = new HashMap<>();


        double currStamp = (double) 71000;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.TASK));
        currStamp = (double) 71680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 400));
        currStamp = (double) 72897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 403));
        currStamp = (double) 73303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 73713;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 453));
        currStamp = (double) 74167;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 410));
        currStamp = (double) 74500;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 75657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 490));
        currStamp = (double) 75680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 75093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));
        currStamp = (double) 75493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 409));
        currStamp = (double) 75897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 408));
        currStamp = (double) 75303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 76657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 390));
        currStamp = (double) 76680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 76897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 308));
        currStamp = (double) 76303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 307));
        currStamp = (double) 77680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 77093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 77493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 309));
        currStamp = (double) 77897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 308));
        currStamp = (double) 77303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 307));
        currStamp = (double) 79657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 490));
        currStamp = (double) 79680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 79093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 79493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 409));
        currStamp = (double) 79897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 408));
        currStamp = (double) 79997;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 408));
        currStamp = (double) 80000;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));

        Algorithm s = new Algorithm();
        trail.setAttributeTable(table);
        try {
            trail.setAttributeTable(s.calculate(trail.getAttributeTable()));
            trail.setAttributeTable(s.calculatePhases(trail.getAttributeTable()));
            double duration = s.durationPhase(trail.getAttributeTable(), 1);
            assertTrue(duration == 3340);

            //s.printTable(trail.getAttributeTable());
            //System.out.println(duration);

        } catch (DoubleStop doubleStop) {
            doubleStop.printStackTrace();
        } catch (DoubleStart doubleStart) {
            doubleStart.printStackTrace();
        }

    }

    @Test
    public void averageRrChangeOne() {
        LinkedList<Double> timestamps = new LinkedList();
        Trial trail = new Trial("1000" ,"ChildA", new Date(2017,2,28), new Date(2017,2,28), Sex.FEMALE);
        HashMap<Double, Attribute> table = new HashMap<>();


        double currStamp = (double) 71000;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.TASK));
        currStamp = (double) 71680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 400));
        currStamp = (double) 72897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 403));
        currStamp = (double) 73303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 73713;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 453));
        currStamp = (double) 74167;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 410));
        currStamp = (double) 74500;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 75657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 490));
        currStamp = (double) 75680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 75093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));
        currStamp = (double) 75493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 409));
        currStamp = (double) 75897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 408));
        currStamp = (double) 75303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 76657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 390));
        currStamp = (double) 76680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 76897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 308));
        currStamp = (double) 76303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 307));
        currStamp = (double) 77680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 77093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 77493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 309));
        currStamp = (double) 77897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 308));
        currStamp = (double) 77303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 307));
        currStamp = (double) 79657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 490));
        currStamp = (double) 79680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 79093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 79493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 409));
        currStamp = (double) 79897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 408));
        currStamp = (double) 79997;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 408));
        currStamp = (double) 80000;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));

        Algorithm s = new Algorithm();
        trail.setAttributeTable(table);
        try {
            trail.setAttributeTable(s.calculate(trail.getAttributeTable()));
            trail.setAttributeTable(s.calculatePhases(trail.getAttributeTable()));
            double average = s.averageRrChange(trail.getAttributeTable(), 1);
            assertTrue(average == 61.23076923076923);

            //s.printTable(trail.getAttributeTable());
            //System.out.println(average);

        } catch (DoubleStop doubleStop) {
            doubleStop.printStackTrace();
        } catch (DoubleStart doubleStart) {
            doubleStart.printStackTrace();
        }

    }

    @Test
    public void phaseTwoNum() {
        LinkedList<Double> timestamps = new LinkedList();
        Trial trail = new Trial("1000" ,"ChildA", new Date(2017,2,28), new Date(2017,2,28), Sex.FEMALE);
        HashMap<Double, Attribute> table = new HashMap<>();


        double currStamp = (double) 71000;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.TASK));
        currStamp = (double) 71680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 400));
        currStamp = (double) 72897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 403));
        currStamp = (double) 73303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 73713;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 453));
        currStamp = (double) 74167;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 410));
        currStamp = (double) 74500;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 75657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 490));
        currStamp = (double) 75680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 75093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));
        currStamp = (double) 75493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 75897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));
        currStamp = (double) 75303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 76657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 390));
        currStamp = (double) 76680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 76897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 308));
        currStamp = (double) 76303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 307));
        currStamp = (double) 77680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 77093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 77493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 309));
        currStamp = (double) 77897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 308));
        currStamp = (double) 77303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 307));
        currStamp = (double) 79657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 490));
        currStamp = (double) 79680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 79093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 79493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 409));
        currStamp = (double) 79897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 408));
        currStamp = (double) 79997;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 408));
        currStamp = (double) 80000;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));


        Algorithm s = new Algorithm();
        trail.setAttributeTable(table);

        try {
            trail.setAttributeTable(s.calculate(trail.getAttributeTable()));
            trail.setAttributeTable(s.calculatePhases(trail.getAttributeTable()));
            int num = s.phaseNum(trail.getAttributeTable(), 1);
            assertTrue(num == 4);

           // s.printTable(trail.getAttributeTable());
           // System.out.println(num);

        } catch (DoubleStop doubleStop) {
            doubleStop.printStackTrace();
        } catch (DoubleStart doubleStart) {
            doubleStart.printStackTrace();
        }


    }


    @Test
    public void peakLook() {
        LinkedList<Double> timestamps = new LinkedList();
        Trial trail = new Trial("1000" ,"ChildA", new Date(2017,2,28), new Date(2017,2,28), Sex.FEMALE);
        HashMap<Double, Attribute> table = new HashMap<>();


        double currStamp = (double) 71000;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.TASK));
        currStamp = (double) 71680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 400));
        currStamp = (double) 72897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 403));
        currStamp = (double) 73303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 73713;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 453));
        currStamp = (double) 74167;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 410));
        currStamp = (double) 74500;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 75657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 490));
        currStamp = (double) 75680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 75093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));
        currStamp = (double) 75493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 75897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));
        currStamp = (double) 75303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 76657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 390));
        currStamp = (double) 76680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 76897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 308));
        currStamp = (double) 76303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 307));
        currStamp = (double) 77680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 77093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 77493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 309));
        currStamp = (double) 77897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 308));
        currStamp = (double) 77303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 307));
        currStamp = (double) 79657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 490));
        currStamp = (double) 79680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 79093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 79493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 409));
        currStamp = (double) 79897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 408));
        currStamp = (double) 79997;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 408));
        currStamp = (double) 80000;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));


        Algorithm s = new Algorithm();
        trail.setAttributeTable(table);

        try {
            trail.setAttributeTable(s.calculate(trail.getAttributeTable()));
            trail.setAttributeTable(s.calculatePhases(trail.getAttributeTable()));
            double peak = s.peakLook(trail.getAttributeTable());
            assertTrue(peak == 3507);

             //s.printTable(trail.getAttributeTable());
             //System.out.println(peak);

        } catch (DoubleStop doubleStop) {
            doubleStop.printStackTrace();
        } catch (DoubleStart doubleStart) {
            doubleStart.printStackTrace();
        }


    }

    @Test
    public void peakPhaseOne() {
        LinkedList<Double> timestamps = new LinkedList();
        Trial trail = new Trial("1000" ,"ChildA", new Date(2017,2,28), new Date(2017,2,28), Sex.FEMALE);
        HashMap<Double, Attribute> table = new HashMap<>();


        double currStamp = (double) 71000;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.TASK));
        currStamp = (double) 71680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 400));
        currStamp = (double) 72897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 403));
        currStamp = (double) 73303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 73713;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 453));
        currStamp = (double) 74167;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 410));
        currStamp = (double) 74500;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 75657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 490));
        currStamp = (double) 75680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 75093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));
        currStamp = (double) 75493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 75897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));
        currStamp = (double) 75303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 76657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 390));
        currStamp = (double) 76680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 76897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 308));
        currStamp = (double) 76303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 307));
        currStamp = (double) 77680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 77093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 77493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 309));
        currStamp = (double) 77897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 308));
        currStamp = (double) 77303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 307));
        currStamp = (double) 79657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 490));
        currStamp = (double) 79680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 79093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 79493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 409));
        currStamp = (double) 79897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 408));
        currStamp = (double) 79997;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 408));
        currStamp = (double) 80000;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));


        Algorithm s = new Algorithm();
        trail.setAttributeTable(table);

        try {
            trail.setAttributeTable(s.calculate(trail.getAttributeTable()));
            trail.setAttributeTable(s.calculatePhases(trail.getAttributeTable()));
            double peak = s.peakPhase(trail.getAttributeTable(), 1);
            assertTrue(peak == 3340);

            s.printTable(trail.getAttributeTable());
            System.out.println(peak);

        } catch (DoubleStop doubleStop) {
            doubleStop.printStackTrace();
        } catch (DoubleStart doubleStart) {
            doubleStart.printStackTrace();
        }


    }

    @Test
    public void durationTask() {
        LinkedList<Double> timestamps = new LinkedList();
        Trial trail = new Trial("1000" ,"ChildA", new Date(2017,2,28), new Date(2017,2,28), Sex.FEMALE);
        HashMap<Double, Attribute> table = new HashMap<>();


        double currStamp = (double) 71000;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.TASK));
        currStamp = (double) 71680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 400));
        currStamp = (double) 72897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 403));
        currStamp = (double) 73303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 73713;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 453));
        currStamp = (double) 74167;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 410));
        currStamp = (double) 74500;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 75657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 490));
        currStamp = (double) 75680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 75093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));
        currStamp = (double) 75493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 75897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));
        currStamp = (double) 75303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 76657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 390));
        currStamp = (double) 76680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 76897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 308));
        currStamp = (double) 76303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 307));
        currStamp = (double) 77680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 77093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 77493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 309));
        currStamp = (double) 77897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 308));
        currStamp = (double) 77303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 307));
        currStamp = (double) 79657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.TASK));
        currStamp = (double) 79680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 79093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 79493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 409));
        currStamp = (double) 79897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 408));
        currStamp = (double) 79997;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 408));
        currStamp = (double) 80000;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));


        Algorithm s = new Algorithm();
        trail.setAttributeTable(table);

        try {
            trail.setAttributeTable(s.calculate(trail.getAttributeTable()));
            trail.setAttributeTable(s.calculatePhases(trail.getAttributeTable()));
            double durationTask = s.durationTask(trail.getAttributeTable());
            assertTrue(durationTask == 8657.0);

           // s.printTable(trail.getAttributeTable());
           // System.out.println(durationTask);

        } catch (DoubleStop doubleStop) {
            doubleStop.printStackTrace();
        } catch (DoubleStart doubleStart) {
            doubleStart.printStackTrace();
        }

    }


    @Test
    public void proportionTask() {
        LinkedList<Double> timestamps = new LinkedList();
        Trial trail = new Trial("1000" ,"ChildA", new Date(2017,2,28), new Date(2017,2,28), Sex.FEMALE);
        HashMap<Double, Attribute> table = new HashMap<>();


        double currStamp = (double) 71000;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.TASK));
        currStamp = (double) 71680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 400));
        currStamp = (double) 72897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 403));
        currStamp = (double) 73303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 73713;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 453));
        currStamp = (double) 74167;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 410));
        currStamp = (double) 74500;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 75657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 490));
        currStamp = (double) 75680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 75093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));
        currStamp = (double) 75493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 75897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));
        currStamp = (double) 75303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 76657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 390));
        currStamp = (double) 76680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 76897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 308));
        currStamp = (double) 76303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 307));
        currStamp = (double) 77680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 77093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 77493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 309));
        currStamp = (double) 77897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 308));
        currStamp = (double) 77303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 307));
        currStamp = (double) 79657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.TASK));
        currStamp = (double) 79680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 79093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 79493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 409));
        currStamp = (double) 79897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 408));
        currStamp = (double) 79997;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 408));
        currStamp = (double) 80000;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));


        Algorithm s = new Algorithm();
        trail.setAttributeTable(table);

        try {
            trail.setAttributeTable(s.calculate(trail.getAttributeTable()));
            trail.setAttributeTable(s.calculatePhases(trail.getAttributeTable()));
            double p = s.proportionTotal(trail.getAttributeTable(), 1);
            assertTrue(p == 0.4424165415270879);

            s.printTable(trail.getAttributeTable());
            System.out.println(p);

        } catch (DoubleStop doubleStop) {
            doubleStop.printStackTrace();
        } catch (DoubleStart doubleStart) {
            doubleStart.printStackTrace();
        }

    }


    @Test
    public void proportionPeakLook() {
        LinkedList<Double> timestamps = new LinkedList();
        Trial trail = new Trial("1000" ,"ChildA", new Date(2017,2,28), new Date(2017,2,28), Sex.FEMALE);
        HashMap<Double, Attribute> table = new HashMap<>();


        double currStamp = (double) 71000;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.TASK));
        currStamp = (double) 71680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 400));
        currStamp = (double) 72897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 403));
        currStamp = (double) 73303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 73713;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 453));
        currStamp = (double) 74167;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 410));
        currStamp = (double) 74500;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 75657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 490));
        currStamp = (double) 75680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 75093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));
        currStamp = (double) 75493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 75897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));
        currStamp = (double) 75303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 76657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 390));
        currStamp = (double) 76680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 76897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 308));
        currStamp = (double) 76303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 307));
        currStamp = (double) 77680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 77093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 77493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 309));
        currStamp = (double) 77897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 308));
        currStamp = (double) 77303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 307));
        currStamp = (double) 79657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 307));
        currStamp = (double) 79680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 79093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 79493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 409));
        currStamp = (double) 79897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 408));
        currStamp = (double) 79997;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 408));
        currStamp = (double) 80000;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));


        Algorithm s = new Algorithm();
        trail.setAttributeTable(table);

        try {
            trail.setAttributeTable(s.calculate(trail.getAttributeTable()));
            trail.setAttributeTable(s.calculatePhases(trail.getAttributeTable()));
            double p = s.proportionPeakLook(trail.getAttributeTable(), 1);
            assertTrue(p == 0.953236384374109);

            s.printTable(trail.getAttributeTable());
            System.out.println(p);

        } catch (DoubleStop doubleStop) {
            doubleStop.printStackTrace();
        } catch (DoubleStart doubleStart) {
            doubleStart.printStackTrace();
        }

    }

    @Test
    void calculateAll() {
        LinkedList<Double> timestamps = new LinkedList();
        Trial trail = new Trial("1000" ,"ChildA", new Date(2017,2,28), new Date(2017,2,28), Sex.FEMALE);
        HashMap<Double, Attribute> table = new HashMap<>();


        double currStamp = (double) 71000;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.TASK));
        currStamp = (double) 71680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 400));
        currStamp = (double) 72897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 403));
        currStamp = (double) 73303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 73713;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 453));
        currStamp = (double) 74167;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 410));
        currStamp = (double) 74500;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 75657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 490));
        currStamp = (double) 75680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 75093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));
        currStamp = (double) 75493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 75897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));
        currStamp = (double) 75303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 76657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 390));
        currStamp = (double) 76680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 76897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 308));
        currStamp = (double) 76303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 307));
        currStamp = (double) 77680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 77093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 77493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 309));
        currStamp = (double) 77897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 308));
        currStamp = (double) 77303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 307));
        currStamp = (double) 79657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.TASK));
        currStamp = (double) 79680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 79093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 79493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 409));
        currStamp = (double) 79897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 408));
        currStamp = (double) 79997;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 408));
        currStamp = (double) 80000;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));


        Algorithm s = new Algorithm();
        trail.setAttributeTable(table);

        try {
            trail.setAttributeTable(s.calculate(trail.getAttributeTable()));
            trail.setAttributeTable(s.calculatePhases(trail.getAttributeTable()));
            s.calculateAll(trail);

            s.printTable(trail.getAttributeTable());
            //System.out.println(p);

        } catch (DoubleStop doubleStop) {
            doubleStop.printStackTrace();
        } catch (DoubleStart doubleStart) {
            doubleStart.printStackTrace();
        }
    }


}
