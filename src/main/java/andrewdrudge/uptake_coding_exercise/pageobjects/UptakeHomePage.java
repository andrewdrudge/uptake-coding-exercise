package andrewdrudge.uptake_coding_exercise.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Page Object for the Home page (very primitive, due to no usage of
 * LoadableComponents)
 * 
 * @author Andrew
 *
 */
public class UptakeHomePage {
	private RemoteWebDriver driver;

	public UptakeHomePage(RemoteWebDriver driver) throws InterruptedException {
		this.driver = driver;

		// Uptake website is tricky, the navigation buttons exist on each page so
		// implicit/explicit waits both don't work
		// without an overly verbose solution, so I went for the simple approach:
		// Thread.sleep
		Thread.sleep(3000);

		if (!driver.getCurrentUrl().equals("https://uptake.com/")) {
			throw new IllegalStateException(
					"This is not the Home page (https://uptake.com/).  The current page is: " + driver.getCurrentUrl());
		}
	}

	/**
	 * Navigate to the About page
	 * 
	 * @return the Home page
	 * @throws InterruptedException
	 *             Compiler requirement due to Thread.sleep usage. Should never be
	 *             thrown.
	 */
	public UptakeAboutPage navigateToAboutPage() throws InterruptedException {
		driver.findElement(By.xpath("//*[@href='/about'")).click();
		return new UptakeAboutPage(driver);
	}
}
