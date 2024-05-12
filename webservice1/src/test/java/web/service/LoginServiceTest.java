package web.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginServiceTest {
	
	private void sleep(long sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testLoginSuccess() {
		System.setProperty(
				"webdriver.chrome.driver", 
				"C:\\Users\\markd\\Desktop\\Rzeczy\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();		
		System.out.println("Driver info: " + driver);
		
		// Full path where login.html is located.
		// You can click on html file and copy the path shown in your browser.
		//
		driver.navigate().to(
				"file:///C:/Users/markd/Desktop/Master_In_IT/SIT707%20Software%20Quality%20and%20Testing/8.1P-resources/pages/login.html");
		sleep(5);
		
		// Find username element
		//
		WebElement ele = driver.findElement(By.id("username"));
		ele.clear();
		ele.sendKeys("ahsan");
		
		// Find password element
		//
		ele = driver.findElement(By.id("passwd"));
		ele.clear();
		ele.sendKeys("ahsan_pass");
		
		// Find dob element
		ele = driver.findElement(By.id("dob"));
		ele.clear();
		ele.sendKeys("1990-01-01");
		
		// Find Submit button, and click on button.
		//
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.submit();
		
		sleep(5);
		
		/*
		 * On successful login, the title of page changes to 'success',
		 * otherwise, 'fail'.
		 */
		String title = driver.getTitle();
		System.out.println("Title: " + title);
		
		Assert.assertEquals(title, "success");
		
		driver.close();
	}
	
	@Test
	public void testLoginFailure() {
	    System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\markd\\Desktop\\Rzeczy\\chromedriver-win64\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    
	    driver.navigate().to("file:///C:/Users/markd/Desktop/Master_In_IT/SIT707%20Software%20Quality%20and%20Testing/8.1P-resources/pages/login.html");
	    sleep(5);
	    
	    WebElement username = driver.findElement(By.id("username"));
	    username.clear();
	    username.sendKeys("wrong_username");
	    
	    WebElement password = driver.findElement(By.id("passwd"));
	    password.clear();
	    password.sendKeys("wrong_password");
	    
	    WebElement dob = driver.findElement(By.id("dob"));
	    dob.clear();
	    dob.sendKeys("1990-01-01");
	    
	    WebElement submitBtn = driver.findElement(By.cssSelector("[type=submit]"));
	    submitBtn.submit();
	    
	    sleep(5);
	    
	    String title = driver.getTitle();
	    System.out.println("Title: " + title);
	    
	    Assert.assertEquals(title, "fail");
	    
	    driver.close();
	}
	
	@Test
	public void testFieldValidations() {
	    System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\markd\\Desktop\\Rzeczy\\chromedriver-win64\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    
	    driver.navigate().to("file:///C:/Users/markd/Desktop/Master_In_IT/SIT707%20Software%20Quality%20and%20Testing/8.1P-resources/pages/login.html");
	    sleep(5);
	    
	    // Test with empty username
	    WebElement username = driver.findElement(By.id("username"));
	    username.clear();
	    
	    WebElement password = driver.findElement(By.id("passwd"));
	    password.clear();
	    password.sendKeys("valid_password");
	    
	    WebElement dob = driver.findElement(By.id("dob"));
	    dob.clear();
	    dob.sendKeys("1990-01-01");
	    
	    WebElement submitBtn = driver.findElement(By.cssSelector("[type=submit]"));
	    submitBtn.click();
	    
	    sleep(5);
	    
	    
	    String title = driver.getTitle();
	    Assert.assertNotEquals("success", title);
	    
	    driver.close();
	}
	
}
