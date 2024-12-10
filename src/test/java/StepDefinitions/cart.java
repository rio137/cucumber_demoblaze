package StepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.*;
import junit.framework.Assert;

public class cart {
	
WebDriver driver = null;
	

	public cart() {
		System.setProperty("webdriver.gecko.driver", "D:/java files/Eclipse/All projects/BlazeDemoCucumber/src/test/resources/driver/geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	
	@Given("user is on login pop up for testing cart")
	public void user_is_on_login_pop_up_for_testing_cart() throws InterruptedException {
		
		
			driver.get("https://www.demoblaze.com/");

			driver.findElement(By.id("login2")).click();

			Thread.sleep(3000);
		
		
		
		
	}
	
	@When("user enters valid credentials {string} and {string} for testing cart")
	public void user_enters_valid_user1010_and_valid_pass1_for_testing_cart(String username, String password) throws InterruptedException {
		
		
			driver.findElement(By.id("loginusername")).sendKeys(username);
			Thread.sleep(3000);

			driver.findElement(By.id("loginpassword")).sendKeys(password);
	
		
		
	}
	
	@And("click on login button for testing cart")
	public void click_on_login_button_button_for_testing_cart() throws InterruptedException {
		
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
			
		
		
	}
	
	@Then("User is navigated to the home page for testing cart")
	public void User_is_navigated_to_the_home_page_for_testing_cart() throws InterruptedException {
		
		
			Thread.sleep(4000);
			String ExpectedLogoutText =  driver.findElement(By.id("logout2")).getText();
			String ActualLogoutText = "Log out";
		    Assert.assertEquals(ExpectedLogoutText, ActualLogoutText);
		    
		
		
		
	}
	
	
	
	@Given("User clicks on cart form nav bar")
	public void user_clicks_on_cart_form_nav_bar() throws InterruptedException {
	    driver.findElement(By.id("cartur")).click();
	    Thread.sleep(4000);
	}

	@And("Clicks on place an order")
	public void clicks_on_place_an_order() throws InterruptedException {
	    //check if there is any product available inside cart or not
		// Locate the tbody element by its ID
		WebElement tbody = driver.findElement(By.id("tbodyid"));

		// Find all <tr> elements inside the tbody
		List<WebElement> rows = tbody.findElements(By.tagName("tr"));
		
		if(rows.isEmpty())
		{
			addToCart addToCart = new addToCart();
            
            addToCart.user_is_on_login_pop_up_for_each_steps();
            addToCart.user_enters_valid_user1010_and_valid_pass1("user1010","pass1");
            addToCart.click_on_login_button();
            addToCart.User_is_navigated_to_the_home_page_for_add_to_cart();
            addToCart.scroll_down();
            addToCart.clicks_on_a_product_productNumber(0);
            addToCart.clicks_on_add_to_cart_button();
            addToCart.there_will_be_a_pop_up_that_product_added();
            
           
            this.user_clicks_on_cart_form_nav_bar();
            this.clicks_on_place_an_order();
		}
		
		else {
			driver.findElement(By.xpath("//button[normalize-space()='Place Order']")).click();
			
		}
	
		//Assert.assertEquals(expectedDeleteText, actualDeleteText);
	}

	@When("pop up appeares and user inserts all the inputs")
	public void pop_up_appeares_and_user_inserts_all_the_inputs() {
		
		driver.findElement(By.id("name")).sendKeys("Fuad");
		driver.findElement(By.id("country")).sendKeys("Bangladesh");
		driver.findElement(By.id("city")).sendKeys("Dhaka");
		driver.findElement(By.id("card")).sendKeys("012344");
		driver.findElement(By.id("month")).sendKeys("January");
		driver.findElement(By.id("year")).sendKeys("2024");
	 
	}

	@And("clicks on purchase button")
	public void clicks_on_purchase_button() {
		
	   
	}

	@Then("Another pop up will be appeared for successful purchase")
	public void another_pop_up_will_be_appeared_for_successful_purchase() {
	   
	}

}
