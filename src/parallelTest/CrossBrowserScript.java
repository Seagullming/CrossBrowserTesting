package parallelTest;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.edge.EdgeDriver;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.util.Date;
import java.text.SimpleDateFormat;

public class CrossBrowserScript {
	WebDriver driver;
	String _browser = "";

	@BeforeTest
	@Parameters("browser")

	public void setup(String browser) throws Exception {

		_browser = browser;
		if (browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\dev\\Desktop\\TestingDriver\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}

		else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\dev\\Desktop\\TestingDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.firefox.marionette",
					"C:\\Users\\dev\\Desktop\\TestingDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else {
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test

	public void TakeScreenshot() throws Exception {

		driver.get("https://dsc.littlemonkey.info/");

		// Call take screenshot function
		Date d = new Date();
		System.out.println(d.toString());
		
		SimpleDateFormat sdf= new SimpleDateFormat("yyy-MM-dd HH-mm-ss");
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:\\Users\\dev\\Desktop\\Test Material\\"+sdf.format(d)+_browser+".jpg"));
	}



}
