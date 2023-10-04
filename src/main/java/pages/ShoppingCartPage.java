package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "button.remove-btn")
	private WebElement removeBtn;
	
	@FindBy(id = "itemquantity11225")
	public WebElement quantityTxt;
	
	@FindBy(css = "td.subtotal")
	public WebElement totalLbl;
	
	@FindBy(css = "button.button-2.update-cart-button")
	public WebElement updateShoppingCartBtn;
	
	@FindBy(css = "div.no-data")
	public WebElement noDataLbl;
	
	@FindBy(css = "a.product-name")
	public WebElement addedProductName;
	
	@FindBy(id = "checkout")
	private WebElement checkoutBtn;
	
	@FindBy(id = "termsofservice")
	private WebElement agreeTermsCheckbox;
	

	public void removeProductFromCart()
	{
		clickButton(removeBtn);
	}
	public void updateProductQuantity(String quantity)
	{
		clearTxt(quantityTxt);
		setTextInElementText(quantityTxt, quantity);
		clickButton(updateShoppingCartBtn);
	}
	public void openCheckoutPage()
	{
		clickButton(agreeTermsCheckbox);
		clickButton(checkoutBtn);
	}

}
