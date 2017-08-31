package tests;

//import static org.testng.Assert.assertFalse;
//import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

//import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;


public class LoginLK_cucumber {
	
	static Logger log = LogManager.getLogger(LoginLK_cucumber.class.getName());
	
	 public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");
		
		System.setProperty("webdriver.gecko.driver", "/Users/tatianakesler/Desktop/Selenium/installation/geckodriver");
		
		WebDriver wd = new FirefoxDriver();
		
		String baseURL = "http://www.letskodeit.com/";
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		wd.get(baseURL);
		
        WebElement signupLink = wd.findElement(By.id("comp-iiqg1vggactionTitle"));
        signupLink.click();
        
        WebElement login = wd.findElement(By.id("signUpDialogswitchDialogLink"));
        login.click();
        
        WebElement userName = wd.findElement(By.id("memberLoginDialogemailInputinput"));
        userName.sendKeys("test@email.com");
        
        WebElement userPassword = wd.findElement(By.id("memberLoginDialogpasswordInputinput"));
        userPassword.sendKeys("abcabc");
        
        WebElement GoButton = wd.findElement(By.id("memberLoginDialogoklink"));
        GoButton.click();
	 
        WebElement Practice = wd.findElement(By.id("DrpDwnMn05label"));
        Assert.assertNotNull(Practice);
        log.info("test passed");
	 
//        boolean Practice = wd.findElement(By.id("DrpDwnMn05label")) != null;
//        assertTrue(Practice);
//        log.info("test passed");
        
        wd.quit();
	 
	 }
                
}
