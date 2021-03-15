package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.DriverFactory;

public class NewAccount {

    public static void main(String[] args) {

        String name = "Mary Smith";
        String email = "mary95@gmail.com";
        String password = "abeagogo10";
        String address = "06045-360";
        String function = "developer";
        String browserType = "chrome";
        // String gender = "female";
        // boolean weeklyEmail = true;
        // boolean monthlyEmail = false;
        // boolean occasionalEmail = false;

        // 1. Define webdriver
        WebDriver driver;
        driver = DriverFactory.open(browserType);

        // 2. Open browser to account management page -> Click on create account
        driver.get("https://login.infojobs.com.br/cadastrar-curriculo.aspx");
        // https://login.infojobs.com.br/cadastrar-curriculo.aspx

        // Define WebElements
        WebElement nameElement = driver.findElement(By.name("NameAndSurname"));
        WebElement emailElement = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
        WebElement passwordElement = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/form/div[1]/div[3]/input"));
        WebElement addressElement = driver.findElement(By.name("CEP"));
        WebElement functionElement = driver.findElement(By.cssSelector("input[type='text'][id='Job']"));
        // WebElement maleRadio = driver.findElement(By.id(" "));
        // WebElement femaleRadio = driver.findElement(By.id(" "));
        // WebElement weeklyCheckBox = driver.findElement(By.name(" "));

        driver.findElement(By.id("AllowCookiesButton")).click();
        // driver.findElement(By.linkText("Cadastrar CV")).click();

        // 3. Fill out the form
        // How to locate elements
        nameElement.sendKeys(name);
        emailElement.sendKeys(email);
        // relative xpath:  //*[@id="Email"]
        passwordElement.sendKeys(password);
        // full xpath: /html/body/div[1]/div/div[2]/div[2]/div/form/div[1]/div[3]/input
        addressElement.sendKeys(address);
        functionElement.sendKeys(function);
        // cssSelector: input[atribute='value']

        // How to interact with others HTML elements:
        // Drop down menu:
        // new Select(driver.findElement(By.id(" ")))selectByVisibleText(" ");
        // new Select -> import org.openqa.selenium.support.ui.Select;

        // Gender radio button algorithm:
        // if (gender.equalsIgnoreCase("male") {
        // maleRadio.click();
        //}
        // else {
        // femaleRadio.click();
        // }

        // Check box algorithm:
        // if (weeklyEmail) {
        //    if (!weeklyCheckBox.isSelected()) {
        //    weeklyCheckBox.click();
        //   }
        // }
        // else {
        //    if (weeklyCheckBox.isSelected()) {
        //    weeklyCheckBox.click();
        //   }
        // }

        driver.findElement(By.xpath("//*[@id=\"MainForm\"]/div[1]/div[6]/div/label/a[1]")).click();

        // 4. Get confirmation
        // String confirmation = driver.findElement(By.xpath("/html/body/main/div/div/div/div[1]")).getText();
        // String expected = "anything";
        // if (confirmation.equals(expected)) {
        // System.out.println("Confirmation: " + confirmation);
        // }
        // else {
        // System.out.println("Test failed");
        // }

        // 5. Close the browser
        // driver.close();
    }
}
