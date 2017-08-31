package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import tests.LoginLK_cucumber;

public class Steps {
	
	static Logger log = LogManager.getLogger(LoginLK_cucumber.class.getName());
	static WebDriver wd;
	
	@Given("^User is on the home page$")
	public void user_is_on_the_home_page() {
        PropertyConfigurator.configure("log4j.properties");
		
		System.setProperty("webdriver.gecko.driver", "/Users/tatianakesler/Desktop/Selenium/installation/geckodriver");
		wd = new FirefoxDriver();
		
		String baseURL = "http://www.letskodeit.com/";
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		wd.get(baseURL);
	    
	}

	@When("^User types valid credentials$")
	public void user_types_valid_credentials() throws InterruptedException {
		WebElement signupLink = wd.findElement(By.id("comp-iiqg1vggactionTitle"));
        signupLink.click(); 
        WebElement login = wd.findElement(By.id("signUpDialogswitchDialogLink"));
        login.click();
        WebElement userName = wd.findElement(By.id("memberLoginDialogemailInputinput"));
        userName.sendKeys("test@email.com");
        WebElement userPassword = wd.findElement(By.id("memberLoginDialogpasswordInputinput"));
        userPassword.sendKeys("abcabc");
        Thread.sleep(3000);
	}

	@When("^Clicks Go button$")
	public void clicks_Go_button() throws Throwable {
		 WebElement GoButton = wd.findElement(By.id("memberLoginDialogoklink"));
	     GoButton.click();
	}

	@Then("^Practice tab shown$")
	public void practice_tab_shown() throws Throwable {
		WebElement Practice = wd.findElement(By.id("DrpDwnMn05label"));
        Assert.assertNotNull(Practice);
        log.info("Practice tab is displayed");
	}
	
	@Then("^quit the browser$")
	public void quit_the_browser() {
		wd.quit();
	}

	@Then("^Display success message$")
	public void display_success_message() {
		log.info("Test result: PASS");
	}

}
