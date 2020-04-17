package lib;

import java.util.HashMap;
import java.util.Map;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

public class TestData {

	
	public static Map readTestData(String id, String classname,String methodname) throws FilloException
	{
		String query= "Select * from "+methodname+" where ID= "+id;
		String filename=Global.pathArtifacts+classname+"_TestData.xlsx";
		Recordset rd=Utility.getRecordUsingFillo(filename, query);
		HashMap m= new HashMap();
		while(rd.next())
		{
			for(int i=0;i<rd.getFieldNames().size();i++)
			{
				String colname=rd.getField(i).name();
				String colvalue=rd.getField(i).value();
				m.put(colname, colvalue);
			}
		}
		return m;
		
	}
	
	public static String getTestDataValue(String colName)
	{
		String value= (String) Global.gstrObjdataMap.get(colName.toUpperCase());
		//System.out.println(value);
		return value;
		
	}
}
