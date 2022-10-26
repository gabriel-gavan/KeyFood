package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utils.SeleniumWrappers;

public class CartPage extends SeleniumWrappers {
	public By viewCart = By.xpath("//div[@class='woocommerce-message']/a");
	public By updatePlusQRTCart = By.xpath("//i[@class='klbth-icon-plus']");
	public By updateCart = By.xpath("//button[@name='update_cart']");
	public By cartTotal = By.xpath("//td[@data-title='Total']");
	public By proceedtoCheckout = By.xpath("//a[@class='checkout-button button alt wc-forward']");
	
	public CartPage(WebDriver driver) {
		super(driver);
			}
	public void viewCart() {
		click(viewCart);
	}
	public void updateCart() {
		click(updatePlusQRTCart);
		click(updateCart);
	}
	public double getCartTotalPrice(By locator) {
		String CartTotal = driver.findElement(locator).getText();
		Double value=null;
		
		if(CartTotal.contains("$")){
		     value=Double.valueOf(CartTotal.replace("$",""));
		
		}
		return value;
		
		}
	public void proceedToCheckout() {
		click(proceedtoCheckout);
		
	}
}
