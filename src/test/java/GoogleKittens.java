

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

public class GoogleKittens {
	private static WebDriver driver;
	private static String URL = "https://www.google.com/";

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

	@Given("^I can open Google$")
	public void i_can_open_Google() {
		driver.get(URL);
//		driver.get(URL + "/images");

		assertEquals("Google", driver.getTitle());

	}
	

	@When("^I search for Kittens$")
	public void i_search_for_kittens() throws InterruptedException {
		WebElement input = driver.findElement(By.name("q"));
		input.sendKeys("kittens");
		input.submit();
	}

	@Then("^Google will give me Kittens$")
	public void google_will_give_me_Kittens() throws InterruptedException {
		driver.findElement(By.name("q")).clear();
		new WebDriverWait(driver, 5).until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("div.hdtb-mitem:nth-child(2) > a:nth-child(1)")));
		WebElement kit = driver.findElement(By.cssSelector(".kno-ecr-pt > span:nth-child(1)"));
		
		assertEquals("Kitten", kit.getText());
	}

	@When("^I search for Puppies$")
	public void i_search_for_puppies() throws Throwable {
		WebElement input = driver.findElement(By.name("q"));
		input.sendKeys("Puppies");
		input.submit();

	}

	@Then("^Google will give me Puppies$")
	public void google_will_return_a_puppies_search() throws Throwable {
		driver.findElement(By.name("q")).clear();
		new WebDriverWait(driver, 5).until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("div.hdtb-mitem:nth-child(2) > a:nth-child(1)")));
		WebElement kit = driver.findElement(By.cssSelector(".kno-ecr-pt > span:nth-child(1)"));
		assertEquals("Puppy", kit.getText());

	}
	
}
