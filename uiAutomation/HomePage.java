package page.object.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;

	@FindBy(linkText = "Chapter1")
	WebElement chapter1;

	@FindBy(linkText = "Chapter2")
	WebElement chapter2;

	@FindBy(linkText = "Chapter3")
	WebElement chapter3;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// Method-1.
	public ChapterFirstPage clickChapterFirst() {
		chapter1.click();
	
		return PageFactory.initElements(driver, ChapterFirstPage.class);
	}

	// Method-2.
	public ChapterSecondPage clickChapterSecond() {
		chapter2.click();
		return PageFactory.initElements(driver, ChapterSecondPage.class);
	}

	// Method-3.
	public void clickChapterThird() {
		chapter3.click();
	}
}
