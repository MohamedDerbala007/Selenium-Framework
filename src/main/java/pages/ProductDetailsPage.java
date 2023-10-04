package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase
{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}	
	
	@FindBy(css = "strong.current-item")
	public WebElement productNameInBreadCrumb;
	
	@FindBy(css = "button.button-2.email-a-friend-button")
	private WebElement emailAfriendBtn;
	
	@FindBy(css = "div.product-price")
	public WebElement productPrice;
	
	@FindBy(linkText = "Add your review")
	public WebElement addReviewLink;
	
	@FindBy(css = "button.button-2.add-to-wishlist-button")
	private WebElement addToWishlistBtn;
	
	@FindBy(css = "button.button-2.add-to-compare-list-button")
	private WebElement addToCompareBtn;
	
	@FindBy(linkText = "product comparison")
	private WebElement productComparisonLink;
	
	@FindBy(css = "button.button-1.add-to-cart-button")
	private WebElement addToCartBtn;
	
	@FindBy(css = "span.close")
	public WebElement closeSuccessNotificationBtn;
	
	public void openSendEmailToAfriend()
	{
		clickButton(emailAfriendBtn);
	}
	public void openAddReviewLink()
	{
		clickButton(addReviewLink);
	}
	public void AddProductToWishlist() 
	{
		clickButton(addToWishlistBtn);
	}
	public void AddProductToCompare()
	{
		clickButton(addToCompareBtn);
	}
	public void openProductComparisonLink()
	{
		clickButton(productComparisonLink);
	}
	public void AddProductToShoppingCart()
	{
		clickButton(addToCartBtn);
	}
	public void closeSuccessNotificationBar()
	{
		clickButton(closeSuccessNotificationBtn);
	}
}
