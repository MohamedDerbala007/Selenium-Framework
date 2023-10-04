package tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestUsingWithDDTAndJSON extends TestBase 
{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;


	@Test(priority = 1)
	public void userCanRegisterSuccessfully() throws IOException, ParseException 
	{
		JsonDataReader jsonReader = new JsonDataReader();
		jsonReader.JsonReader();
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration(jsonReader.firstName, jsonReader.lastName, jsonReader.email, jsonReader.oldPassword);
		assertEquals(registerObject.successRegisterationMsg.getText(), "Your registration completed");
		homeObject = new HomePage(driver);
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(jsonReader.email, jsonReader.oldPassword);
		loginObject = new LoginPage(driver);
		loginObject.userLogout();
	}
}
