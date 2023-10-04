package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;

public class ProductHoverMenuTest extends TestBase
{
	HomePage homeObject;
	
	
	@Test
	public void UserCanSelectSubCategoryFromMainMenu()
	{
		homeObject = new HomePage(driver);
		homeObject.selectNotebooksMenu();
		assertTrue(driver.getCurrentUrl().contains("notebooks"));
	}

}
