package TestCases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import TestCases.BaseTest;

import Util.Utility;
import Util.LoginPage;
import Util.homePage;
import Util.registration;

public class test extends BaseTest{

	
	@Parameters ({"sboardName"})
	@Test (alwaysRun = true)
	public void test(@Optional("the best") String boardName) throws InterruptedException
	{
		StringBuilder errorTestResult = new StringBuilder("\n"); // this list will contain all error verifications
		String errorMess;
		
		//create instances of pages
		LoginPage logInPage = PageFactory.initElements(driver, LoginPage.class);
		homePage homePage = PageFactory.initElements(driver, homePage.class);
		
		//login
		logInPage.adminLogIn("tester", "tester");
		
		//create board
		homePage.createBoardButton().click();
		homePage.boardNameText().sendKeys(boardName);
		homePage.boardDescText().sendKeys("testing board");
		homePage.boardButton().click();
		
		homePage.deleteTackButton().click();
		
		//create list of all boards for comparison
		List<String> stuff = new ArrayList<String>();
		List<WebElement> allElements = driver.findElements(By.className("caption")); 
		for (int i=0;i<allElements.size();i++) 
		{
			stuff.add(allElements.get(i).getText());
		}
		
		errorMess = "Board was not deleted";
		//check whether board with name boardName is in list. 
		Utility.assertSoft (!homePage.tackCheck(stuff, boardName), errorMess, 
				errorTestResult, getDriver(), 
				this.getClass().getName() + "_" + Utility.getDateTime());
		Utility.assertFinal (errorTestResult);
		
	}
}
