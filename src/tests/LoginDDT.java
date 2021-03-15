package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDDT {

    WebDriver driver;

    @Test(dataProvider = "getData")
    public void loginTest(String name, String email, String password) {
        // Find the elements
        driver.findElement(By.name("login")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("commit")).click();
    }

    @BeforeMethod
    public void setUp() {
        // Define the webdriver
        driver = utilities.DriverFactory.open("chrome");
        driver.get("https://github.com/login");
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }

   @DataProvider
    public Object[] getData() {
       return utilities.Excel.get("C:\\temp\\UserLogin.xls");
    }
}
