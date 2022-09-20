package amazon.choices.page;

import org.openqa.selenium.WebDriver;

import amazon.choices.page.home.HomePage;
import amazon.choices.page.home.MainMenu;
import amazon.choices.page.items.ItemsPage;
import amazon.choices.page.results.ResultsPage;

public class PageFactory 
{
	
	
	public HomePage getHomePage(WebDriver webDriver) 
	{
		return new HomePage(webDriver);
	}
	
	public MainMenu getMainMenu(WebDriver webDriver)
	{
		return new MainMenu(webDriver);
	}
	

	public ResultsPage getResultsPage(WebDriver webDriver)
	{
		return new ResultsPage(webDriver);
	}
	
	
	public ItemsPage getItemsPage(WebDriver webDriver)
	{
		return new ItemsPage(webDriver);
	}
	
}
