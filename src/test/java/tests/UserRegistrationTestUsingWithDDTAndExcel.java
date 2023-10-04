package tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.UserRegistrationPage;
import pages.LoginPage;

public class UserRegistrationTestUsingWithDDTAndExcel extends TestBase 
{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;


	@DataProvider(name = "ExcelData")
	public static Object[][] UserRegisterData() throws IOException
	{
		// get data from Excel Reader Class
		ExcelReader ER = new ExcelReader();
		return ER.getExcelData();

	}

	@Test(priority = 1 , dataProvider = "ExcelData")
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
