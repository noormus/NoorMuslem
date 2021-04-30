package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import static org.junit.Assert.assertEquals;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	
	private WebDriver driver; 
	
	@Given("I have used \"(.*)\"$")
	public void i_have_used_as_a_browser(String browser) {
	    
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		   
		driver = new ChromeDriver();
        
        driver.get("https://login.mailchimp.com/signup/");
        
        driver.manage().window().setSize(new Dimension(1552, 840));

	}

	@When("I have entered {string} into the signup")
	public void i_have_entered_email_into_the_signup(String string)  { 
      
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
	    driver.findElement(By.id("onetrust-accept-btn-handler")).click();
	    
	    driver.findElement(By.id("email")).sendKeys(string);		
		
	}
	
	@When("User enters {string} and {string}")
	public void user_enters_username_and_password(String string, String string2) {

	if (string.equals("randomuser")) {
		WebElement username = driver.findElement(By.id("new_username"));
		Random rand = new Random();
		int rand_int1 = rand.nextInt(1000);
		username.sendKeys("Noor" +rand_int1);
		
	}
	
	else if (string.equals("noemailuser")) {
	WebElement username = driver.findElement(By.id("new_username"));
	username.sendKeys("noemailuser");
		
	}
	
	else if (string.equals("longuser")) {
	WebElement username = driver.findElement(By.id("new_username"));
	username.sendKeys("Jjjjjjjjjjjjjjjjjjjjjjsdkkkkkkkkkkkkkkknnnnnnnnnnnnnnnttttttttttttttttrr4554545ffffffffdddvgferterwfvddfg");}
		
	else if (string.equals("alreadytaken")) {
	WebElement username = driver.findElement(By.id("new_username"));
	username.sendKeys("alreadytaken");
	
	}
	
	WebElement password = driver.findElement(By.id("new_password"));
	password.sendKeys(string2);
	
	password.submit();

		
	}

	@When("I press sign up")
	public void i_press_sign_up() {
		
	WebElement CreateButton = driver.findElement(By.id("create-account")); {
	CreateButton.click(); }
	   
		}


		@Then("The {string} should be for {string}")
		public void the_should_be_for(String result, String user) {
			
	if (user.equals("randomuser")) {
			
		    assertEquals(driver.findElement(By.className("!margin-bottom--lv3 no-transform center-on-medium")).getText(), result);

		}
	else if (user.equals("noemailuser")) {
		
	    assertEquals(driver.findElement(By.className("invalid-error")).getText(), result);
	
	}
	else if (user.equals("longuser")) {
		
	    assertEquals(driver.findElement(By.className("invalid-error")).getText(), result);

		
	}
				
	else if (user.equals("alreadytaken")) {
		
	}
	    
	    assertEquals(driver.findElement(By.className("invalid-error")).getText(), result);
		

	    

        
	if(driver.getCurrentUrl().equalsIgnoreCase( 
				
     "https://login.mailchimp.com/signup/")){
      System.out.println("Test Pass"); 
	    } else { 
      System.out.println("Test Failed"); 
			      } 
	  driver.close(); 
			      
	
	}
	
}
