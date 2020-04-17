package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.codoid.products.exception.FilloException;

import lib.Global;
import lib.TestData;
import lib.Utility;

public class MathHomePage {

	WebDriver driver;
	
	@FindBy(xpath="(//a[text()='My Account'])[1]")
	public WebElement acctLink;
	
	@FindBy(xpath="(//a[text()='Email Sign-up'])[1]")
	public WebElement lnkHMEmailSignup;
	
	public MathHomePage()
	{
		driver=Utility.returndriver();
		PageFactory.initElements(driver, this);
	}
	
	public void home() throws FilloException, InterruptedException
	{
		Global.gstrObjdataMap=TestData.readTestData(Global.gstrID,Global.gstrClassName,Global.gstrMethodName);
		driver.get(Global.gstrAppURL);
		Thread.sleep(1000);
		
		Utility.clickElement(acctLink,"My Account", "HMyAccountClick");
		
		
		
	}
	
	
}
