package basic.pom;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import org.junit.Assert;

public class AddBook_Test {
	
	private WebDriver driver;
	LogInPage logInPage;
	BookStorePage bookStorePage;
	ProfilePage profilePage;
	BookPage bookPage;
	
	@Before
	public void setUp(){
		//Creating the pages with the same driver
		logInPage = new LogInPage(driver);
		driver = logInPage.chromeDriverConnection();
		bookStorePage = new BookStorePage(driver);
		profilePage = new ProfilePage(driver);
		bookPage = new BookPage(driver);
		
		//Visiting the DemoQA login page
		logInPage.visit("https://demoqa.com/login/");
	}
	
	@Test
	public void test() throws InterruptedException {
		//Logging in
		logInPage.logIn();
		Thread.sleep(2000);
		//Making sure that the correct username is displayed
		assertEquals("luistovar", profilePage.getUserNameDisplayed());
		Thread.sleep(2000);
		//Navigating to the book store page
		profilePage.goToBookStore();
		Thread.sleep(2000);
		//Navigating to the book's page
		bookStorePage.goToBookPage();
		Thread.sleep(2000);
		//Adding the book to the collection
		bookPage.addBook();
		Thread.sleep(2000);
		//Making sure that the pop-up alert is correctly displayed, and accepting it
		Assert.assertEquals("Book added to your collection.", bookPage.GetAlertText());
		bookPage.AcceptAlert();
		Thread.sleep(2000);
		//Navigating to the profile page
		bookPage.goToProfilePage();
		Thread.sleep(2000);
		//Making sure that the book was added
		Assert.assertTrue(profilePage.isDisplayed(profilePage.bookLocator));
	}
	
	@After
	public void tearDown() throws Exception{
		//Closing the driver
		driver.quit();
	}
	

}
