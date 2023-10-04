package tests;

import static org.testng.Assert.assertEquals;

import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestUsingWithDDTAndCSV extends TestBase 
{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;

	CSVReader reader;

	@Test(priority = 1)
	public void userCanRegisterSuccessfully() throws CsvValidationException, IOException 
	{
		// get path of CSV file
		String CSV_file = System.getProperty("user.dir") + "\\src\\test\\java\\data\\UserData.csv";
		reader = new CSVReader(new FileReader(CSV_file));
		String[] csvCell ;
		// while loop will be executed till the last value in CSV file
		while((csvCell = reader.readNext()) != null)
		{
			String firstName = csvCell[0];
			String lastName = csvCell[1];
			String email = csvCell[2];
			String oldPassword = csvCell[3];

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
}
