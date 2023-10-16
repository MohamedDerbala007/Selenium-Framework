package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

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

public class TestBase3 {
    public static String BaseURL = "http://demo.nopcommerce.com";

    protected ThreadLocal<RemoteWebDriver> driver = ThreadLocal.withInitial(() -> null);

    @BeforeTest
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser) throws MalformedURLException {
    	driver = new ThreadLocal<RemoteWebDriver>(); 
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("platformName", "Windows 10");
        capabilities.setCapability("browserVersion", "118.0");

        Map<String, Object> sauceOptions = new HashMap<String, Object>();
        sauceOptions.put("username", "oauth-mohamedderbala007-30f97");
        sauceOptions.put("accessKey", "1de30bd1-dcb5-4194-921e-990bd23afd57");
        sauceOptions.put("build", "selenium-build-9A79Z");
        sauceOptions.put("name", "Smoke test for main functionality");

        capabilities.setCapability("sauce:options", sauceOptions);

        driver.set(new RemoteWebDriver(new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub"),capabilities));

        getDriver().navigate().to(BaseURL);
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    @AfterTest
    public void stopDriver() {
        getDriver().quit();
        driver.remove();
    }

    @AfterMethod
    public void screenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed!");
            System.out.println("Taking Screenshot....");
            Helper.captureScreenshot(getDriver(), result.getName());
        }
    }
}
