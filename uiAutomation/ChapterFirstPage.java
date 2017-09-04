package page.object.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class ChapterFirstPage {
	private WebDriver driver;

	@FindBy(id = "secondajaxbutton")
	WebElement secondajax;

	@FindBy(xpath = "//select[@id='selecttype']")
	WebElement dropdown;

	@FindBy(id = "verifybutton")
	WebElement verifybutton;

	public ChapterFirstPage(WebDriver driver) {
		this.driver = driver;
	}

	// Method-1.
	public ChapterFirstPage clickSecondAjaxButton() {
		secondajax.click();
		return PageFactory.initElements(driver, ChapterFirstPage.class);
	}

	// Method-2.
	public ChapterFirstPage clickSecondAjaxButton1(String data1) {
		System.out.println(data1);
		return PageFactory.initElements(driver, ChapterFirstPage.class);
	}

	// Method-3.
	public ChapterFirstPage selectDropDown(String value) {
		new Select(dropdown).selectByVisibleText(value);
		return PageFactory.initElements(driver, ChapterFirstPage.class);
	}

	// Method-4.
	public ChapterFirstPage verifyButton() {
		verifybutton.click();
		return PageFactory.initElements(driver, ChapterFirstPage.class);
	}
}
