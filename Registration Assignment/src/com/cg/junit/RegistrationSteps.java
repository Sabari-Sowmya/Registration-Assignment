package com.cg.junit;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistrationSteps {
	
	WebDriver driver=null;

@Given("^The user visits the registration page$")
public void the_user_visits_the_registration_page() throws Throwable {
    
	System.setProperty("webdriver.chrome.driver","D:\\Sabari\\chrome driver\\chromedriver.exe" );
	 driver = new ChromeDriver();
	driver.get("D:\\BDD workspace\\Registration Assignment\\src\\com\\cg\\junit\\register.html");
}
@When("^the user enters the details for registration$")
public void the_user_enters_the_details_for_registration() throws Throwable {
    
	WebElement fname = driver.findElement(By.id("firstname"));
	fname.sendKeys("sabari");
	//driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	Thread.sleep(1000);
	
	
	WebElement lname = driver.findElement(By.id("lastname"));
	lname.sendKeys("sowmya");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Thread.sleep(1000);
	
	WebElement email = driver.findElement(By.id("email"));
	email.sendKeys("sabari@gmail.com");
	Thread.sleep(1000);
	
	WebElement contact = driver.findElement(By.id("contact"));
	contact.sendKeys("9876543210");
	Thread.sleep(1000);
	
	WebElement address = driver.findElement(By.id("address"));
	address.sendKeys("Poonthotam");
	Thread.sleep(1000);
	
	WebElement city = driver.findElement(By.id("city"));
	city.sendKeys("Villupuram");
	Thread.sleep(1000);
	
	WebElement state = driver.findElement(By.xpath("/html/body/table/tbody/tr[7]/td[2]/select"));
	state.sendKeys("TamilNadu");
	Thread.sleep(1000); 
	
	WebElement register = driver.findElements(By.xpath("/html/body/table/tbody/tr[8]/td/input")).get(0);
	register.click();
	

	}
@When("^the details are validated$")
public void the_details_are_validated() throws Throwable {
	Alert alert = driver.switchTo().alert();
	System.out.println(alert.getText());
	assertEquals("Details validated", alert.getText()); 
	driver.quit();
}
@When("^the user visits the project details page$")
public void the_user_visits_the_project_details_page() throws Throwable {
	
	System.setProperty("webdriver.chrome.driver","D:\\Sabari\\chrome driver\\chromedriver.exe" );
	 driver = new ChromeDriver();
	driver.get("D:\\BDD workspace\\Registration Assignment\\src\\com\\cg\\junit\\projectdetails.html");
}

@When("^the user enters the project deatils$")
public void the_user_enters_the_project_deatils() throws Throwable {
    
	WebElement projectname = driver.findElement(By.id("projectname"));
	projectname.sendKeys("Capgemini");
	Thread.sleep(1000); 
	
	WebElement clientname = driver.findElement(By.id("clientname"));
	clientname.sendKeys("PaulHermalin");
	Thread.sleep(1000); 
	
	WebElement teamsize = driver.findElement(By.id("teamsize"));
	teamsize.sendKeys("75");
	Thread.sleep(1000); 
	
	WebElement register = driver.findElements(By.xpath("/html/body/table/tbody/tr[4]/td/input")).get(0);
	register.click();

}

@Then("^the user successfully registers the project$")
public void the_user_successfully_registers_the_project() throws Throwable {
   
	Alert alert = driver.switchTo().alert();
	System.out.println(alert.getText());
	assertEquals("Registration Successfull", alert.getText()); 
	
	driver.quit();
}
}