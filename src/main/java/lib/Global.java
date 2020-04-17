package lib;

import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Global {
	
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports report;
	public static ExtentTest logger;

	public static String groupFilepath="/Volumes/Storage/Dashboards/JavaSelenium/com.vmware.practiceHybrid/TestArtifacts/GroupControlFile.xlsx";
	
	public static String gstrID;
	public static String gstrAutomationID;
	public static String gstrManualID;
	public static String gstrDescription;
	
	public static String  gstrClassName;
	public static String  gstrMethodName;
	public static String pathArtifacts="/Volumes/Storage/Dashboards/JavaSelenium/com.vmware.practiceHybrid/TestArtifacts/";
	public static Map gstrObjdataMap;
	public static String gstrAppURL="https://rightstartmath.com/";
}
