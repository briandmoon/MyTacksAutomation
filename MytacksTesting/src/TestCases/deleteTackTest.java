package TestCases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import TestCases.BaseTest;

import Util.Utility;
import Util.LoginPage;
import Util.homePage;

public class deleteTackTest extends BaseTest{

	
	@Parameters ({"stackName"})
	@Test (alwaysRun = true)
	public void test(@Optional("yahooo") String tackName) throws InterruptedException
	{
		StringBuilder errorTestResult = new StringBuilder("\n"); // this list will contain all error verifications
		String errorMess;
		
		LoginPage logInPage = PageFactory.initElements(driver, LoginPage.class);
		homePage homePage = PageFactory.initElements(driver, homePage.class);
		logInPage.adminLogIn("tester", "tester");
		
		
		//create tack
		homePage.createTackButton().click();
		homePage.tackNameTxt().sendKeys(tackName);
		homePage.tackDescTxt().sendKeys("testing");
		homePage.tackURLTxt().sendKeys("www.yahoo.com");
		homePage.createTackConfirm().click();
		
		//go to my tacks page
		homePage.myTacksButton().click();
		
		//delete tack
		homePage.deleteTackButton().click();
		
		//make an arraylist with all the titles of the tacks
		List<String> stuff = new ArrayList<String>();
		List<WebElement> allElements = driver.findElements(By.className("caption")); 
		for (int i=0;i<allElements.size();i++) 
		{
			stuff.add(allElements.get(i).getText());
		}
		
		errorMess = "tack was not deleted";
		//check whether tack with name 'tackName' is still there
		Utility.assertSoft (!homePage.tackCheck(stuff, tackName), errorMess, 
				errorTestResult, getDriver(), 
				this.getClass().getName() + "_" + Utility.getDateTime());
		Utility.assertFinal (errorTestResult);
		
	}
}
