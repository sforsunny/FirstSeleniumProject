package page.object.model;

import java.sql.Connection;
import java.sql.DriverManager;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
 
public class MyTests extends TestBase {
 
	// Test-0.
	@Test
	public void testPageObject() throws Exception {
 
		homePage = PageFactory.initElements(driver, HomePage.class);
 
		driver.get(baseUrl);
 
		chapterSecond = homePage.clickChapterSecond();
		chapterSecond.clickbut2();
		chapterSecond.clickRandom();
		String data = chapterSecond.getTest();
		homePage = chapterSecond.clickIndex();
 
		chapterFirstPage = homePage.clickChapterFirst();
		chapterFirstPage.clickSecondAjaxButton();
		chapterFirstPage.clickSecondAjaxButton1(data);
		chapterFirstPage.selectDropDown("Selenium Core");
		chapterFirstPage.verifyButton();
		
		WebDriverWait check = new WebDriverWait(driver, 100);
		check.until(ExpectedConditions.elementToBeClickable(element));
		driver.switchTo().frame(arg0)
	}
}
