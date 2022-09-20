package vanilla.test.amazon;
import amazon.choices.function.SelectTelevisionFlow;
import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;
import com.typesafe.config.Config;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.junit.platform.runner.JUnitPlatform;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;

//@RunWith(JUnitPlatform.class)
public class TestSandbox extends AbstractBaseTest
{
	
	private WebDriver driver = DriverFactory.getDriver();
	private SelectTelevisionFlow selectTelevisionFlow = new SelectTelevisionFlow(driver);
	
	
	@Tag("smokeTest")
	@DisplayName("This test is for demo purpose only to show that the basic code works."
			+ "You have to use the best practices that you normally use to design your tests")
	@Test
	void assertThatHomePageTitleIsCorrect() {
		driver.get(HOME_PAGE_URL);
		assertEquals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", driver.getTitle());
	}
	
	@Test
	void assertAboutThisItem()
	{
		driver.get(HOME_PAGE_URL);
		selectTelevisionFlow.selectTelevision();
	}
	

}
