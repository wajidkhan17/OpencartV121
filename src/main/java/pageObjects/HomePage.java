package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement my_account;

	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement register;

	public void clickMyAccount() {
		my_account.click();
	}

	public void clickRegister() {
		register.click();
	}
}
