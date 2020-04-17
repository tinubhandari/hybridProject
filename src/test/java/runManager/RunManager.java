package runManager;

import org.testng.annotations.Test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import lib.Global;
import lib.Report;
import lib.Utility;

public class RunManager {

	
	//public static void main(String[] args) throws FilloException, NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	@Test
	public void runner() throws FilloException, NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		
		// TODO Auto-generated method stub
	
			Report.createHTMLReport();
			String strQuery =  "Select * from Groups where Run = 'Y'";
			List lgroup= Utility.readGroups(Global.groupFilepath, strQuery);

			for(int i=0;i<lgroup.size();i++)
			{
				String sheetname= lgroup.get(i).toString();
				String sheetquery="Select * from "+sheetname+" where Run='Y'";

				Recordset rs_TestCase= Utility.readTestCase(Global.groupFilepath, sheetquery);
				while(rs_TestCase.next())
				{
					Global.gstrID=rs_TestCase.getField("ID");
					Global.gstrAutomationID=rs_TestCase.getField("AutomationID");
					Global.gstrManualID=rs_TestCase.getField("ManualTcID");
					Global.gstrDescription=rs_TestCase.getField("Description");
					String strComponents = rs_TestCase.getField("BatchFile");
					String arr[]=strComponents.split("_");

					new Utility("CHROME");

					for(int j=0;j<arr.length;j++)
					{
						String classname=arr[j].split("\\.")[0];
						Global.gstrClassName=classname;
						String methodname=arr[j].split("\\.")[1];;
						Global.gstrMethodName=methodname;



						Class cls = Class.forName("pages."+classname);
						Object obj = cls.newInstance();
						Method m = cls.getDeclaredMethod(methodname);
						m.invoke(obj);
					}


				}

				Global.report.flush();
			}
	









	}

}
