package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase 
{
	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}
	
	@FindBy (css = "a.ico-register")
	WebElement registerLink;
	
	@FindBy (css = "a.ico-login")
	WebElement loginLink;
	
	@FindBy (linkText = "Contact us")
	WebElement contactUsLink;
	
	@FindBy (id = "customerCurrency")
	WebElement currencyddl;
	
	@FindBy (linkText = "Computers")
	WebElement computersMenu;
	
	@FindBy (linkText = "Notebooks")
	WebElement notebooksMenu;
	
	@FindBy (css = "span.wishlist-label")
	WebElement wishlistLink;
	
	@FindBy (linkText = "Shopping cart")
	WebElement shoppingCartLink;
	
	public void openRegisterationPage()
	{
		clickButton(registerLink);
	}
	public void openLoginPage()
	{
		clickButton(loginLink);
	}
	public void openContactUsPage() 
	{
		scrollToButtom();
		clickButton(contactUsLink);
	}
	public void changeCurrency()
	{
		select = new Select(currencyddl);
		select.selectByVisibleText("Euro");
	}
	public void selectNotebooksMenu()
	{
		action.moveToElement(computersMenu).perform();
		action.moveToElement(notebooksMenu).click().build().perform();
	}
	public void openWishlistPage()
	{
		clickButton(wishlistLink);
	}
	public void openShoppingCartPage()
	{
		clickButton(shoppingCartLink);
	}

}
