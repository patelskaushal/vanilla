package amazon.choices.page.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import amazon.choices.page.Page;

public class HomePage extends Page
{
	// Locators
	private final By hamburger = By.cssSelector("#nav-hamburger-menu");
	
	

	public HomePage(WebDriver webDriver)
	{
		super(webDriver);
	}
	
	 public void open (String url)
	 {
        this.getWebDriver().get(url);
	 }
	 
	 public void clickHambugerMenu()
	 {
		this.click(hamburger);
	 }
	 

}
