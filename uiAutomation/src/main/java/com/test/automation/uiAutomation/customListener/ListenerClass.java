package com.test.automation.uiAutomation.customListener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.test.automation.uiAutomation.testBase.TestBase;

public class ListenerClass extends TestBase implements ITestListener {
	
	WebDriver driver;

	public void onTestStart(ITestResult result) {

	}

	public void onTestSuccess(ITestResult result) {
		
		Object currentClass = result.getInstance();
		driver = ((TestBase)currentClass).getDriver();
		String methodname = result.getName();
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yy-hh-mm-ss");

		if (result.isSuccess()) {
			File srcFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);

			try {
				String reportDirectory = new File(
						System.getProperty("user.dir"))
						+ "\\src\\main\\java\\com\\test\\automation\\uiAutomation\\screenShots";
				File destFile = new File((String) reportDirectory + "\\success\\" + methodname + "_" + formatter.format(calendar.getTime()) + ".png");
				FileUtils.copyFile(srcFile, destFile);
				// This will create link to image in testNG report
				Reporter.log("<a href='" + destFile + "'><img src='" + destFile
						+ "' width=100 height=100/></a>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void onTestFailure(ITestResult result) {

		String methodname = result.getName();
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yy-hh-mm-ss");

		if (!result.isSuccess()) {
			File srcFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);

			try {
				String reportDirectory = new File(
						System.getProperty("user.dir"))
						+ "\\src\\main\\java\\com\\test\\automation\\uiAutomation\\screenShots";
				File destFile = new File((String) reportDirectory + "\\failed\\" + methodname + "_" + formatter.format(calendar.getTime()) + ".png");
				FileUtils.copyFile(srcFile, destFile);
				// This will create link to image in testNG report
				Reporter.log("<a href='" + destFile + "'><img src='" + destFile
						+ "' width=100 height=100/></a>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}

}
