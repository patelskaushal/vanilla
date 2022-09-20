package amazon.choices.page.items;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import amazon.choices.page.Page;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ItemsPage extends Page
{
	
	private final By aboutThisItem = By.cssSelector("#feature-bullets > h1");
	
	private final By aboutThisItemDetails = By.cssSelector("#feature-bullets > ul > li");

	public ItemsPage(WebDriver webDriver) 
	{
		super(webDriver);
	}
	
	public void verifyAboutThisItemIsPresent()
	{
		log.info("verifyAboutThisItemIsPresent");
		if (this.getWebDriver().findElement(aboutThisItem).isDisplayed() && 
				this.getWebDriver().findElement(aboutThisItem).isEnabled())
		{
			String expectedValue = "About this item";
			String text = this.getWebDriver().findElement(aboutThisItem).getText();
			log.info("About this item text: {}", text);
			assertEquals(expectedValue, text);
		}
	}
	
	public void printTheAboutThisItemSection()
	{
		log.info("printTheAboutThisItemSection");
		if (this.getWebDriver().findElement(aboutThisItemDetails).isDisplayed() && 
				this.getWebDriver().findElement(aboutThisItemDetails).isEnabled())
		{
			List<WebElement> elements = this.getWebDriver().findElements(aboutThisItemDetails);
			
			By elementsWithFixedTags = By.cssSelector("span");
			
			List<String> capturedText = new ArrayList<>();
			
			for(WebElement element: elements)
			{
				log.info(element.findElement(elementsWithFixedTags).getText());
			}
		}
	}

}
