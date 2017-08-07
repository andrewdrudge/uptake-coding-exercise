package andrewdrudge.uptake_coding_exercise.testmain;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import andrewdrudge.uptake_coding_exercise.pageobjects.UptakeAboutPage;
import andrewdrudge.uptake_coding_exercise.pageobjects.UptakeHomePage;

/**
 * Run the Uptake tests
 *
 */
public class RunTests {

	private static RemoteWebDriver driver;

	/**
	 * Initialize driver
	 */
	@BeforeClass
	public static void initialization() {
		String path = Thread.currentThread().getContextClassLoader().getResource("MicrosoftWebDriver.exe").getPath();
		System.setProperty("webdriver.edge.driver", path);
		driver = new EdgeDriver();
	}

	/**
	 * Kill the web driver.
	 */
	@AfterClass
	public static void cleanup() {
		driver.quit();
	}

	/**
	 * Tests the navigation between the home and about pages.
	 */
	@Test
	public void testHomePageAndAboutPageNavigation() {
		try {
			driver.get("https://uptake.com/");

			// Coding exercise - start state (home page).
			UptakeHomePage homePage = new UptakeHomePage(driver);

			// Coding exercise Step #1 - navigate from home page to about page.
			UptakeAboutPage aboutPage = homePage.navigateToAboutPage();

			// Coding exercise Step #2 - navigate from about page to home page.
			homePage = aboutPage.navigateToHomePage();
		} catch (IllegalStateException e) {
			Assert.fail("Test failed because a page was not able to be reached.  Exception message: " + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test failed unexpectedly outside of assertions.");
		}
	}
}