package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductUsingAutoSuggest extends TestBase
{
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	
	@Test
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

}
