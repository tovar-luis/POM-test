package basic.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends Base{

	By homePageLocator = By.id("userName-value");
	By bookStoreLocator = By.xpath("//button[@id='gotoStore']");
	By bookLocator = By.linkText("Git Pocket Guide");
	
	public ProfilePage(WebDriver driver) {
		super(driver);
	}
	
	public String getUserNameDisplayed() {
		if(isDisplayed(homePageLocator)){
			return getText(homePageLocator);
		}else {
			return "";
		}
	}
	
	public void goToBookStore(){
		if(isDisplayed(bookStoreLocator)){
			click(bookStoreLocator);
		}else {
			System.out.println("Go to book store button was not present");
		}
	}

}