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
		
		
		logInPage = new LogInPage(driver);
		driver = logInPage.chromeDriverConnection();
		bookStorePage = new BookStorePage(driver);
		profilePage = new ProfilePage(driver);
		bookPage = new BookPage(driver);
		
		logInPage.visit("https://demoqa.com/login/");
	}
	
	@Test
	public void test() throws InterruptedException {
		logInPage.logIn();
		Thread.sleep(2000);
		assertEquals("luistovar", profilePage.getUserNameDisplayed());
		Thread.sleep(2000);
		profilePage.goToBookStore();
		Thread.sleep(2000);
		bookStorePage.goToBookPage();
		Thread.sleep(2000);
		bookPage.addBook();
		Thread.sleep(2000);
		Assert.assertEquals("Book added to your collection.", bookPage.GetAlertText());
		bookPage.AcceptAlert();
		Thread.sleep(2000);
		bookPage.goToProfilePage();
		Thread.sleep(2000);
		Assert.assertTrue(profilePage.isDisplayed(profilePage.bookLocator));
	}
	
	@After
	public void tearDown() throws Exception{
		driver.quit();
	}
	

}
