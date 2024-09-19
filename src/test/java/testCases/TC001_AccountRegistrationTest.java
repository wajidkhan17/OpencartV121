package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test
	public void verifyAccountRegistration() {
		logger.info("**** Strating test case TC0001 ****");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on my account link");
			hp.clickRegister();
			logger.info("Clicked on my registration link");
			RegistrationPage rp = new RegistrationPage(driver);
			logger.info("providing customer details");
			rp.setFirstName(randomString().toUpperCase());
			rp.setLastName(randomString().toUpperCase());
			rp.setEmail(randomString() + "@gmail.com");
			rp.setTelephone(randomNum());
			String password = randomAlphaNumeric();
			rp.setPassword(password);
			rp.setConfPassword(password);
			rp.clickOnAgree();
			rp.clickContinueButton();
			logger.info("validating expected message");
			String conf_message = rp.regMessageConfirmation();
			if (conf_message.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			} else {
				logger.error("Test failed....");
				logger.debug("debug logs....");
				Assert.fail();
			}
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("**** Finished TC0001 ****");
	}
}
