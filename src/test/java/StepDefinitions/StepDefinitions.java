package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

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
        
        //driver.manage().window().setSize(new Dimension(1552, 840));

	}

	@When("I have entered {string} into the signup")
	public void i_have_entered_email_into_the_signup(String string)  { 
      
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
	    driver.findElement(By.id("onetrust-accept-btn-handler")).click();
	    
	    
	    driver.findElement(By.id("email")).sendKeys(string);		
		
	}
	
	@When("User enters {string} and {string}")
	public void user_enters_username_and_password(String string, String string2) {

	//fungerande inloggning
	if (string.equals("randomuser")) {
		WebElement username = driver.findElement(By.id("new_username"));
		Random rand = new Random();
		int rand_int1 = rand.nextInt(1000);
		username.sendKeys("Noor" +rand_int1);
		
	}
	
	//användare finns redan
	else if (string.equals("noemailuser")) {
	WebElement username = driver.findElement(By.id("new_username"));
	username.sendKeys("noemailuser");
		
	}
	
	//100+ tecken
	else if (string.equals("longuser")) {
	WebElement username = driver.findElement(By.id("new_username"));
	username.sendKeys("Jjjjjjjjjjjjjjjjjjjjjjsdkkkkkkkkkkkkkkknnnnnnnnnnnnnnnttttttttttttttttrr4554545ffffffffdddvgferterwfvddfg");}
		
	//användare finns redan
	else if (string.equals("alreadytaken")) {
	WebElement username = driver.findElement(By.id("new_username"));
	username.sendKeys("alreadytaken");
	
	}
	
	

	//Password
	WebElement password = driver.findElement(By.id("new_password"));
	password.sendKeys(string2);
	
	password.submit();

		
	}

	@When("I press sign up")
	public void i_press_sign_up() {
		
	WebElement CreateButton = driver.findElement(By.id("create-account")); {
	CreateButton.click(); }
	   
		}


	@Then("I should be signed up {string}")
	public void i_should_be_signed_up(String result) {
		
		
	    assertEquals(driver.findElement(By.className("invalid-error")).getText(), is ("Please enter a value"));

	    assertEquals(driver.findElement(By.className("invalid-error")).getText(), is ("Another user with this username already exists. Maybe it's your evil twin. Spooky."));
	    
	    assertEquals(driver.findElement(By.className("invalid-error")).getText(), is ("Enter a value less than 100 characters long"));
		

        
	if(driver.getCurrentUrl().equalsIgnoreCase( 
				
     "https://login.mailchimp.com/signup/")){
      System.out.println("Test Pass"); 
	    } else { 
      System.out.println("Test Failed"); 
			      } 
	  driver.close(); 
			      
			 	
	}

	private Object is(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
