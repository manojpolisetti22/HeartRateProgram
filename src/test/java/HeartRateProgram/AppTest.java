package HeartRateProgram.Libraries;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	private String testPath = "../../resources/Test_Outputs/";
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }	
    public void testApp22()
    {
        assertTrue( true );
    }	
	public void testNormalBaseLine() 
	{
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
        ConvertToCSV.convertToCSV(path, output);
        int status = ConvertToCSV.compare(testPath + "testNormalBaseLine",path);
		assertTrue(status == 1);
    
	}
}
/*
    public void testNormalBaseLine() 
	{
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
        ConvertToCSV.convertToCSV(path, output);
        int status = ConvertToCSV.compare(testPath + "testNormalBaseLine",path);
        assertTrue(status == 1);

    }

    
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
        ConvertToCSV.convertToCSV(path, output);
        int status = ConvertToCSV.compare(testPath + "quickLookBaseLine",path);
        assertTrue(status == 1);
    }

    
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
        ConvertToCSV.convertToCSV(path, output);
        int status = ConvertToCSV.compare("/Users/ruhana/IdeaProjects/HeartRateDeceleration/src/HeartRateProgram/src/main/java/HeartRateProgram/Libraries/Test_Outputs/testNormalPhases",path);
        assertTrue(status == 1);
    }

    
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
        ConvertToCSV.convertToCSV(path, output);
        int status = ConvertToCSV.compare(testPath + "quickLookPhases",path);
        assertTrue(status == 1);


    }

    
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
        ConvertToCSV.convertToCSV(path, trail.getAttributeTable());
        int status = ConvertToCSV.compare(testPath + "tonsenFile1",path);
        assertTrue(status == 1);
    }

    
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
        // s.printTable(output);

        String path = testPath + "phaseOneOut";
        ConvertToCSV.convertToCSV(path, output);
        int status = ConvertToCSV.compare(testPath + "phaseOne",path);
        assertTrue(status == 1);
    }

   
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
        ConvertToCSV.convertToCSV(path, output);
        int status = ConvertToCSV.compare(testPath + "phaseThreeToTwo",path);
        assertTrue(status == 1);

    }

   
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

    
    void durationTask() {
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

        // WHYY?? NOT WORKING
        //double duration = s.durationTask(trail.getAttributeTable());
        //System.out.println(duration);
        //assertTrue(duration == 9000);


    }

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
            double duration = s.durationPhaseZero(trail.getAttributeTable());
            System.out.println(duration);

        } catch (DoubleStop doubleStop) {
            doubleStop.printStackTrace();
        } catch (DoubleStart doubleStart) {
            doubleStart.printStackTrace();
        }
    }
}*/
