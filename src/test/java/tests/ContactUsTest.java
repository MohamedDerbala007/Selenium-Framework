package tests;

import pages.HomePage;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.ContactUsPage;

public class ContactUsTest extends TestBase
{
	HomePage homeObject;
	ContactUsPage contactUsObject;
	
	String fullName = "Mohamed Derbala";
	String email = "Derbala3@Test.com";
	String message = "Hello Admin , This is for test";
	
	@Test
	public void UserCanContactUs()
	{
		homeObject = new HomePage(driver);
		homeObject.scrollToButtom();
		homeObject.openContactUsPage();
		contactUsObject = new ContactUsPage(driver);
		contactUsObject.openContactUs(fullName, email, message);
		assertTrue(contactUsObject.successMsg.getText().contains("Your enquiry has been successfully sent to the store owner."));
	}
}
