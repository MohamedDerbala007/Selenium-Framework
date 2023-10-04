package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase
{
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "Email")
	WebElement emailTxtBox;

	@FindBy(id = "Password")
	WebElement passwordTxtBox;
	
	@FindBy(css = "button.button-1.login-button")
	WebElement loginBtn;
	
	@FindBy(linkText = "Log out")
	public WebElement logoutLink;
	
	@FindBy(linkText = "My account")
	public WebElement myAccountLink;
	
	public void userLogin(String email , String password) 
	{
		setTextInElementText(emailTxtBox, email);
		setTextInElementText(passwordTxtBox, password);
		clickButton(loginBtn);
	}
	public void userLogout() 
	{
		clickButton(logoutLink);
	}
	public void openMyAccount() 
	{
		clickButton(myAccountLink);
	}
}
