package parallelTest;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.edge.EdgeDriver;

public class CrossBrowserScript {
	WebDriver driver;

	@BeforeTest
	@Parameters("browser")

	public void setup(String browser) throws Exception {

		if (browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\dev\\Desktop\\TestingDriver\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}

		else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\dev\\Desktop\\TestingDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if (browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.firefox.marionette", "C:\\Users\\dev\\Desktop\\TestingDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		

		else {
			throw new Exception("Browser is not correct");
		}
		
	}

	@Test
	public void testParameterWithXML() throws InterruptedException {
		driver.get("https://dsc.littlemonkey.info/");
	}

}
