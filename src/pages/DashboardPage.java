package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    WebDriver driver;

    public String confirmationMessage() {
        return driver.findElement(By.xpath("/html/body/div[4]/div/aside[1]/div[2]/div[2]/h2")).getText();
    }

    public void pulls() {
        driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/nav/a[2]")).click();
    }

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }
}
