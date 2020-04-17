package lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InitDriver {
	
	public static WebDriver driver;
	
	public static WebDriver getdriverinstance(String browsername)
	{
		if(driver==null)
		{
			if(browsername.contentEquals("CHROME"))
			{
				System.setProperty("webdriver.chrome.driver","/Volumes/Storage/Dashboards/JavaSelenium/chromedriver");
				
				 driver = new ChromeDriver();
			}
			else if (browsername.contentEquals("FIREFOX")) {
				
				
			}
		}
		else
		{
			System.out.println("Driver is not null");
		}
		return driver;
		
	}
	
	

}
