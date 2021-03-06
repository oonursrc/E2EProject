package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateNavigationBar extends Base {

	public static Logger log = LogManager.getLogger(ValidateTitle.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver Initialized for ValidateNavigationBar");
		driver.get(prop.getProperty("url"));
		log.info("Navigate to HomePage for ValidateNavigationBar");
	}

	@Test
	public void validateNavBar() throws IOException {
		LandingPage l = new LandingPage(driver);

		Assert.assertTrue(l.getNavigationbar().isDisplayed());
		log.info("Navigationbar validated");

	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
	}

}
