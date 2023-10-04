package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToShoppingCartTest extends TestBase
{
	HomePage homeObject;
	ProductDetailsPage productDetailsObject;
	SearchPage searchObject;
	ShoppingCartPage shoppingCartObject;
	
	String productName = "Apple MacBook Pro 13-inch";
	
	
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
	
	@Test(dependsOnMethods = "UserCanAddProductToShoppingCart")
	public void UserCanRemoveProductFromShoppingCart()
	{
		shoppingCartObject = new ShoppingCartPage(driver);
		shoppingCartObject.removeProductFromCart();
		assertTrue(shoppingCartObject.noDataLbl.getText().contains("Your Shopping Cart is empty!"));
	}

}
