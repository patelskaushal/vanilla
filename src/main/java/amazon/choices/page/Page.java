package amazon.choices.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Page 
{
	
private final WebDriver webDriver;

	public Page(WebDriver webDriver) 
	{
		this.webDriver = webDriver;
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}
	
	public void click(By by)
	{
		try
		{
			getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//highLightElement(by);
			getWebDriver().findElement(by).click();
		}
		catch(Exception e)
		{
			throw new RuntimeException("Issue clicking the element " + by);
		}
		
	}
	
	
	public void highLightElement(By elementBy) {
	    WebElement webElement = getWebDriver().findElement(elementBy);
	    String originalStyle = webElement.getAttribute("style");

	    JavascriptExecutor js = (JavascriptExecutor) getWebDriver(); 
	    js.executeScript
	    ("arguments[0].setAttribute(arguments[1], arguments[2]", webElement, "style", originalStyle + "border: 2px solid red;");

	    //Reset style
	    js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", webElement, "style", originalStyle);
	}
	
	public Select getSelectElement(By by)
	{
		try
		{
			return new Select(getWebDriver().findElement(by));
		}
		catch(Exception e)
		{
			log.error(e.getMessage());
			throw new RuntimeException("Issue locating the element " + by);
		}
	}
	

	/**
	 * @param by - by object of the element to be clicked.
	 * @param indexValue - text to be selected from dropDown
	 */
	public void selectElementByIndex(By by, int indexValue) 
	{
		try
		{
			Select selectElement = getSelectElement(by);
			
			selectElement.selectByIndex(indexValue);	
		}
		catch(Exception e)
		{
			throw new RuntimeException("Issue selecting the element " + by);
		}
	}

}
