package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserRegistrationPage;
import pages.LoginPage;

public class UserRegistrationTestUsingWithDDTAndDataProvider extends TestBase 
{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;

	
	@DataProvider(name = "testData")
	public static Object[][] UserData()
	{
		return new Object[][]
				{
			{"Mohamed" , "Derbala" , "test1988789@gmail.com" , "P@ssw0rd"},
			{"Mohamed1" , "Derbala1" , "test1997568@gmail.com" , "123456"}
				};
	}
	
	@Test(priority = 1 , dataProvider = "testData")
	public void userCanRegisterSuccessfully(String firstName, String lastName, String email, String oldPassword) 
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
