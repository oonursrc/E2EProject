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



public class Base {

	public static WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		String probPath = "C:\\Users\\z003srtv\\E2EProject\\src\\main\\java\\resources\\data.properties";
		String chromeDriverLocation = "C:\\Users\\z003srtv\\Documents\\SeleniumDocs\\chromedriver_win32\\chromedriver.exe";
		prop = new Properties();
		FileInputStream fis = new FileInputStream(probPath);

		//mvn test -Dbrowser=chrome
		
		// get browser as parameter
		String browserName= System.getProperty("browser");
		
		//get browser name from properties manually
		//String browserName = prop.getProperty("browser");
		
		
		// chrome

		if (browserName.equals("chrome") ) {

			System.setProperty("webdriver.chrome.driver", chromeDriverLocation);

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
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\z003srtv\\E2EProject\\screenshots\\"+result+"_screenshot.png"));
	}

}
