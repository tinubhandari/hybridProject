package lib;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Report {
	
	public static void createHTMLReport()
	{
		Global.htmlReporter= new ExtentHtmlReporter("/Volumes/Storage/Dashboards/JavaSelenium/com.vmware.practiceHybrid/Reports/TestResultLogs/Batch.html");
		Global.report= new ExtentReports();
		Global.report.attachReporter(Global.htmlReporter);
		
	}
	
	public static void writeHTMLLogs(String strpassFail,String description)
	
	{
		 if(strpassFail.contentEquals("PASS")) {
			   Global.logger.log(Status.PASS, description);
		   }
		   else if (strpassFail.contentEquals("FAIL")) {
			   Global.logger.log(Status.FAIL, description);
		   }
		   else {
			   Global.logger.log(Status.INFO, description);
		   }
	}

}
