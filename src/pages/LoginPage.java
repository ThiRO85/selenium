package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public void setUserName(String userName) {
        driver.findElement(By.xpath("//*[@id=\"login_field\"]")).sendKeys(userName);
    }

    public void setPassword(String password) {
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
    }

    public void clickSubmit() {
        driver.findElement(By.name("commit")).click();
    }

    // Constructor initializes the state of the driver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
}
