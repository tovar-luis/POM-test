package basic.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Base {
	private WebDriver driver;
	
	public Base(WebDriver driver) {
		this.driver = driver;
	}
	
	//Creating the driver
	public WebDriver chromeDriverConnection() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		return driver;
	}
	
	//Find element method
	public WebElement findElement(By locator){
		return driver.findElement(locator);
		
	}
	
	//SendKeys method
	public void type(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
	}
	
	//Click method
	public void click(By locator) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", driver.findElement(locator));
	}
	
	//Go to URL method
	public void visit(String url) {
		driver.get(url);
	}
	
	//Checking if an element is displayed method
	public boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	
	//Get an element's text method
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	//Clicking on the accept button on alert method
	public void AcceptAlert() 
    {
    	WebDriverWait wait = new WebDriverWait(driver, 3000);
    	wait.until(ExpectedConditions.alertIsPresent());
    	Alert alert = driver.switchTo().alert();
    	alert.accept();
    }
    
    //Get an alert's text method
    public String GetAlertText() 
    {
    	WebDriverWait wait = new WebDriverWait(driver, 3000);
    	wait.until(ExpectedConditions.alertIsPresent());
    	String alertMessage = driver.switchTo().alert().getText();
    	return alertMessage;
    }
}
