package Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class registration {

final WebDriver driver;
	
	public registration (WebDriver wDriver){
		this.driver = wDriver;
	}
	
	@FindBy(name = "username")
	private WebElement usernameText;
	public WebElement usernameText() {
		return usernameText;
	}
	
	@FindBy(name = "firstname")
	private WebElement firstnameText;
	public WebElement firstnameText() {
		return firstnameText;
	}
	
	@FindBy(name = "lastname")
	private WebElement lastnameText;
	public WebElement lastnameText() {
		return lastnameText;
	}
	
	@FindBy(name = "bday")
	private WebElement bdayText;
	public WebElement bdayText() {
		return bdayText;
	}
	
	@FindBy(name = "email")
	private WebElement emailText;
	public WebElement emailText() {
		return emailText;
	}
	
	@FindBy(name = "secretQues")
	private WebElement secretQuesText;
	public WebElement secretQuesText() {
		return secretQuesText;
	}
	
	@FindBy(name = "secretAns")
	private WebElement secretAnsText;
	public WebElement secretAnsText() {
		return secretAnsText;
	}
	
	@FindBy(name = "password")
	private WebElement passwordText;
	public WebElement passwordText() {
		return passwordText;
	}
	
	@FindBy(name = "password_confirmation")
	private WebElement password_confirmationText;
	public WebElement password_confirmationText() {
		return password_confirmationText;
	}
	
	@FindBy(partialLinkText = "Register")
	private WebElement registerButton;
	public WebElement registerButton() {
		return registerButton;
	}
	
	
	
}
