package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;
import pages.MyAcountPage;

public class MyAccountTest extends TestBase
{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	MyAcountPage myAccountObject;
	String oldPassword = "P@ssw0rd";
	String newPassword = "123456";
	String firstName = "Mohamed";
	String lastName = "Derbala";
	String email ="test12466778@gmail.com";
	
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
		loginObject.userLogin(email, oldPassword);
	}
	
	@Test(dependsOnMethods = {"userCanRegisterAndLoginSuccesfully"})
	public void loggedinUserCanChangePassword()
	{
		loginObject = new LoginPage(driver);
		loginObject.openMyAccount();
		myAccountObject = new MyAcountPage(driver);
		myAccountObject.userOpenChangePasswordLink();
		myAccountObject.userChangePassword(oldPassword , newPassword);
		assertEquals(myAccountObject.changingPasswordMsg.getText(), "Password was changed");
	}
	
	@Test(dependsOnMethods = {"loggedinUserCanChangePassword"})
	public void userCanLogoutSuccessfully() throws InterruptedException 
	{
		Thread.sleep(3000);
		loginObject = new LoginPage(driver);
		loginObject.userLogout();
	}
	
	@Test(dependsOnMethods = {"userCanLogoutSuccessfully"})
	public void userCanLoginWithNewPassword()
	{
		homeObject = new HomePage(driver);
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(email, newPassword);
		assertEquals(loginObject.logoutLink.getText(), "Log out");
	}

}
