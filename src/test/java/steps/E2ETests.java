package steps;


import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;
import tests.TestBase;

public class E2ETests extends TestBase {
	SearchPage searchObject;
	ProductDetailsPage productDetails;
	ShoppingCartPage cartObject;
	CheckoutPage checkoutObject;
	OrderDetailsPage orderObject;
	String productName = "Apple MacBook Pro 13-inch";

	@Given("^user is on Home Page$")
	public void user_is_on_Home_Page() {
		Assert.assertTrue(driver.getCurrentUrl().contains("demo.nopcommerce.com"));
	}

	@When("^he search for \"([^\"]*)\"$")
	public void he_search_for(String productName) throws InterruptedException {
		searchObject = new SearchPage(driver);
		searchObject.ProductSearchUsingAutoSuggest(productName);
		productDetails = new ProductDetailsPage(driver);
		Assert.assertTrue(productDetails.productNameInBreadCrumb.getText().contains(productName));
	}

	@When("choose to buy two items")
	public void choose_to_buy_two_items() {
		cartObject = new ShoppingCartPage(driver); 
		productDetails.AddProductToShoppingCart();
		driver.navigate().to("http://demo.nopcommerce.com/" + "cart");
		cartObject.openCheckoutPage();
	    
	}

	@When("^moves to checkout cart and enter personal details on checkout page and place the order$")
	public void moves_to_checkout_cart_and_enter_personal_details_on_checkout_page_and_place_the_order() throws InterruptedException {
		checkoutObject = new CheckoutPage(driver);
		checkoutObject.openCheckoutPageAsGuest();
		checkoutObject.GuestUserCheckoutProducts("test", "user", "testuser1@test.com","Egypt",  "Cairo"
				, "test address", "123456", "32445566677");
		Assert.assertTrue(checkoutObject.productName.isDisplayed());
		Assert.assertTrue(checkoutObject.productName.getText().contains(productName));
		checkoutObject.RegisteredUserConfirmOrder();
		Assert.assertTrue(checkoutObject.thankyouLbl.isDisplayed());
		
	}

	@Then("^he can view the order and download the invoice$")
	public void he_can_view_the_order_and_download_the_invoice() throws InterruptedException {
		orderObject = new OrderDetailsPage(driver);
		checkoutObject.openOrderDetailsPage();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderObject.downloadPDFInvoice();
		Thread.sleep(3000);
		orderObject.printOrderDetails();
	}
}
