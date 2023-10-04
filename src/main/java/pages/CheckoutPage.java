package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase
{

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "button.button-1.checkout-as-guest-button")
	private WebElement checkoutAsGuestBtn;
	
	@FindBy(id = "BillingNewAddress_FirstName")
	private WebElement firstNameTxt;
	
	@FindBy(id = "BillingNewAddress_LastName")
	private WebElement lastNameTxt;
	
	@FindBy(id = "BillingNewAddress_Email")
	private WebElement emailTxt;
	
	@FindBy(id = "BillingNewAddress_CountryId")
	private WebElement countryddl;
	
	@FindBy(id = "BillingNewAddress_City")
	private WebElement cityTxt;
	
	@FindBy(id = "BillingNewAddress_Address1")
	private WebElement address1Txt;
	
	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	private WebElement zipPostalCodeTxt;
	
	@FindBy(id = "BillingNewAddress_PhoneNumber")
	private WebElement phoneNumberTxt;
	
	@FindBy(css = "button.button-1.new-address-next-step-button")
	private WebElement continueBtn;
	
	@FindBy(id = "shippingoption_1")
	private WebElement shippingRadioBtn;
	
	@FindBy(css = "button.button-1.shipping-method-next-step-button")
	private WebElement continueShippingBtn;
	
	@FindBy(id = "paymentmethod_0")
	private WebElement paymentMethodRadioBtn;
	
	@FindBy(css = "button.button-1.payment-method-next-step-button")
	private WebElement continuePaymentMethodBtn;
	
	@FindBy(css = "button.button-1.payment-info-next-step-button")
	private WebElement continuePaymentInfoBtn;
	
	@FindBy(css = "a.product-name")
	public WebElement productName;
	
	@FindBy(css = "button.button-1.confirm-order-next-step-button")
	private WebElement confirmBtn;
	
	@FindBy(css = "h1")
	public WebElement thankyouLbl;
	
	@FindBy(css = "div.section.order-completed")
	public WebElement successMsg;
	
	@FindBy(linkText = "Click here for order details.")
	private WebElement orderDetailsLink;
	
	public void openCheckoutPageAsGuest()
	{
		clickButton(checkoutAsGuestBtn);
	}

	public void RegisteredUserCheckoutProducts(String countryName , String city , String address1 , String postalCode , String phoneNumber) throws InterruptedException 
	{
		select = new Select(countryddl);
		select.selectByVisibleText(countryName);
		setTextInElementText(cityTxt, city);
		setTextInElementText(address1Txt, address1);
		setTextInElementText(zipPostalCodeTxt, postalCode);
		setTextInElementText(phoneNumberTxt, phoneNumber);
		clickButton(continueBtn);
		clickButton(shippingRadioBtn);
		clickButton(continueShippingBtn);
		Thread.sleep(2000);
		clickButton(paymentMethodRadioBtn);
		clickButton(continuePaymentMethodBtn);
		Thread.sleep(2000);
		clickButton(continuePaymentInfoBtn);
	}
	public void GuestUserCheckoutProducts(String firstName , String lastName , String email , String countryName , String city , String address1 , String postalCode , String phoneNumber) throws InterruptedException 
	{
		setTextInElementText(firstNameTxt, firstName);
		setTextInElementText(lastNameTxt, lastName);
		setTextInElementText(emailTxt, email);
		select = new Select(countryddl);
		select.selectByVisibleText(countryName);
		setTextInElementText(cityTxt, city);
		setTextInElementText(address1Txt, address1);
		setTextInElementText(zipPostalCodeTxt, postalCode);
		setTextInElementText(phoneNumberTxt, phoneNumber);
		clickButton(continueBtn);
		clickButton(shippingRadioBtn);
		clickButton(continueShippingBtn);
		Thread.sleep(2000);
		clickButton(paymentMethodRadioBtn);
		clickButton(continuePaymentMethodBtn);
		Thread.sleep(2000);
		clickButton(continuePaymentInfoBtn);
	}
	
	public void RegisteredUserConfirmOrder()
	{
		clickButton(confirmBtn);
	}
	
	public void openOrderDetailsPage()
	{
		clickButton(orderDetailsLink);
	}

}
