package Tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.NavMenuPage;
import Pages.ProductPage;
import Utils.BaseTest;
import Utils.TestNgListener;
@Listeners(TestNgListener.class)
public class PlaceProductOrder extends BaseTest{
	
	@Parameters({"user","pass"})
	@Test (priority=0,groups="PlaceOrder")
	public void placeOrder(String username, String password) throws InterruptedException {
	NavMenuPage navMenu = new NavMenuPage(driver);
	navMenu.navigateTo(navMenu.loginLink);
	
	LoginPage loginPage = new LoginPage(driver);
	loginPage.loginInApp(username, password);
		
	HomePage homePage = new HomePage(driver);	
	homePage.openProduct("Pretzels");	
		
	ProductPage productPage = new ProductPage(driver);	
	productPage.addProductToBascket();
	
	WebElement element = driver.findElement(productPage.messageAddedtoCart);
	
	assertTrue(element.getText().contains("Rold Gold Tiny Twists Pretzels” has been added to your cart."));
	
	CartPage cartPage = new CartPage(driver);
	cartPage.viewCart();
	
	double Price1 = cartPage.getCartTotalPrice(cartPage.cartTotal);
	
	cartPage.updateCart();
	Thread.sleep(5000);
	
	double Price2 = cartPage.getCartTotalPrice(cartPage.cartTotal);

	
	assertFalse(Price1==Price2);
	cartPage.proceedToCheckout();
		Thread.sleep(2000);
		
	CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.placeOrder();
		
	WebElement element2 = driver.findElement(checkoutPage.placeOrderSuccessMessage);
	assertEquals(element2.getText(),"Thank you. Your order has been received.");
	
	assertTrue(checkoutPage.checkfieldExists(checkoutPage.orderNumber));
	}

		
				
		
}