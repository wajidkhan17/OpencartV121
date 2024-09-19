package testBase;
import java.time.Duration;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class BaseClass {
	
	public WebDriver driver;
	public Logger logger;
	
	@BeforeClass
	public void setup() {
		logger = LogManager.getLogger(this.getClass());
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().window().maximize();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public String randomString() {
		String generated_string = RandomStringUtils.randomAlphabetic(7);
		return generated_string;
	}

	public String randomNum() {
		String generated_int = RandomStringUtils.randomNumeric(10);
		return generated_int;
	}

	public String randomAlphaNumeric() {
		String generated_string = RandomStringUtils.randomAlphabetic(7);
		String generated_int = RandomStringUtils.randomNumeric(10);
		return (generated_string + "@" + generated_int);
	}
}
