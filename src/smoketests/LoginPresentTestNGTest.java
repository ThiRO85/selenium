package smoketests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.DriverFactory;

import static org.testng.Assert.*;

public class LoginPresentTestNGTest {
    WebDriver driver;

    @Test
    public void loginElementsPresentTest() {
        System.out.println("Running test");
        boolean loginEmailBox = driver.findElement(By.name("login")).isDisplayed();
        boolean passwordBox = driver.findElement(By.name("password")).isDisplayed();
        Assert.assertTrue(loginEmailBox, "Email textBox present");
        Assert.assertTrue(passwordBox, "Password textBox present");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("Starting test");
        String webURL = "https://github.com/login";
        driver = DriverFactory.open("chrome");
        driver.get(webURL);
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Closing test");
        driver.close();
    }
}