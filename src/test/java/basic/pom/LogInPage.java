package basic.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage extends Base{

	By userLocator = By.cssSelector("#userName");
	By passLocator = By.cssSelector("#password");
	By signInLocator = By.id("login");
	By homePageLocator = By.id("userName-value");
	
	public LogInPage(WebDriver driver) {
		super(driver);
	}
	
	public void logIn() throws InterruptedException {
		if(isDisplayed(userLocator)){
			type("luistovar", userLocator);
			type("P@ssw0rd", passLocator);
			Thread.sleep(2000);
			
			click(signInLocator);
			Thread.sleep(2000);
		}else {
			System.out.println("username textbox was not present");
		}
	}
	

}
