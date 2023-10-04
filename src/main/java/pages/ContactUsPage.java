package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase
{

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "FullName")
	private WebElement NameTxtBox;
	
	@FindBy(id = "Email")
	private WebElement EmailTxtBox;
	
	@FindBy(id = "Enquiry")
	private WebElement enquiryTxtBox;
	
	@FindBy(css = "button.button-1.contact-us-button")
	private WebElement submitBtn;
	
	@FindBy(css = "div.result")
	public WebElement successMsg;
	
	
	public void openContactUs(String fullName , String email , String message)
	{
		setTextInElementText(NameTxtBox, fullName);
		setTextInElementText(EmailTxtBox, email);
		setTextInElementText(enquiryTxtBox, message);
		clickButton(submitBtn);
	}

}
