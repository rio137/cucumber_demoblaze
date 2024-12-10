package StepDefinitions;
import org.openqa.selenium.Alert;
//import io.cucumber.core.cli.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.cucumber.java.en.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.junit.*;

public class loginSteps {

	WebDriver driver = null;

	public loginSteps() {
		System.setProperty("webdriver.gecko.driver", "D:/java files/Eclipse/All projects/BlazeDemoCucumber/src/test/resources/driver/geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@Given("user is on login pop up")
	public void user_is_on_login_pop_up() throws InterruptedException {

		driver.get("https://www.demoblaze.com/");

		driver.findElement(By.id("login2")).click();

		Thread.sleep(3000);
	}

	@When("^user enters valid (.*) and valid (.*)$")
	public void user_enters_valid_username_and_valid_password(String username, String password) throws InterruptedException {

		driver.findElement(By.id("loginusername")).sendKeys(username);
		Thread.sleep(3000);

		driver.findElement(By.id("loginpassword")).sendKeys(password);
	}

	@And("clicks on login button")
	public void clicks_on_login_button() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();

	}

	@Then("^(.*) is navigated to the home page$")
	public void user_is_navigated_to_the_home_page(String username) throws InterruptedException {

		Thread.sleep(3000);

		String nameOfUser = driver.findElement(By.id("nameofuser")).getText();
		String expectedUsername = "Welcome "+username;
		Assert.assertEquals(nameOfUser, expectedUsername);

		Thread.sleep(2000);
		driver.close();
	}

	@When("^user enters valid (.*) and invalid (.*)$")
	public void user_enters_valid_username_and_invalid_password(String username, String password) throws InterruptedException {
		driver.findElement(By.id("loginusername")).sendKeys(username);
		Thread.sleep(3000);

		driver.findElement(By.id("loginpassword")).sendKeys(password);

	}
	
	
	@Then("user will still be inside the login pop up with wrong password")
	public void user_will_still_be_inside_the_login_pop_up_with_wrong_password() throws InterruptedException {
		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		String alertTextActual = "Wrong password.";
		Assert.assertEquals(alertText, alertTextActual);
		alert.accept();

		Thread.sleep(2000);
		driver.close();
	}
	
	
	
	@When("^user enters invalid (.*) and valid (.*)$")
	public void user_enters_invalid_username_and_valid_password(String username, String password) throws InterruptedException {

		driver.findElement(By.id("loginusername")).sendKeys(username);
		Thread.sleep(3000);

		driver.findElement(By.id("loginpassword")).sendKeys(password);

	}
	

	@Then("user will still be inside the login pop up with invalid username")
	public void user_will_still_be_inside_the_login_pop_up() throws InterruptedException {
		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		String alertTextActual = "User does not exist.";
		Assert.assertEquals(alertText, alertTextActual);
		alert.accept();

		Thread.sleep(2000);
		driver.close();
	}
	
	@When("^user enters invalid (.*) and invalid (.*)$")
	public void user_enters_invalid_username_and_invalid_password(String username, String password) throws InterruptedException {

		driver.findElement(By.id("loginusername")).sendKeys(username);
		Thread.sleep(3000);

		driver.findElement(By.id("loginpassword")).sendKeys(password);

	}
	

	@Then("user will still be inside the login pop up with both invalid username and password")
	public void user_will_still_be_inside_the_login_pop_up_with_both_invalid_username_and_password() throws InterruptedException {
		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		String alertTextActual = "User does not exist.";
		Assert.assertEquals(alertText, alertTextActual);
		alert.accept();

		Thread.sleep(2000);
		driver.close();
	}

}
