package smoketests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.DriverFactory;

import java.util.List;

public class ATagsTest {
    WebDriver driver;

    @Test
    public void loginElementsPresentTest() {
        System.out.println("Running test");
        boolean createAnAccountPresent = false;

        // We want to test the presence of A tags >> hiperlinks
        List <WebElement> aElements = driver.findElements(By.tagName("a"));
        // int numberOfAElements = aElements.size();
        // System.out.println("There are " + numberOfAElements + " a tags on the page");
        for (WebElement aElement : aElements) {
            // System.out.println(aElement.getText());
            if (aElement.getText().equals("Create an account")) {
                createAnAccountPresent = true;
                break;
            }
        }
        // Assertion
        Assert.assertTrue(createAnAccountPresent);
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