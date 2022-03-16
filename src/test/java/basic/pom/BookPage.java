package basic.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BookPage extends Base{

	By addBookLocator = By.xpath("//button[text()='Add To Your Collection']");
	By profilePageLocator = By.xpath("//span[text()='Profile']");
	
	public BookPage(WebDriver driver) {
		super(driver);
	}
	
	public void addBook(){
		if(isDisplayed(addBookLocator)){
			click(addBookLocator);
		}else {
			System.out.println("Add book button was not present");
		}
	}
	
	public void goToProfilePage(){
		if(isDisplayed(profilePageLocator)){
			click(profilePageLocator);
		}else {
			System.out.println("Go to profile page button was not present");
		}
	}
	
	
}