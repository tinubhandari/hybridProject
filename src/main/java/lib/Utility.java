package lib;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class Utility {
	
	static WebDriver driver;
	public Utility(String browsername)
	{
		driver=InitDriver.getdriverinstance(browsername);
		Global.logger=Global.report.createTest(Global.gstrAutomationID, Global.gstrDescription);
	}
	
	public static WebDriver returndriver()
	{
		return driver;
	}
	
	public static Recordset getRecordUsingFillo(String filename, String query) throws FilloException
	{
		Fillo f=null;
		Connection con=null;
		f=new Fillo();
		con=f.getConnection(filename);
		Recordset r=con.executeQuery(query);
		
		return r;
		
	}
	
	
	public static List readGroups(String filename, String query) throws FilloException
	{
		ArrayList l= new ArrayList();
		Recordset rg=Utility.getRecordUsingFillo(filename,query);
		while(rg.next())
		{
			String s=rg.getField("Groups");
			l.add(s);
		}
		return l;
		
	}
	
	public static Recordset readTestCase(String filename, String query) throws FilloException
	{
		Recordset rt=Utility.getRecordUsingFillo(filename,query);
		return rt;
		
	}
	
	public static String clickElement(WebElement ele,String label,String value)
	
	{
		String s="";
		String strv=TestData.getTestDataValue(value);
		System.out.println("Value of strv:"+strv);
		if(strv.contentEquals("")||strv.contentEquals("SKIP")) {
			return s;
		}
		try {
			ele.click();
			Report.writeHTMLLogs("PASS", "Sucesfully click on the "+ label);
		}
		catch(Exception e)
		{
			Report.writeHTMLLogs("FAIL", "Fail to click on the "+ label + " " + e.getMessage());
		}
		
		
		return strv;
		
	}

	public static String EnterText(WebElement ele, String label, String value) {
		String s="";
		String strv=TestData.getTestDataValue(value);
		if(strv.contentEquals("")||strv.contentEquals("SKIP")) {
			return s;
		}
		try {
			ele.sendKeys(strv);
			Report.writeHTMLLogs("PASS", "Sucesfully enter the "+ label);
		}
		catch(Exception e)
		{
			Report.writeHTMLLogs("FAIL", "Fail to enter the "+ label + " " + e.getMessage());
		}
		
		
		return strv;
		
	}
}
