package stepImplementations;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BDDLoginTest {

    WebDriver driver;

    @Given("^user is on the login page$")
    public void userIsOnTheLoginPage() {
        System.out.println("User is on the login page");
        driver = utilities.DriverFactory.open("chrome");
        driver.get("https://github.com/login");
    }

    @When("^user enters correct username and correct password$")
    public void userEntersCorrectUsernameAndCorrectPassword() {
        System.out.println("User enters correct username and correct password");
        driver.findElement(By.name("login")).sendKeys("floyd@gmail.com");
        driver.findElement(By.name("password")).sendKeys("floydpass");
        driver.findElement(By.name("commit")).click();
        //String conf = driver.findElement(By.xpath("/html/body/div[4]/div/aside[1]/div[2]/div[2]/h2")).getText();
        //System.out.println("CONFIRMATION: " + conf);
        //Assert.assertTrue(conf.contains("Working"));
    }

    @When("^user enters email (.*)$")
    public void userEntersUsername(String username) {
        System.out.println("TESTING: " + username);
        driver.findElement(By.name("login")).sendKeys(username);
    }

    @And("^user enters password (.*)$")
    public void userEntersPassword(String password) {
        System.out.println("TESTING: " + password);
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @And("^user clicks login button$")
    public void userClicksLoginButton() {
        driver.findElement(By.name("commit")).click();
    }

    @Then("^user gets confirmation$")
    public void userGetsConfirmation() {
        System.out.println("User gets confirmation");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
