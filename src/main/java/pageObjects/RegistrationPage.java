package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BasePage {

	public WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lastName;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement e_Mail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement telephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement confirm_password;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement agree;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continue_button;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msg_confirmation;

	public void setFirstName(String fname) {
		firstName.sendKeys(fname);
	}

	public void setLastName(String lname) {
		lastName.sendKeys(lname);
	}

	public void setEmail(String email) {
		e_Mail.sendKeys(email);
	}

	public void setTelephone(String tel) {
		telephone.sendKeys(tel);
	}

	public void setPassword(String pw) {
		password.sendKeys(pw);
	}

	public void setConfPassword(String cpw) {
		confirm_password.sendKeys(cpw);
	}

	public void clickOnAgree() {
		agree.click();
	}

	public void clickContinueButton() {
		continue_button.click();
	}

	public String regMessageConfirmation() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			WebElement ele = wait.until(ExpectedConditions.visibilityOf(msg_confirmation));
			String mes = ele.getText();
			return mes;
		} catch (Exception e) {
			return (e.getMessage());
		}
	}
}
