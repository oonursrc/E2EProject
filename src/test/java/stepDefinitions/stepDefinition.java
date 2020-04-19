package stepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;

@RunWith(Cucumber.class)
public class stepDefinition extends Base {

	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		driver = initializeDriver();
	}

	@And("^Navigate to the \"([^\"]*)\" site$")
	public void navigate_to_the_something_site(String url) throws Throwable {
		driver.get(url);
	}

	@And("^Click on Login link in home page to land on secure sing in page$")
	public void click_on_login_link_in_home_page_to_land_on_secure_sing_in_page() throws Throwable {
		LandingPage l = new LandingPage(driver);
		if (l.getPopupSize().size() > 0) {
			l.getPopup().click();
		}
		l.getLogin().click();
	}

	@When("^User enters (.+) and (.+) and longs in$")
	public void user_enters_and_and_longs_in(String username, String password) throws Throwable {
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);

		lp.login().click();
	}

	@Then("^Verify that user is succesfully logged in$")
	public void verify_that_user_is_succesfully_logged_in() throws Throwable {
		System.out.println("SuccessDemo");
	}

}
