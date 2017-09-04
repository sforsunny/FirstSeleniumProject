package com.test.automation.uiAutomation.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.uiAutomation.excelReader.ExcelReader;
import com.test.automation.uiAutomation.config.Log;


public class TestBase {

	public WebDriver driver;
	Properties OR;
	// public EventFiringWebDriver driver;
	// public WebEventListenerClass eventlistener;
	//String url = "http://opensource.demo.orangehrmlive.com";
	//String browser = "chrome";

	public WebDriverWait wait;
	public static ExtentReports extent;
	public static ExtentTest test;
	//public static final Logger log = Logger.getLogger(TestBase.class.getName());
	
	ExcelReader excel;
	

	public WebDriver getDriver() {
		return driver;
	}
	
	static{
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yy-hh-mm-ss");
		extent = new ExtentReports((System.getProperty("user.dir")+"\\src\\main\\java\\com\\test\\automation\\uiAutomation\\reports\\Execution Report"+formatter.format(calendar.getTime())+".html"),false);
		extent	.addSystemInfo("param1", "value1")
		  		.addSystemInfo("Host Name", "SoftwareTestingMaterial")
		  		.addSystemInfo("Environment", "Automation Testing")
		  		.addSystemInfo("User Name", "Umesh");
		//extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
}

	public void loadDataFromPropertiesFile() throws IOException{
		Log.info("Executing: loadDataFromPropertiesFile method ");
		OR = new Properties();
		File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\test\\automation\\uiAutomation\\config\\configuration.properties");
		FileInputStream fis = new FileInputStream(file);
		OR.load(fis);
	}
	
	public void init() throws IOException {
		PropertyConfigurator.configure("log4j.properties");
		loadDataFromPropertiesFile();
		setup(OR.getProperty("browser"));
		getURL(OR.getProperty("url"));
		
	}

	public void setup(String b) {
		if (b.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")
							+ "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver(options);
			// driver = new EventFiringWebDriver(dr);
			// eventlistener = new WebEventListenerClass();
			// driver.register(eventlistener);
		}
	}

	public void getURL(String u) {
		driver.manage().window().maximize();
		driver.get(u);
	}

	public String[][] getData(String excelName, String sheetName) {
		String path = System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\test\\automation\\uiAutomation\\data\\"
				+ excelName;
		excel = new ExcelReader(path);
		String data[][] = excel.getDataFromSheet(excelName, sheetName);
		return data;
	}

	public String getScreenShot(String filename) {
		if (filename==""){
			filename="blank";
		}
		File destFile = null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yy-hh-mm-ss");

		File srcFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);

		try {
			String reportDirectory = new File(System.getProperty("user.dir"))
					+ "\\src\\main\\java\\com\\test\\automation\\uiAutomation\\screenShots\\";
			destFile = new File((String) reportDirectory + filename + "_"
					+ formatter.format(calendar.getTime()) + ".png");
			FileUtils.copyFile(srcFile, destFile);
			// This will create link to image in testNG report
			Reporter.log("<a href='" + destFile + "'><img src='" + destFile
					+ "' width=100 height=100/></a>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destFile.toString();
		
	}

	public void waitFor(WebDriver d, WebElement w) {
		wait = new WebDriverWait(d, 30);
		wait.until(ExpectedConditions.visibilityOf(w));
	}
	

	

	
	@BeforeMethod
	public void beforeMethod(Method method){
	test = extent.startTest(method.getName());
	test.log(LogStatus.INFO,method.getName()+" method/TC started" );
	Log.startTestCase(method.getName());
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result, Method m){
		getResult(result);
		Log.endTestCase(m.getName());
	}
	
	public void getResult(ITestResult result){
		if(result.getStatus()==ITestResult.SUCCESS){
			test.log(LogStatus.PASS, result.getName()+" TC is passed");
			//test.log(LogStatus.PASS, test.addScreenCapture(getScreenShot("")));
					}
		else if(result.getStatus()==ITestResult.FAILURE){
			test.log(LogStatus.ERROR, result.getName()+" TC is failed "+ result.getThrowable());
		}
	}
	
	@AfterClass(alwaysRun=true)
	public void endTest(){
		driver.quit();
		extent.endTest(test);
		extent.flush();
	}
}
