package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {
	public static Logger log = LogManager.getLogger(ValidateTitle.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver Initialized for HomePage");

	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String Username, String Password, String text) throws IOException {

		driver.get(prop.getProperty("url"));
		log.info("Navigate to HomePage for Login");

		LandingPage l = new LandingPage(driver);
		l.getLogin().click();

		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);

		System.out.println(text);

		lp.login().click();
		log.info("Login tried for username:" + Username + ", password:" + Password);
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		data[0][0] = "asd@asd.com";
		data[0][1] = "1234";
		data[0][2] = "Restricted User";

		data[1][0] = "qwerty@asd.com";
		data[1][1] = "9876";
		data[1][2] = "Non restricted User";

		return data;
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver=null;
	}

}
