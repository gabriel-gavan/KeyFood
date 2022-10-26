package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utils.SeleniumWrappers;

public class HomePage extends SeleniumWrappers{
	
	
	public By searchProductfield = By.cssSelector("input[placeholder='Search for products...']");
	public By selectProduct = By.xpath("(//span[@class='dgwt-wcas-st-title'])[1]");
	
	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	public void searchforProduct(String product) {
		click(searchProductfield);
		sendKeys(searchProductfield, product);
	
	}
	public void openProduct(String product) {
		click(searchProductfield);
		sendKeys(searchProductfield, product);
		click(selectProduct);
	}
}
