package amazon.choices.function;

import org.openqa.selenium.WebDriver;

import amazon.choices.page.PageFactory;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class SelectTelevisionFlow 
{
	
	private final WebDriver webDriver;
	
	private PageFactory pageFactory = new PageFactory();
	
	// Brands
	private static final String samsung = "Samsung";

	public SelectTelevisionFlow(WebDriver webDriver) 
	{
		this.webDriver = webDriver;
	}
	
	public void selectTelevisionSamsunng()
	{
		log.info("selectTelevision");
		this.pageFactory.getHomePage(webDriver).clickHambugerMenu();
		this.pageFactory.getMainMenu(webDriver).selectTvAndAppliances();
		this.pageFactory.getMainMenu(webDriver).selectTelevisions();
		this.pageFactory.getMainMenu(webDriver).selectFilterByBrand(samsung);
		this.pageFactory.getResultsPage(webDriver).selectFromSortDropDown("Price: High to Low");
		this.pageFactory.getResultsPage(webDriver).selectItemOnPage("3");
		this.pageFactory.getItemsPage(webDriver).verifyAboutThisItemIsPresent();
		this.pageFactory.getItemsPage(webDriver).printTheAboutThisItemSection();
	}

}
