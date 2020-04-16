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

public class ValidateTitle extends Base {

	public static Logger log = LogManager.getLogger(ValidateTitle.class.getName());
	LandingPage l;
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver Initialized for ValidateTitle");
		driver.get(prop.getProperty("url"));
		log.info("Navigate to HomePage for ValidateTitle");
	}

	@Test
	public void validateAppTitle() throws IOException {

		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES1");
		log.info("FEATURED COURSES test message validated");
	}
	
	@Test
	public void validateHeader() throws IOException {

		Assert.assertEquals(l.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("Header test message validated");
	}
	

	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
	}

}
