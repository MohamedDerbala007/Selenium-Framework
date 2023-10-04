package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.EmailAFriendPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.UserRegistrationPage;

public class GuestUserCheckoutProductTest extends TestBase
{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	EmailAFriendPage emailAFriendObject;
	ShoppingCartPage shoppingCartObject;
	CheckoutPage checkoutObject;
	OrderDetailsPage orderDetailsObject;
	
	String productName = "Apple MacBook Pro 13-inch";
	String friendEmail = "medo@test.com";
	String userEmail = "test1257@gmail.com";
	String personalMsg = "Dear friend , I recommend this product for you";
	String firstName = "Mohamed";
	String lastName = "Derbala";
	String email ="test1945959@gmail.com";
	String oldPassword = "P@ssw0rd";
	String countryName = "Egypt";
	String city = "cairo";
	String address1 = "Ahmed Maher Street";
	String postalCode = "225500";
	String phoneNumber = "01015543195";
	
	
	

	
	
	// 1-Search For Product
	@Test(priority = 1)
	public void UserCanSearchWithAutoSuggest()
	{
		try {
			searchObject = new SearchPage(driver);
			searchObject.ProductSearchUsingAutoSuggest(productName);
			productDetailsObject = new ProductDetailsPage(driver);
			assertEquals(productDetailsObject.productNameInBreadCrumb.getText(), productName);
			
		} catch (Exception e) 
		{
			System.out.println("Error occurred " + e.getMessage());
		}
	}
	
	// 4-Add product to shopping cart
	@Test(dependsOnMethods = "UserCanSearchWithAutoSuggest")
	public void UserCanAddProductToShoppingCart()
	{
		productDetailsObject = new ProductDetailsPage(driver);
		productDetailsObject.AddProductToShoppingCart();
		productDetailsObject.closeSuccessNotificationBar();
		homeObject = new HomePage(driver);
		homeObject.openShoppingCartPage();
		shoppingCartObject = new ShoppingCartPage(driver);
		assertTrue(shoppingCartObject.addedProductName.getText().contains(productName));
		assertEquals(shoppingCartObject.totalLbl.getText(), "$3,600.00");
	}

	// 5-Check out product
	@Test(dependsOnMethods = "UserCanAddProductToShoppingCart")
	public void GuestUserCanCheckoutProducts() throws InterruptedException 
	{
		shoppingCartObject = new ShoppingCartPage(driver);
		shoppingCartObject.openCheckoutPage();
		checkoutObject = new CheckoutPage(driver);
		checkoutObject.openCheckoutPageAsGuest();
		checkoutObject.GuestUserCheckoutProducts(firstName, lastName, email, countryName, city, address1, postalCode, phoneNumber);
		assertTrue(checkoutObject.productName.isDisplayed());
		assertTrue(checkoutObject.productName.getText().contains(productName));
		checkoutObject.RegisteredUserConfirmOrder();
		assertTrue(checkoutObject.thankyouLbl.isDisplayed());
		assertTrue(checkoutObject.successMsg.getText().contains("Your order has been successfully processed!"));
		checkoutObject.openOrderDetailsPage();
		assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderDetailsObject = new OrderDetailsPage(driver);
		orderDetailsObject.downloadPDFInvoice();
		orderDetailsObject.printOrderDetails();
		
	}
}
