package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.codoid.products.exception.FilloException;

import lib.Global;
import lib.TestData;
import lib.Utility;

public class MathAccountPage {
WebDriver driver;
	
	@FindBy(id="login_email")
	public WebElement edtAEmail;
	
	@FindBy(id="login_pass")
	public WebElement edtAPassword;
	
	
	
	public MathAccountPage() {
		driver = Utility.returndriver();
		PageFactory.initElements(driver, this);
	}
	
	//Business components
		public void account() throws FilloException, IOException {
			
			Global.gstrObjdataMap =TestData.readTestData(Global.gstrID, Global.gstrClassName, Global.gstrMethodName);
			System.out.println(Global.gstrObjdataMap);
			Utility.EnterText(edtAEmail, "Email", "AEmailSet");
			Utility.EnterText(edtAPassword, "password", "APasswordSet");
		}

}
