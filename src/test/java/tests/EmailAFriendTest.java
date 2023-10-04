package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.EmailAFriendPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class EmailAFriendTest extends TestBase
{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	EmailAFriendPage emailAFriendObject;
	
	String productName = "Apple MacBook Pro 13-inch";
	String friendEmail = "medo@test.com";
	String userEmail = "test1257@gmail.com";
	String personalMsg = "Dear friend , I recommend this product for you";
	String firstName = "Mohamed";
	String lastName = "Derbala";
	String email ="test6523977@gmail.com";
	String oldPassword = "P@ssw0rd";
	
	
	// 1-User Registration
	@Test(priority = 1)
	public void userCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration(firstName, lastName, email, oldPassword);
		assertEquals(registerObject.successRegisterationMsg.getText(), "Your registration completed");
	}
	
	// 2-User Login
	@Test(dependsOnMethods = {"userCanRegisterSuccessfully"})
	public void userCanRegisterAndLoginSuccesfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(email, oldPassword);
	}
	
	// 3-Search For Product
	@Test(dependsOnMethods = {"userCanRegisterAndLoginSuccesfully"})
	public void UserCanSearchWithAutoSuggest()
	{
		try {
			searchObject = new SearchPage(driver);
			searchObject.ProductSearchUsingAutoSuggest(productName);
			productDetailsObject = new ProductDetailsPage(driver);
			assertEquals(productDetailsObject.productNameInBreadCrumb.getText(), productName);
			
		} catch (Exception e) 
		{
			System.out.println("Error occurred " + e.getMessage());
		}
	}
	
	// 4-Recommend Product To Friend With Email
	@Test(dependsOnMethods = {"UserCanSearchWithAutoSuggest"})
	public void UserCanRecommendProductToFriendWithEmail()
	{
		productDetailsObject = new ProductDetailsPage(driver);
		productDetailsObject.openSendEmailToAfriend();
		emailAFriendObject = new EmailAFriendPage(driver);
		emailAFriendObject.openEmailAFriendPage(friendEmail, personalMsg);
		assertTrue(emailAFriendObject.successMsgOfSendingEmail.getText().contains("Your message has been sent."));
	}
	
	// 5-User Logout
	@Test(dependsOnMethods = {"UserCanRecommendProductToFriendWithEmail"})
	public void userCanLogoutSuccessfully()
	{
		loginObject = new LoginPage(driver);
		loginObject.userLogout();
	}

}
