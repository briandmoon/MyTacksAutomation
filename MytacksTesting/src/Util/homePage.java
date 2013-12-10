package Util;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage {

	
final WebDriver driver;
	
	public homePage (WebDriver wDriver){
		this.driver = wDriver;
		
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

	
	@FindBy(linkText = "Contact")
	private WebElement ContactLink;
	public WebElement ContactLink() {
		return ContactLink;
	}
	
	
	//***********
	//Board Creation methods
	//***********
	@FindBy(partialLinkText = "Create Board")
	private WebElement createBoardButton;
	public WebElement createBoardButton() {
		return createBoardButton;
	}
	
	@FindBy(id = "boardname")
	private WebElement boardNameText;
	public WebElement boardNameText() {
		return boardNameText;
	}
	
	@FindBy(id = "boarddesc")
	private WebElement boardDescText;
	public WebElement boardDescText() {
		return boardDescText;
	}
	
	@FindBy(linkText = "Create")
	private WebElement boardButton;
	public WebElement boardButton() {
		return boardButton;
	}
	//*****************
	
	@FindBy(partialLinkText = "My Tacks")
	private WebElement myTacksButton;
	public WebElement myTacksButton() {
		return myTacksButton;
	}
	
	
	//********************
	//tack creation methods
	//********************
	@FindBy(css = "img")
	private WebElement createTackButton;
	public WebElement createTackButton() {
		return createTackButton;
	}
	
	@FindBy(id = "tackname")
	private WebElement tackNameTxt;
	public WebElement tackNameTxt() {
		return tackNameTxt;
	}
	
	@FindBy(id = "tackdesc")
	private WebElement tackDescTxt;
	public WebElement tackDescTxt() {
		return tackDescTxt;
	}
	
	@FindBy(id = "tackURL")
	private WebElement tackURLTxt;
	public WebElement tackURLTxt() {
		return tackURLTxt;
	}
	
	@FindBy(linkText = "Create")
	private WebElement createTackConfirm;
	public WebElement createTackConfirm() {
		return createTackConfirm;
	}
	
	//remove tack
	@FindBy(css= "span.glyphicon.glyphicon-remove")
	private WebElement deleteTackButton;
	public WebElement deleteTackButton() {
		return deleteTackButton;
	}
	
	@FindBy(className= "col-md-8")
	private WebElement noTacksMsg;
	public WebElement noTacksMsg() {
		return noTacksMsg;
	}
	
	public boolean tackCheck(List<String> stuff, String title)
	{
		for (int i=0;i<stuff.size();i++) {
			if(stuff.get(i).substring(0, stuff.get(i).indexOf("\n")).equals(title))
			{
				return true;
			}
		}
		return false;
	}
}
