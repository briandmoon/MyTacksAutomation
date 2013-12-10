package Util;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	final WebDriver driver;
	
	public LoginPage (WebDriver wDriver){
		this.driver = wDriver;
		//this.driver = PageFactory.initElements(wDriver, ReporterLoginPage.class);
	}
	/**
	 * @param args
	 * @return 
	 */
	
	@FindBy(name = "username")
	private WebElement userNameTxt;

	@FindBy(name = "password")
	private WebElement passwordTxt;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement LoginBtn;
	
	@FindBy(className = "sign-up-title")
	private WebElement loginTitle;
	public WebElement loginTitle() {
		return loginTitle;
	}
	
	@FindBy(partialLinkText = "Register")
	private WebElement registerButton;
	public WebElement registerButton() {
		return registerButton;
	}
	
	// clear and send text to User Name text field
		public void enterUsername (String userName){
			userNameTxt.clear();
			userNameTxt.sendKeys(userName);
		}
		
		// clear and send text to UPassword text field
		public void enterPassword (String userPwd){
			passwordTxt.clear();
			passwordTxt.sendKeys(userPwd);
		}
		
		// click on SignIn button
		public void clickSignInBtn (){
			LoginBtn.click();
		}
		
		public boolean isElementPresent(WebElement by) { 
			try{
				by.getText();
			   return true;
			}
			catch(NoSuchElementException e)
			{
				return false;
			}
		}
		
	public void adminLogIn(String userName, String userPwd) throws InterruptedException //throws InterruptedException
	{
		enterUsername(userName);
		enterPassword(userPwd);
		clickSignInBtn();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//return PageFactory.initElements(driver, AdministratorPage.class);
	}
	

}
