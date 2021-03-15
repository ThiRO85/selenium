package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

public class Login {

    @Test
    public void loginTestPOM() {

        // 1. Initialize driver
        WebDriver driver = utilities.DriverFactory.open("Chrome");
        driver.get("https://github.com/login");

        // 2. Enter login information (Login Page)
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("thgr85@gmail.com");
        loginPage.setPassword("biakugam10");
        loginPage.clickSubmit();

        // 3. Get confirmation (Dashboard Page)
        DashboardPage dashboardPage = new DashboardPage(driver);
        String conf = dashboardPage.confirmationMessage();
        System.out.println("CONFIRMATION: " + conf);

        // 4. Assertion
        Assert.assertTrue(conf.contains("Working"));

        // 5. Close the driver
        driver.quit();
    }
}
