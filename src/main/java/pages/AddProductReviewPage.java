package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductReviewPage extends PageBase
{

	public AddProductReviewPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "AddProductReview_Title")
	WebElement reviewTitleTxtBox;
	
	@FindBy(id = "AddProductReview_ReviewText")
	WebElement reviewTxtBox;
	
	@FindBy(id = "addproductrating_4")
	WebElement ratingOptions;
	
	@FindBy(css = "button.button-1.write-product-review-button")
	WebElement submitReviewBtn;
	
	@FindBy(css = "div.result")
	public WebElement successReviewNotification;
	
	public void openAddProductReviewPage(String reviewTiltle , String reviewMsg)
	{
		setTextInElementText(reviewTitleTxtBox, reviewTiltle);
		setTextInElementText(reviewTxtBox, reviewMsg);
		clickButton(ratingOptions);
		clickButton(submitReviewBtn);
	}
}
