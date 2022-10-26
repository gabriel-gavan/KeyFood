package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utils.SeleniumWrappers;

public class LoginPage  extends SeleniumWrappers{
	public LoginPage(WebDriver driver) {
		super(driver);
}
	public By usernameField = By.cssSelector("input[id='username']");
	public By passwordField = By.cssSelector("input[id='password']");
	public By submitButton = By.cssSelector("button[type='submit']");
	
	public By logoutLink = By.linkText("Log out");
	
	public By loginErrorMessage = By.cssSelector("ul[class='woocommerce-error']");
	public By loginSuccessMessage = By.cssSelector("div[class='woocommerce-notices-wrapper']");
	public By logoutButton = By.cssSelector("li[class='menu_user_logout']");
	
	
	public void loginInApp(String username, String password) {
		sendKeys(usernameField,username);
		sendKeys(passwordField,password);
		click(submitButton);
		
	}
	
	public void logoutFromApp() {
		NavMenuPage myAccount = new NavMenuPage(driver);
		click(myAccount.loginLink);
		click(logoutLink);
	}
	
	public boolean loginSuccessMessageIsDisplayed() {
		return driver.findElement(loginSuccessMessage).isDisplayed();
	}
	
public boolean loginErrorMessageIsDisplayed() {
		return driver.findElement(loginErrorMessage).isDisplayed();
	}

public boolean loginMessageIsDisplayed(By locator) {
	return driver.findElement(locator).isDisplayed();
	}

}
