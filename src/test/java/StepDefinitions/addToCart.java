package StepDefinitions;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.*;
import junit.framework.Assert;

public class addToCart {
	
	WebDriver driver = null;
	

	public addToCart() {
		System.setProperty("webdriver.gecko.driver", "D:/java files/Eclipse/All projects/BlazeDemoCucumber/src/test/resources/driver/geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	@Given("user is on login pop up for each steps")
	public void user_is_on_login_pop_up_for_each_steps() throws InterruptedException {
		
		
			driver.get("https://www.demoblaze.com/");

			driver.findElement(By.id("login2")).click();

			Thread.sleep(3000);
		
		
		
		
	}
	
	@When("user enters valid credentials {string} and {string}")
	public void user_enters_valid_user1010_and_valid_pass1(String username, String password) throws InterruptedException {
		
		
			driver.findElement(By.id("loginusername")).sendKeys(username);
			Thread.sleep(3000);

			driver.findElement(By.id("loginpassword")).sendKeys(password);
	
		
		
	}
	
	@And("click on login button")
	public void click_on_login_button() throws InterruptedException {
		
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
			
		
		
	}
	
	@Then("User is navigated to the home page for add to cart")
	public void User_is_navigated_to_the_home_page_for_add_to_cart() throws InterruptedException {
		
		
			Thread.sleep(4000);
			String ExpectedLogoutText =  driver.findElement(By.id("logout2")).getText();
			String ActualLogoutText = "Log out";
		    Assert.assertEquals(ExpectedLogoutText, ActualLogoutText);
		    
		
		
		
	}
	
	
	@When("scroll down")
	public void scroll_down() throws InterruptedException {

		Thread.sleep(2000);
		JavascriptExecutor scrolldown = (JavascriptExecutor) driver;
		scrolldown.executeScript("window.scrollBy(0,500)");
	}

	@And("^clicks on a product (.*)$")
	public void clicks_on_a_product_productNumber(int productNumber) {
		// Get all product elements (using the class 'hrefch' as a selector for product names)
        List<WebElement> products = driver.findElements(By.className("hrefch"));


        
        int productIndex = productNumber; 
        if (productIndex < products.size()) {
            products.get(productIndex).click();
        } else {
            System.out.println("Product index out of range.");
        }

        
	}

	@And("clicks on add to cart button")
	public void clicks_on_add_to_cart_button() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(By.linkText("Add to cart")).click();
	    
	}

	@Then("there will be a pop up that product added")
	public void there_will_be_a_pop_up_that_product_added() throws InterruptedException {
		
		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();
		String actualaddedText = alert.getText();
		String expectedaddedText = "Product added.";
		Assert.assertEquals(actualaddedText, expectedaddedText);
		alert.accept();

		Thread.sleep(2000);
		driver.close();
	    
	}

	


}
