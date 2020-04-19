package resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {

	public static WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		// gives project path. to avoid hardcode use this.
		// System.getProperty("user.dir")

		String probPath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties";
		String chromeDriverLocation = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		prop = new Properties();
		FileInputStream fis = new FileInputStream(probPath);

		prop.load(fis);

		// mvn test -Dbrowser=chrome

		// get browser as parameter
		String browserName = System.getProperty("browser");

		// get browser name from properties manually
		// String browserName = prop.getProperty("browser");

		// chrome

		if (browserName.contains("chrome")) {

			System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
			ChromeOptions options = new ChromeOptions();

			if (browserName.contains("headless")) {
				options.addArguments("headless"); // run without opening browser
			}

			driver = new ChromeDriver();

		}
		// firefox
		else if (browserName.equals("firefox")) {

		}

		// IE
		else if (browserName.equals("IE")) {

		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	public void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,
				new File(System.getProperty("user.dir") + "\\screenshots\\" + result + "_screenshot.png"));
	}

}
