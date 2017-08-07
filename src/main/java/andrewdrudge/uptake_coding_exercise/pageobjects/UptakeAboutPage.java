package andrewdrudge.uptake_coding_exercise.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Page Object for the About page (very primitive, due to no usage of
 * LoadableComponents)
 * 
 * @author Andrew
 *
 */
public class UptakeAboutPage {
	private RemoteWebDriver driver;

	public UptakeAboutPage(RemoteWebDriver driver) throws InterruptedException {
		this.driver = driver;

		// Uptake website is tricky, the navigation buttons exist on each page so
		// implicit/explicit waits both don't work
		// without an overly verbose solution, so I went for the simple approach:
		// Thread.sleep
		Thread.sleep(3000);

		if (!driver.getCurrentUrl().equals("https://uptake.com/about")) {
			throw new IllegalStateException(
					"This is not the About page (https://uptake.com/about).  The current page is: "
							+ driver.getCurrentUrl());
		}
	}

	/**
	 * Navigate to the Home page
	 * 
	 * @return the About page
	 * @throws InterruptedException
	 *             Compiler requirement due to Thread.sleep usage. Should never be
	 *             thrown.
	 */
	public UptakeHomePage navigateToHomePage() throws InterruptedException {
		driver.findElement(By.xpath("//*[@href='/'")).click();
		return new UptakeHomePage(driver);
	}
}
