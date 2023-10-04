package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase 
{

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(id = "gender-male")
	WebElement genderRdoBtn;
	
	@FindBy(id = "FirstName")
	WebElement firstNameTxtBox;
	
	@FindBy(id = "LastName")
	WebElement lastNameTxtBox;
	
	@FindBy(id = "Email")
	WebElement emailTxtBox;
	
	@FindBy(id = "Password")
	WebElement passwordTxtBox;
	
	@FindBy(id = "ConfirmPassword")
	WebElement confirmPasswordTxtBox;
	
	@FindBy(id = "register-button")
	WebElement registerBtn;
	
	@FindBy(css = "div.result")
	public WebElement successRegisterationMsg;
	
	public void userRegisteration(String firstName , String lastName , String email , String password)
	{
		clickButton(genderRdoBtn);
		setTextInElementText(firstNameTxtBox, firstName);
		setTextInElementText(lastNameTxtBox, lastName);
		setTextInElementText(emailTxtBox, email);
		setTextInElementText(passwordTxtBox, password);
		setTextInElementText(confirmPasswordTxtBox, password);
		clickButton(registerBtn);
	}
}
