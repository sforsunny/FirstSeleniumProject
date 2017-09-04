package com.test.automation.uiAutomation.uiActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.test.automation.uiAutomation.testBase.TestBase;

public class HomePagePageFactory extends TestBase{

	@FindBy(id="txtUsername")
	WebElement username;
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement loginbtn;
	
	@FindBy(xpath="//*[@id='spanMessage']")
	WebElement invalidloginmessage;
	
	@FindBy(id="welcome")
	WebElement welcomeadminlink;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement logout;
	
	@FindBy(xpath="//div[(@id='branding')]//img")
	WebElement branding;
	
	@FindBy(xpath=".//*[@id='headertxt']/div[1]/div/a[2]")
	WebElement msg;
	
	WebDriver driver;
	//public static final Logger log = Logger.getLogger(HomePagePageFactory.class.getName());
	public HomePagePageFactory(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void loginToOrangeSite(String username, String password){
		//this keyword will fetch the global variable
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		loginbtn.click();
	}
	
	public String getInvalidLoginText(){
		return invalidloginmessage.getText();
	}
	
	public void clickOnWelcome(){
		welcomeadminlink.click();
	}
	
	public void logout(){
		
		clickOnWelcome();
		waitFor(driver,logout);
		logout.click();
	}
	
	public String getWelcomelink(){
		return welcomeadminlink.getText();
	}
	
	public void clickOnBranding(){

		branding.click();
	}
	
	public boolean verifyBrandNavMessag(){
		return msg.isDisplayed();
	}
}
