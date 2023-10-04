package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase
{
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	@Test
	public void UserCanSearchForProducts()
	{
		searchObject = new SearchPage(driver);
		searchObject.ProductSearch(productName);
		searchObject.OpenProductDetailsPage();
		productDetailsObject = new ProductDetailsPage(driver);
		assertTrue(productDetailsObject.productNameInBreadCrumb.getText().equalsIgnoreCase(productName));
	}
	
}
