package vanilla.test.amazon;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;

import com.typesafe.config.Config;

import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;

public class AbstractBaseTest 
{
	private static Config config = EnvFactory.getInstance().getConfig();
	public static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");

	private WebDriver driver;
	
	public WebDriver getWebDriver()
	{
		if (driver == null)
		{
			driver = DriverFactory.getDriver();
		}
		
		return this.driver;
	}
	
	
	@AfterEach
	public void cleanUp()
	{
		driver.quit();
	}
}
