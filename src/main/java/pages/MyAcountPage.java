package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAcountPage extends PageBase
{

	public MyAcountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "Change password")
	WebElement changePasswordLink;
	
	@FindBy(id = "OldPassword")
	private WebElement oldPasswordTxt;
	
	@FindBy(id = "NewPassword")
	private WebElement newPasswordTxt;
	
	@FindBy(id = "ConfirmNewPassword")
	private WebElement confirmPasswordTxt;
	
	@FindBy(css = "button.button-1.change-password-button")
	private WebElement changePasswordBtn;
	
	@FindBy(css = "div.bar-notification.success")
	public WebElement changingPasswordMsg;
	
	@FindBy(css = "span.close")
	public WebElement xButton;
	
	public void userOpenChangePasswordLink()
	{
		clickButton(changePasswordLink);
	}
	
	public void userChangePassword(String oldPassword , String newPassword) 
	{
		setTextInElementText(oldPasswordTxt, oldPassword);
		setTextInElementText(newPasswordTxt, newPassword);
		setTextInElementText(confirmPasswordTxt, newPassword);
		clickButton(changePasswordBtn);
		clickButton(xButton);
	}

}
