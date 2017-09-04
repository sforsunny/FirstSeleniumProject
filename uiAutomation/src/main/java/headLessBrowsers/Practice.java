package headLessBrowsers;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.sun.jna.platform.FileUtils;

public class Practice {

	WebDriver driver;
	
	public void linkClick() throws Exception{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation Practice\\Automation Practice\\uiAutomation\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://artoftesting.com/sampleSiteForSelenium.html");
		driver.findElement(By.linkText("This is a link")).click();
		System.out.println("link clicked");
		Thread.sleep(5000);
		driver.findElement(By.partialLinkText("This is"));
		Thread.sleep(5000);
		System.out.println("link clicked");
		driver.close();
	}
	
	public void mouseActions() throws Exception{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation Practice\\Automation Practice\\uiAutomation\\chromedriver.exe");
		driver = new ChromeDriver();
		
		/*System.setProperty("webdriver.gecko.driver", "D:\\Automation Practice\\Automation Practice\\uiAutomation\\geckodriver.exe");
		driver = new FirefoxDriver();*/
		driver.manage().window().maximize();
		
		driver.get("http://artoftesting.com/sampleSiteForSelenium.html");
/*		WebElement w = driver.findElement(By.id("dblClkBtn"));
		Actions builder = new Actions(driver);
		
		WebElement hover = driver.findElement(By.id("idOfButton"));
		//mouse hover
		builder.moveToElement(hover).perform();
		String tooltiptext = driver.findElement(By.id("idOfButton")).getAttribute("title");
		System.out.println("Mouse hover text is "+tooltiptext);
		Thread.sleep(5000);
		
		//right click
		builder.contextClick(w).perform();
		System.out.println("Right clicked");
		Thread.sleep(5000);
		
		//double click
		builder.doubleClick(w).perform();
		System.out.println("Double clicked");
		Thread.sleep(5000);*/
		
		//Drag and drop
	
		WebElement source = driver.findElement(By.id("sourceImage"));
		
		WebElement target = driver.findElement(By.id("targetDiv"));
		
		Actions builder = new Actions(driver);
		//Action dragndrop = 	
							builder.clickAndHold(source)
							.moveToElement(target).perform();
		Thread.sleep(5000);
		builder.release(target)
							.build().perform();;
		//dragndrop.perform();
		System.out.println("drag and drop");
		Thread.sleep(5000);
		
		driver.quit();
	}
	
/*	public void alert() throws Exception{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation Practice\\Automation Practice\\uiAutomation\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://artoftesting.com/sampleSiteForSelenium.html");
		driver.findElement(By.xpath("//*[@id='AlertBox']/button")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(5000);
		alert.accept();
		System.out.println("alert accepted");
		
		driver.findElement(By.xpath("//*[@id='AlertBox']/button")).click();
		alert.dismiss();
		
		File fs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		org.apache.commons.io.FileUtils.copyFile(srcFile, destFile);
		
		Thread.sleep(5000);
		System.out.println("alert dismissed");
		driver.get(driver.getCurrentUrl());
		
		driver.quit();

	}*/
	
	
	public static void main(String[] args) throws Exception {
		Practice practice = null;
		Method[] m = practice.getClass().getMethods();

	}

}
