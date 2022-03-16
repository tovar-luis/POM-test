package basic.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BookPage extends Base{
	
	//Locators for the add book button and the go to profile button
	By addBookLocator = By.xpath("//button[text()='Add To Your Collection']");
	By profilePageLocator = By.xpath("//span[text()='Profile']");
	
	public BookPage(WebDriver driver) {
		super(driver);
	}
	
	//Method for clicking on the add book button
	public void addBook(){
		if(isDisplayed(addBookLocator)){
			click(addBookLocator);
		}else {
			System.out.println("Add book button was not present");
		}
	}
	
	//Method for clicking on the profile button
	public void goToProfilePage(){
		if(isDisplayed(profilePageLocator)){
			click(profilePageLocator);
		}else {
			System.out.println("Go to profile page button was not present");
		}
	}
	
	
}