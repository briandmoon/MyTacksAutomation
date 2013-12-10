package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Util.LoginPage;
import Util.Utility;

public class LoginTest extends BaseTest{

	
	@Parameters ({"susername", "spassword"})
	@Test (alwaysRun = true)
	public void test(@Optional("tester") String username, @Optional("tester") String password) throws InterruptedException
	{
		StringBuilder errorTestResult = new StringBuilder("\n"); // this list will contain all error verifications
		String errorMess;
		
		//login using tester credentials
		LoginPage logInPage = PageFactory.initElements(driver, LoginPage.class);
		logInPage.adminLogIn(username, password);
		
		errorMess = "Login failed";
		
		//test whether we are still on login page
		Utility.assertSoft (!logInPage.isElementPresent(logInPage.loginTitle()), errorMess, 
				errorTestResult, getDriver(), 
				this.getClass().getName() + "_" + Utility.getDateTime());
		Utility.assertFinal (errorTestResult);
		
	}
	

}
