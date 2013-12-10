package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import TestCases.BaseTest;

import Util.Utility;
import Util.LoginPage;
import Util.registration;

public class registrationTest extends BaseTest{

	
	@Parameters ({"susername", "spassword"})
	@Test (alwaysRun = true)
	public void test(@Optional("testing") String username,
					 @Optional("testing") String password) throws InterruptedException
	{
		StringBuilder errorTestResult = new StringBuilder("\n"); // this list will contain all error verifications
		String errorMess;
		
		registration registrationPage = PageFactory.initElements(driver, registration.class);
		LoginPage logInPage = PageFactory.initElements(driver, LoginPage.class);
		
		//enter registration information
		logInPage.registerButton().click();
		registrationPage.usernameText().sendKeys(username);
		registrationPage.firstnameText().sendKeys("testing");
		registrationPage.lastnameText().sendKeys("testing");
		registrationPage.bdayText().sendKeys("1/1/2000");
		registrationPage.emailText().sendKeys("testing@gmail.com");
		registrationPage.secretQuesText().sendKeys("testing");
		registrationPage.secretAnsText().sendKeys("testing");
		registrationPage.passwordText().sendKeys(password);
		registrationPage.password_confirmationText().sendKeys(password);
		registrationPage.registerButton().click();
		
		//attempt to login
		logInPage.adminLogIn(username, password);
		
		errorMess = "User was not generated. Could not login";
		//check whether we are still on login page
		Utility.assertSoft (!logInPage.isElementPresent(logInPage.loginTitle()), errorMess, 
				errorTestResult, getDriver(), 
				this.getClass().getName() + "_" + Utility.getDateTime());
		Utility.assertFinal (errorTestResult);
		
	}
}
