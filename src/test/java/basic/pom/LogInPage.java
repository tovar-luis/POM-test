package basic.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage extends Base{

	//Locators for the username and password fields, and the login button 
	By userLocator = By.cssSelector("#userName");
	By passLocator = By.cssSelector("#password");
	By signInLocator = By.id("login");
	
	public LogInPage(WebDriver driver) {
		super(driver);
	}
	
	//Method for loging into the DemoQA website with the specified credentials
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
