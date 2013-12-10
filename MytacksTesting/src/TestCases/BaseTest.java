package TestCases;

import Util.LoginPage;
import Util.Utility;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;


// This class is create the setup test suite, setup for each test
// This is a super class
public class BaseTest {
	
	protected WebDriver driver;
	protected WebDriver driver2;
	LoginPage adminlogInPage;


	public WebDriver getDriver (){
		return driver;
	}
	@Parameters ({"Browser"})
	@BeforeSuite(alwaysRun = true)
	public void setupBeforeSuite (@Optional("FF") String sBrowser){	
		
		// Initializing the global / environment variables before testing
		Utility.testingBrowser = sBrowser;
		//*************************************************************************
		Utility.URL = "http://localhost/MyTacksSystem/"; //change if folder name is different
		//*************************************************************************
	}
	
	@AfterSuite
	public void processAfterSuite (){
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		driver = Utility.settingDriver(); 
		Thread.sleep(5000);
		driver.get(Utility.URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		// this method to handle the IE secure page before going to Reporter page
		//ReporterUtility.ForIESecurePage(driver);//ForIESecurePage(driver);
		if (Utility.testingBrowser.equals("FF"))
			driver.get("javascript:document.getElementById('overridelink').click();");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
