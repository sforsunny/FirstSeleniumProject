package page.object.model;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
 
public class TestBase {
 
	protected WebDriver driver;
	protected String baseUrl;
	protected HomePage homePage;
	protected ChapterSecondPage chapterSecond;
	protected ChapterFirstPage chapterFirstPage;
 
	// Method-1.
	@BeforeSuite
	public void setUp() {
		baseUrl = "http://book.theautomatedtester.co.uk/";
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 
	}
 
	// Method-2.
	@AfterSuite
	public void tearDown() throws Exception {
		driver.quit();
 
	}
}