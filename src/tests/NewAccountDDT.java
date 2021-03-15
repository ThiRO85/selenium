package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@RunWith(value = Parameterized.class)
public class NewAccountDDT {

    String name, email, password, address, function, readAndAccept;
    // boolean occasionalEmail;
    WebElement nameElement, emailElement, passwordElement, addressElement, functionElement, readAndAcceptElement;
    WebDriver driver;

    // This is our test method
    @Test
    public void newAccountTest() {
        System.out.println("NEW RECORDS: " + name + ", " + email + ", " + password + ", " + address
                + ", " + function + ", " + readAndAccept);

        // Define web elements
        defineWebElements();

        // Fill out the form
        nameElement.sendKeys(name);
        emailElement.sendKeys(email);
        passwordElement.sendKeys(password);
        addressElement.sendKeys(address);
        functionElement.sendKeys(function);
        readAndAcceptElement.click();

        // 4. Get confirmation
        // String confirmation = driver.findElement(By.xpath("/html/body/main/div/div/div/div[1]")).getText();
        // System.out.println("Confirmation: " + confirmation);
    }

    @Before
    public void setUp() {
        driver = utilities.DriverFactory.open("chrome");
        driver.get("https://login.infojobs.com.br/cadastrar-curriculo.aspx");
        driver.findElement(By.id("AllowCookiesButton")).click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public void defineWebElements() {
        // Define web elements
        nameElement = driver.findElement(By.name("NameAndSurname"));
        emailElement = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
        passwordElement = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/form/div[1]/div[3]/input"));
        addressElement = driver.findElement(By.name("CEP"));
        functionElement = driver.findElement(By.cssSelector("input[type='text'][id='Job']"));
        readAndAcceptElement = driver.findElement(By.xpath("//*[@id=\"MainForm\"]/div[1]/div[6]/div/label/a[1]"));
    }

    // This annotated method is designed to pass parameters into the class via constructor
    @Parameterized.Parameters
    public static List<String[]> getData() {
        return utilities.CSV.get("C:\\temp\\newAccounts.txt");
    }

    // Constructor that passes parameters to the test method
    public NewAccountDDT(String name, String email, String password, String address, String function, String readAndAccept) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.function = function;
        this.readAndAccept = readAndAccept;

        /*
        if (readAndAccept.equals("TRUE")) {
            this.readAndAccept = true;
        } else {
            this.readAndAccept = false;
        }

        if (occasionalEmail.equals("FALSE")) {
            this.occasionalEmail = true;
        } else {
            this.occasionalEmail = false;
        }
        */
    }
}
