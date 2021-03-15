package tests;

import org.openqa.selenium.WebDriver;
import pages.LoginPageFactory;

public class LoginFactory {

    String userName = "thgr85@gmail.com";
    String password = "biakugam10";

    public void loginTestPageFactory() {
        // 1. Initialize driver
        WebDriver driver = utilities.DriverFactory.open("Chrome");
        driver.get("https://github.com/login");

        // 2. Enter login
        LoginPageFactory loginPageFactory = new LoginPageFactory(driver);
        loginPageFactory.login(userName, password);
    }
}
