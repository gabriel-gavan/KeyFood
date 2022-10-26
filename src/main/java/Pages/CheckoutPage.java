package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utils.SeleniumWrappers;

public class CheckoutPage extends SeleniumWrappers{
	public By checkTermsAgreement = By.xpath("//input[@name='terms']");
	
	public By placeOrderButton = By.xpath("//button[@id='place_order']");
	
	public By placeOrderSuccessMessage = By.xpath("//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']");
	
	public By orderNumber = By.xpath("//li[@class='woocommerce-order-overview__order order']");
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		}
	
	public void placeOrder() {
		click(checkTermsAgreement);
		click(placeOrderButton);
	}
	public boolean checkfieldExists(By Locator) {
		WebElement element  = driver.findElement(Locator);
		return element.isDisplayed();
	}
}
