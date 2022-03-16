package basic.pom;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Login_Test {
	
	private WebDriver driver;
	LogInPage logInPage;
	ProfilePage profilePage;
	
	@Before
	public void setUp(){
		logInPage = new LogInPage(driver);
		driver = logInPage.chromeDriverConnection();
		profilePage = new ProfilePage(driver);
		logInPage.visit("https://demoqa.com/login/");
	}
	
	@Test
	public void test() throws InterruptedException {
		logInPage.logIn();
		Thread.sleep(2000);
		assertEquals("luistovar", profilePage.getUserNameDisplayed());
	}
	
	@After
	public void tearDown() throws Exception{
		driver.quit();
	}

}
