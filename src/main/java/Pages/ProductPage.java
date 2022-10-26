package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utils.SeleniumWrappers;

public class ProductPage extends SeleniumWrappers{

	public By addtoCart = By.xpath("//button[@name='add-to-cart']");
	public By messageAddedtoCart = By.xpath("//div[@class='woocommerce-message']");
	
	
	public ProductPage(WebDriver driver) {
		super(driver);
		
	}
	public void addProductToBascket() {
		click(addtoCart);
	}
	
	
}
