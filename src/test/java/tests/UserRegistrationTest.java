package tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserRegistrationPage;
import pages.LoginPage;

public class UserRegistrationTest extends TestBase 
{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	String firstName = "Mohamed";
	String lastName = "Derbala";
	String email ="test1948567@gmail.com";
	String oldPassword = "P@ssw0rd";
	
	@Test(priority = 1)
	public void userCanRegisterSuccessfully() 
	{
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration(firstName, lastName, email, oldPassword);
		assertEquals(registerObject.successRegisterationMsg.getText(), "Your registration completed");
	}
	
	@Test(dependsOnMethods = {"userCanRegisterSuccessfully"})
	public void userCanRegisterAndLoginSuccesfully() 
	{
		homeObject = new HomePage(driver);
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(email , oldPassword);
	}
	
	@Test(dependsOnMethods = {"userCanRegisterAndLoginSuccesfully"})
	public void userCanLogoutSuccessfully() 
	{
		loginObject = new LoginPage(driver);
		loginObject.userLogout();
	}
	

}
