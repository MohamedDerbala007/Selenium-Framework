package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.ComparePage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProductToCompareTest extends TestBase
{
	
	HomePage homeObject;
	ProductDetailsPage productDetailsObject;
	SearchPage searchObject;
	ComparePage compareObject;
	
	String firstProductName = "Apple MacBook Pro 13-inch";
	String secondProductName = "Asus N551JK-XO076H Laptop";
	
	@Test(priority = 1)
	public void UserCanCompareProducts()
	{
		searchObject = new SearchPage(driver);
		searchObject.ProductSearchUsingAutoSuggest(firstProductName);
		productDetailsObject = new ProductDetailsPage(driver);
		productDetailsObject.AddProductToCompare();
		searchObject = new SearchPage(driver);
		searchObject.ProductSearchUsingAutoSuggest(secondProductName);
		productDetailsObject = new ProductDetailsPage(driver);
		productDetailsObject.AddProductToCompare();
		productDetailsObject.openProductComparisonLink();
		compareObject = new ComparePage(driver);
		assertTrue(compareObject.firstProductName.isDisplayed());
		assertTrue(compareObject.secondProductName.isDisplayed());
		compareObject.compareProducts();

	}
	
	@Test(dependsOnMethods = "UserCanCompareProducts")
	public void UserCanClearCompareList()
	{
		compareObject = new ComparePage(driver);
		compareObject.clearCompareList();
		assertTrue(compareObject.noDataLbl.getText().contains("You have no items to compare."));
	}

}
