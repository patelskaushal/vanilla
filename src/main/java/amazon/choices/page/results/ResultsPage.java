package amazon.choices.page.results;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.gargoylesoftware.htmlunit.javascript.host.Window;
import com.google.common.collect.ImmutableMap;
import com.google.common.graph.ImmutableNetwork;

import amazon.choices.page.Page;


public class ResultsPage extends Page
{
	
	private final By sortByDropDown = By.cssSelector("#s-result-sort-select");
	
	private final String itemLocator = "div.s-main-slot.s-result-list.s-search-results.sg-row > div:nth-child(%s)";

	
	
	private final ImmutableMap<String, Integer> sortByValues = ImmutableMap.of(
			"Featured", 0, 
			"Price: Low to High", 1, 
			"Price: High to Low", 2, 
			"Avg. Customer Reviw", 3, 
			"Newest Arrivals", 4);
	
	public ResultsPage(WebDriver webDriver) 
	{
		super(webDriver);
	}
	
	
	public void selectFromSortDropDown(String valueToBeSelected)
	{
		this.selectElementByIndex(sortByDropDown, sortByValues.get(valueToBeSelected));
	}
	
	
	/**
	 * Select nth item on result Page
	 * @param nthItemOnPage
	 */
	public void selectItemOnPage(String nthItemOnPage)
	{
		By itemOnPage;
		try
		{
			itemOnPage = By.cssSelector(String.format(itemLocator, nthItemOnPage));
			
			String firstWindow = this.getWebDriver().getWindowHandle();
		
			this.click(itemOnPage);
			
			while (this.getWebDriver().getWindowHandles().size() == 1)
			{
				this.getWebDriver().wait(2000L);
			}
			
			for (String anyWindow :this.getWebDriver().getWindowHandles())
			{
				if (!firstWindow.equals(anyWindow))
				{
					String secondWindow = anyWindow;
					
					this.getWebDriver().switchTo().window(secondWindow);				}
			}
		}
		catch(Exception e)
		{
			new RuntimeException("Some problem in locating item " + nthItemOnPage, e);
		}
	}
	
	
	public void getAboutUs()
	{
		
		
		
	}

	
}
