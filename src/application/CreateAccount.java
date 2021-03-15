package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CreateAccount {

    public static void main(String[] args) {

        // 1. Create webdriver
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // 2. Open browser to account management page -> Click on create account
        driver.get("https://login.infojobs.com.br/cadastrar-curriculo.aspx");
        // https://www.infojobs.com.br/

        driver.findElement(By.id("AllowCookiesButton")).click();
        //driver.findElement(By.linkText("Cadastrar CV")).click();

        // 3. Fill out the form
        // How to locate elements
        driver.findElement(By.name("NameAndSurname")).sendKeys("Mary Smith");
        driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("mary95@gmail.com");
        // relative xpath:  //*[@id="Email"]
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/form/div[1]/div[3]/input")).sendKeys("abeagogo10");
        // full xpath: /html/body/div[1]/div/div[2]/div[2]/div/form/div[1]/div[3]/input
        driver.findElement(By.name("CEP")).sendKeys("06045-360");
        driver.findElement(By.cssSelector("input[type='text'][id='Job']")).sendKeys("Developer");
        // cssSelector: input[atribute='value']

        // How to interact with others HTML elements
        // to drop down menu: new Select(driver.findElement(By.id(" ")))selectByVisibleText(" ");
        // new Select -> import org.openqa.selenium.support.ui.Select;

        driver.findElement(By.xpath("//*[@id=\"MainForm\"]/div[1]/div[6]/div/label/a[1]")).click();

        // Switch the window to the pop
        List<String> windows = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));

        // 4. Get confirmation
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String confirmation = driver.findElement(By.xpath("/html/body/main/div/div/div/div[1]")).getText();
        System.out.println("Confirmation: " + confirmation);

        // 5. Close the browser
        driver.close();
    }
}
