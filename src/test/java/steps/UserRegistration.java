package steps;

import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegistration extends TestBase
{
	HomePage homeObject;
	UserRegistrationPage userRegistrationObject;
	
	@Given("the user is in the home page")
	public void the_user_is_in_the_home_page() 
	{
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
	}
	@When("I click on register link")
	public void i_click_on_register_link() 
	{
		assertTrue(driver.getCurrentUrl().contains("register"));

	}
	/*@When("I entered the user data")
	public void i_entered_the_user_data() 
	{
		userRegistrationObject = new UserRegistrationPage(driver);
		userRegistrationObject.userRegisteration("Mohamed", "Derbala", "Mohamedderbala1234@gmail.com", "123456");

	}*/
	@When("I entered {string} , {string} , {string} , {string}")
	public void i_entered(String firstName, String lastName, String email, String oldPassword) 
	{
		userRegistrationObject = new UserRegistrationPage(driver);
		userRegistrationObject.userRegisteration(firstName, lastName, email, oldPassword);
	    
	}
	@Then("The registration page displayed successfully")
	public void the_registration_page_displayed_successfully() 
	{
	  assertTrue(userRegistrationObject.successRegisterationMsg.getText().contains("Your registration completed"));
	}

}
