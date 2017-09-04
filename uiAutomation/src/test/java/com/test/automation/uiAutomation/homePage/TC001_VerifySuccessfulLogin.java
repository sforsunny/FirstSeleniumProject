package com.test.automation.uiAutomation.homePage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.config.Log;
import com.test.automation.uiAutomation.data.DataProvider_Repository;
import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.HomePagePageFactory;

public class TC001_VerifySuccessfulLogin extends TestBase{
	
	//public static final Logger log = Logger.getLogger(TC005_VerifyWithTestBaseClass_WithExcel.class.getName());

	HomePagePageFactory homepage;
	
	@BeforeClass
	public void setup() throws IOException{
		init();

//debug<info<warn<error<fatal in log4j.properties file, whichever element we give among these, 
		//statements will be executed bases on this hierarchy level so if ERROR is given, then log.error and log.fatal
		//will be executed
	}
	
	@Test (dataProviderClass=DataProvider_Repository.class,dataProvider="Test Case Input Data",priority=1)
	public void VerifySuccessfulLogin(String u, String p, String run){
		if(run.equalsIgnoreCase("y")){
		//Log.startTestCase("VerifySuccessfulLogin");
		homepage = new HomePagePageFactory(driver);
		homepage.loginToOrangeSite(u,p);
		Assert.assertEquals(homepage.getWelcomelink(), "Welcome Admin");
		homepage.logout();
		//Log.endTestCase("VerifySuccessfulLogin");
		}
		if(run.equalsIgnoreCase("n")){
			System.out.println("test case not run");
		}
	}
	
	@Test (dataProviderClass=DataProvider_Repository.class,dataProvider="Test Case Input Data",priority=2)
	public void VerifyUnSuccessfulLogin(String u, String p, String run){
		if(run.equalsIgnoreCase("y")){
		//Log.startTestCase("VerifySuccessfulLogin");
		homepage = new HomePagePageFactory(driver);
		homepage.loginToOrangeSite(u,p);
		Assert.assertEquals(homepage.getWelcomelink(), "Welcome Admin");
		homepage.logout();
		//Log.endTestCase("VerifySuccessfulLogin");
		}
		if(run.equalsIgnoreCase("n")){
			System.out.println("test case not run");
		}
	}
}
