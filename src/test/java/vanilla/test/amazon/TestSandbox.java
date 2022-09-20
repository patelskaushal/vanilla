package vanilla.test.amazon;

import amazon.choices.function.SelectTelevisionFlow;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestSandbox extends AbstractBaseTest
{
	private SelectTelevisionFlow selectTelevisionFlow = new SelectTelevisionFlow(getWebDriver());
	
	
	@Tag("smokeTest")
	@DisplayName("This test is for demo purpose only to show that the basic code works."
			+ "You have to use the best practices that you normally use to design your tests")
	@Test
	void assertThatHomePageTitleIsCorrect() {
		getWebDriver().get(HOME_PAGE_URL);
		assertEquals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", getWebDriver().getTitle());
	}
	
	@Test
	void assertAboutThisItem()
	{
		getWebDriver().get(HOME_PAGE_URL);
		selectTelevisionFlow.selectTelevisionSamsunng();
	}

}
