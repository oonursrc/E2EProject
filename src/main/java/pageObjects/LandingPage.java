package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	
	private By signin= By.cssSelector("a[href*='sign_in']");
	private By title= By.cssSelector(".text-center>h2");
	private By navbar= By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	private By header= By.cssSelector("div[class*='video-banner']h3");
	private By popup= By.xpath("//button[text()='NO THANKS']");
	

	public WebElement getLogin() {
		return driver.findElement(signin);
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement getNavigationbar() {
		return driver.findElement(navbar);
	}
	
	public WebElement getHeader() {
		return driver.findElement(header);
	}
	
	public WebElement getPopup() {
		return driver.findElement(popup);
	}
	public List<WebElement> getPopupSize() {
		return driver.findElements(popup);
	}

}
