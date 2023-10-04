package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishlistPage;

public class AddProductToWishlistTest extends TestBase
{
    HomePage homeObject;
	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	WishlistPage wishlistObject;
	
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
	public void UserCanAddProductToWishlist()
	{
		productDetailsObject = new ProductDetailsPage(driver);
		productDetailsObject.AddProductToWishlist();
		homeObject = new HomePage(driver);
		homeObject.openWishlistPage();
		wishlistObject = new WishlistPage(driver);
		assertTrue(wishlistObject.wishlistHeader.isDisplayed());
		assertTrue(wishlistObject.productCell.getText().contains(productName));
	}
	
	@Test(dependsOnMethods = "UserCanAddProductToWishlist")
	public void UserCanRemoveProductFromWishlist()
	{
		wishlistObject = new WishlistPage(driver);
		wishlistObject.removeProductFromCart();
		assertEquals(wishlistObject.emptyCartLbl.getText() , "The wishlist is empty!");
	}

}
