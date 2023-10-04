package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class UserLoginTest extends TestBase
{
	HomePage homeObject;
	LoginPage loginObject;
	String email ="test1836677@gmail.com";
	String oldPassword = "P@ssw0rd";
	
	@Test
	public void userCanLoginSuccessfully() throws InterruptedException
	{
		homeObject = new HomePage(driver);
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(email, oldPassword);
		Thread.sleep(2000);
		assertEquals(loginObject.logoutLink.getText(), "Log out");
	}

	@Test(dependsOnMethods = {"userCanLoginSuccessfully"})
	public void userCanLogoutSuccessfully() 
	{
		loginObject = new LoginPage(driver);
		loginObject.userLogout();
	}
}
