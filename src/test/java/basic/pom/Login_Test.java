package basic.pom;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Login_Test {
	
	//Declaration for the driver and the pages
	private WebDriver driver;
	LogInPage logInPage;
	ProfilePage profilePage;
	
	@Before
	public void setUp(){
		//Creating the pages with the same driver
		logInPage = new LogInPage(driver);
		driver = logInPage.chromeDriverConnection();
		profilePage = new ProfilePage(driver);
		
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
	}
	
	@After
	public void tearDown() throws Exception{
		//Closing the driver
		driver.quit();
	}

}
