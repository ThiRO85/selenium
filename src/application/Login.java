package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

    public static void main(String[] args) {

        // 1. Define the web drive
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // 2. Open the web browser and navigate to page
        driver.get("https://github.com/login");
        // https://github.com/login

        // Find elements: Locate the element, Determine the action, Pass any parameters

        // 3. Enter email address
        driver.findElement(By.name("login")).sendKeys("thgr85@gmail.com");

        // 4. Enter password
        driver.findElement(By.name("password")).sendKeys("biakugam10");

        // 5. Click login
        driver.findElement(By.name("commit")).click();

        // 6. Get confirmation
        String message = driver.findElement(By.id("dashboard-repos-filter-left")).getText();
        System.out.println("CONFIRMATION: " + message);

        String pageTitle = driver.getTitle();
        System.out.println("Page title: " + pageTitle);

        // 7. Close the web browser
        driver.close();
    }
}
