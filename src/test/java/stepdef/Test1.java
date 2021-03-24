package stepdef;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test1 {
	private static WebDriver driver;
	private static String URL = "http://thedemosite.co.uk/";

	@Before
	public static void init() {
		System.setProperty("webdriver.chrome.driver",
				"src/test/resources/drivers/chromedriver-89-4280/chromedriver.exe");
		ChromeOptions cOptions = new ChromeOptions();
		cOptions.setHeadless(false);
		cOptions.setCapability("profile.default_content_setting_values.cookes", 2);
		cOptions.setCapability("network.cookie.cookieBehavior", 2);
		cOptions.setCapability("profiles.block_third_party_cookies", true);
		driver = new ChromeDriver(cOptions);
		driver.manage().window().setSize(new Dimension(1366, 768));
	}

	@After
	public void cleanUp() {
		driver.quit();
	}

	@Given("^I can open the demo site$")
	public void i_can_open_the_demo_site() throws InterruptedException {
		driver.get(URL);
		assertEquals("FREE example PHP code and online MySQL database - example username password protected site", driver.getTitle());
		// Write code here that turns the phrase above into concrete actions
	}

	@When("^I signup Test1 Test1$")
	public void i_signup_test1_test1() throws InterruptedException {
		WebElement addUser = driver.findElement(By.xpath("//a[contains(text(),'3. Add a User')]"));
		addUser.click();
		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		assertEquals("Add a user - FREE PHP code and SQL", driver.getTitle());
		username.sendKeys("test1");
		password.sendKeys("test1");
		password.submit();
	}

	@Then("^login successfully Test1 Test1$")
	public void login_successfully_test1() throws InterruptedException {
		WebElement login = driver.findElement(By.xpath("//a[contains(text(),'4. Login')]"));
		login.click();
		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		assertEquals("Login example page to test the PHP MySQL online system", driver.getTitle());
		username.sendKeys("test1");
		password.sendKeys("test1");
		password.submit();
		Thread.sleep(2000);
	}
	
	@When("^I signup Test2 Test2$")
	public void i_signup_test2_test2() throws InterruptedException {
		WebElement addUser = driver.findElement(By.xpath("//a[contains(text(),'3. Add a User')]"));
		addUser.click();
//		WebElement username = new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		assertEquals("Add a user - FREE PHP code and SQL", driver.getTitle());
		username.sendKeys("test2");
		password.sendKeys("test2");
		password.submit();
	}

	@Then("^login successfully Test2 Test2$")
	public void login_successfully_test2_test2() throws InterruptedException {
		WebElement login = driver.findElement(By.xpath("//a[contains(text(),'4. Login')]"));
		login.click();
		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		assertEquals("Login example page to test the PHP MySQL online system", driver.getTitle());
		username.sendKeys("test2");
		password.sendKeys("test2");
		password.submit();
		Thread.sleep(2000);
	}

}
