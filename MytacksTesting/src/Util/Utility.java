package Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {
	
	
	public static String URL;
	public static String testingBrowser;// = "FF"; //IE , FF
	public static final String adminUserName = "Administrator";
	public static final String adminPassword = "123blue!";
	public enum testBrowser {FF, IE;}
	
	//method for creating webdriver based on web browser.
	public static WebDriver settingDriver(){
		WebDriver driver = null;
		switch(testBrowser.valueOf(testingBrowser)) {
		case FF:  
			driver = new FirefoxDriver();
			break;
		case IE: 
			File file = new File("C:\\SeleniumServer\\IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());  
			driver =  new InternetExplorerDriver(); 
			driver.manage().window().maximize();
			break;
		default:
		}
		return driver;
	}

	// This method is for handling each verification error while test case running
		public static void assertSoft (boolean success, String errMessage, 
				StringBuilder errorList, WebDriver driver, String fileName){
			if (!success) {
				errorList.append(errMessage + "\n");
			}
		}
		
		// This method is for final assert that test case has any failed verification
		// to mark test case is failed or passed
		public static void assertFinal (StringBuilder errorList) {
			// System.out.println(errorList.toString());
			try {
				Assert.assertTrue((errorList.length () == 1), errorList.toString());
			}catch (Exception e){
				e.toString();
			}
		}
		
		public static String getDateTime (){
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
			Date date = new Date();
			String currentTime = dateFormat.format(date);
			return currentTime;
		}
		

}
