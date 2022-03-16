package basic.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookStorePage extends Base{
	
	//Locator for the book
	By bookLocator = By.linkText("Git Pocket Guide");
	
	public BookStorePage(WebDriver driver) {
		super(driver);
	}
	
	//Method for clicking on the book page
	public void goToBookPage(){
		if(isDisplayed(bookLocator)){
			click(bookLocator);
		}else {
			System.out.println("Go to book store button was not present");
		}
	}

}