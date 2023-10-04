package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase 
{
	HomePage homeObject;
	ProductDetailsPage productDetailsObject;
	SearchPage searchObject;
	
	String productName = "Apple MacBook Pro 13-inch";
	
	@Test(priority = 1)
	public void UserCanChangeCurrency()
	{
		homeObject = new HomePage(driver);
		homeObject.changeCurrency();
	}
	
	@Test(dependsOnMethods = "UserCanChangeCurrency")
	public void UserCanSearchWithAutoSuggest()
	{
		try {
			searchObject = new SearchPage(driver);
			searchObject.ProductSearchUsingAutoSuggest(productName);
			productDetailsObject = new ProductDetailsPage(driver);
			assertEquals(productDetailsObject.productNameInBreadCrumb.getText(), productName);
			assertTrue(productDetailsObject.productPrice.getText().contains("€"));
			System.out.println(productDetailsObject.productPrice.getText());
		} catch (Exception e) 
		{
			System.out.println("Error occurred " + e.getMessage());
		}
	}

}
