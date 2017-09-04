package com.test.automation.uiAutomation.uiActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageNormal {

	WebDriver driver;
	
	public HomePageNormal(WebDriver driver){
		this.driver=driver;
	}
	

	public void loginToOrangeSite(String uname, String pass){
		driver.findElement(By.id("txtUsername")).sendKeys(uname);
		driver.findElement(By.id("txtPassword")).sendKeys(pass);
		driver.findElement(By.id("btnLogin")).click();
	}
	
	public String getInvalidLoginText(){
		return driver.findElement(By.xpath("//*[@id='spanMessage']")).getText();
	}
}
