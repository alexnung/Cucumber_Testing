package shopping;

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

public class Test2 {
	
	private static WebDriver driver;
	private static String URL = "http://automationpractice.com/index.php";

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

	@Given("^I can open the store site$")
	public void i_can_open_the_store_site() throws InterruptedException {
		driver.get(URL);
		assertEquals("My Store", driver.getTitle());
	}

	@When("^I add dress to basket$")
	public void i_add_dress_to_basket() throws InterruptedException {
		WebElement addUser = driver.findElement(By.xpath("//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]"));
		addUser.click();
		assertEquals("Dresses - My Store", driver.getTitle());
		//body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/div[2]/a[1]/span[1]
		new WebDriverWait(driver, 5).until(ExpectedConditions
				.elementToBeClickable(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[2]/h5/a")));
		WebElement openDress = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[2]/h5/a"));
		openDress.click();
		WebElement addDress = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button"));
		addDress.click();
	}

	@When("^I checkout$")
	public void i_checkout() throws InterruptedException {
		new WebDriverWait(driver, 5).until(ExpectedConditions
				.elementToBeClickable(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a")));
	    WebElement basket = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a"));
	    basket.click();
	    WebElement checkout = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/p[2]/a[1]"));
	    checkout.click();
	}

	@When("^I create account$")
	public void i_create_account() throws InterruptedException {
		WebElement createEmail = driver.findElement(By.xpath("//input[@id='email_create']"));
		createEmail.sendKeys("test@yesy.com");
		createEmail.submit();
		Thread.sleep(5000);
	}

	@Then("^purchase is complete$")
	public void purchase_is_complete() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	}
	
}
