package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailAFriendPage extends PageBase {

	public EmailAFriendPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "FriendEmail")
	private WebElement friendEmailTxtBox;
	
	@FindBy(id = "YourEmailAddress")
	private WebElement userEmailTxtBox;
	
	@FindBy(id = "PersonalMessage")
	private WebElement personalMsgToFriendTxtBox;
	
	@FindBy(css = "button.button-1.send-email-a-friend-button")
	private WebElement sendEmailBtn;
	
	@FindBy(css = "div.result")
	public WebElement successMsgOfSendingEmail;
	
	public void openEmailAFriendPage(String friendEmail , String personalMsg)
	{
		setTextInElementText(this.friendEmailTxtBox , friendEmail);
		setTextInElementText(personalMsgToFriendTxtBox, personalMsg);
		clickButton(sendEmailBtn);
	}

}
