package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.Helper;

public class TestBase2 {
	
	public static String BaseURL = "http://demo.nopcommerce.com" ; 

	protected ThreadLocal<RemoteWebDriver> driver = null ; 

	@BeforeTest
	@Parameters({"browser"})
	public void setUp(@Optional("chrome") String browser) throws MalformedURLException 
	{
		driver = new ThreadLocal<RemoteWebDriver>(); 
		DesiredCapabilities caps = new DesiredCapabilities(); 
		caps.setCapability("browserName", browser);
		
		// Selenium Grid Local
		driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),caps));
		
		getDriver().navigate().to(BaseURL);
	}

	public WebDriver getDriver() 
	{
		return driver.get(); 
	}

	@AfterTest
	public void stopDriver() 
	{
		getDriver().quit();
		driver.remove();
	}

	@AfterMethod
	public void screenshotOnFailure(ITestResult result) 
	{
		if (result.getStatus() == ITestResult.FAILURE)
		{
			System.out.println("Failed!");
			System.out.println("Taking Screenshot....");
			Helper.captureScreenshot(getDriver(), result.getName());
		}
	}

}
