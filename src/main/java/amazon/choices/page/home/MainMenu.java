package amazon.choices.page.home;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import amazon.choices.page.Page;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainMenu  extends Page
{
	// Main Menu
	private final By tvAndAppliances = By.cssSelector("#hmenu-content > ul.hmenu.hmenu-visible > li:nth-child(16) > a > div");
	private final By televisions = By.cssSelector("#hmenu-content > ul.hmenu.hmenu-visible.hmenu-translateX > li:nth-child(3) > a");
	
	
	// Filter Brands
	private final By brandsList = By.cssSelector("#s-refinements > div:nth-child(21) > ul > li");
	private final String brandCheckbox = "li:nth-child(%s) > span > a > div > label > i";
	private final String brandNameStr = "li:nth-child(%s) > span > a > span";
	

	public MainMenu(WebDriver webDriver) 
	{
		super(webDriver);
	}
		
	// Menu Selection
	public void selectTvAndAppliances()
	{
		log.info("selectTvAndAppliances");
		this.click(tvAndAppliances);
	}
	 
	// Menu under tvAndAppliances
	public void selectTelevisions()
	{
		log.info("selectTelevisions");
		this.click(televisions);
	}
	
	
	//Select filter 
	public void selectFilterByBrand(String brandNameToLocate)
	{
		log.info("selectFilterByBrand");
		
		List<WebElement> elements = this.getWebDriver().findElements(brandsList);
		
		for (int i = 0; i <= elements.size(); i++)
		{
			String brandToBefound = String.format(brandNameStr, i + 1);
			
			WebElement elementFound = elements.get(i).findElement(By.cssSelector(brandToBefound));
			
			if (elementFound.getText().equals(brandNameToLocate))
			{
				String filterToBeSelected = String.format(brandCheckbox, i + 1);
				
				elements.get(i).findElement(By.cssSelector(filterToBeSelected)).click();
				
				break;
			}
			else
			{
				if (i == elements.size() - 1)
				{
					log.error("Element not found");
					throw new RuntimeException("Element was not located");
				}
			}
		}
	}
	
}
