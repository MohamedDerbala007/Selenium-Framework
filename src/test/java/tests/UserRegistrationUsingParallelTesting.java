package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationUsingParallelTesting extends TestBase2
{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;

	Faker fakeData = new Faker();
	String firstName = fakeData.name().firstName();
	String lastName = fakeData.name().lastName();
	String email = fakeData.internet().emailAddress();
	String oldPassword = fakeData.number().digits(8).toString();

	@Test(priority = 1)
	public void userCanRegisterSuccessfully() 
	{
		homeObject = new HomePage(getDriver());
		homeObject.openRegisterationPage();
		registerObject = new UserRegistrationPage(getDriver());
		registerObject.userRegisteration(firstName, lastName, email, oldPassword);
		System.out.println("The User Data is : " + firstName + " , " + lastName + " , " + email + " , " + oldPassword);
		assertEquals(registerObject.successRegisterationMsg.getText(), "Your registration completed");
		homeObject = new HomePage(getDriver());
		homeObject.openLoginPage();
		loginObject = new LoginPage(getDriver());
		loginObject.userLogin(email , oldPassword);
		loginObject = new LoginPage(getDriver());
		loginObject.userLogout();
	}
}