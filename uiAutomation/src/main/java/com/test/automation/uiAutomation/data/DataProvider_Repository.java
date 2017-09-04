package com.test.automation.uiAutomation.data;

import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;

import com.test.automation.uiAutomation.testBase.TestBase;

public class DataProvider_Repository extends TestBase{

	@DataProvider(name = "Test Case Input Data")
	public String[][] Data(Method method){
		String data[][]=null;
		String testCaseName = method.getName();
		
		switch(testCaseName){
		
		case "VerifySuccessfulLogin":
			data = getData("Book1.xlsx","Sheet1");
			break;
		case "VerifyUnSuccessfulLogin":
			data = getData("Book1.xlsx","Sheet2");
			break;
		}
		return data;
	}
	
}
