package tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.UserRegistrationPage;
import pages.LoginPage;

public class UserRegistrationTestWithDDTAndPropertiesFile extends TestBase 
{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	String firstName = LoadProperties.UserData.getProperty("firstName");
	String lastName = LoadProperties.UserData.getProperty("lastName");
	String email = LoadProperties.UserData.getProperty("email");
	String oldPassword = LoadProperties.UserData.getProperty("oldPassword");
	
	@Test(priority = 1)
	public void userCanRegisterSuccessfully() 
	{
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration(firstName, lastName, email, oldPassword);
		assertEquals(registerObject.successRegisterationMsg.getText(), "Your registration completed");
		homeObject = new HomePage(driver);
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(email , oldPassword);
		loginObject = new LoginPage(driver);
		loginObject.userLogout();
	}
}
