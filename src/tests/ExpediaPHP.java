package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExpediaPHP {

    WebDriver driver;
    String browserType = "chrome";
    String city = "New York";
    //String checkIn = " ";
    //String checkOut = " ";
    //String numOfGuests = " ";
    //String starRating = "star4";

    @Test
    public void hotelReservation() {
        // 1. Search
        driver.findElement(By.xpath("//*[@id=\"search\"]/div/div/div/div/div/nav/ul/li[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"s2id_autogen16\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/div/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/div/input")).sendKeys(city);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul/li/ul/li/div/span")).sendKeys(Keys.RETURN);
        driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul/li/ul/li/div/span")).click();
        //driver.findElement(By.id(" ")).sendKeys(checkIn);
        //driver.findElement(By.id(" ")).sendKeys(checkOut);
        //new Select(driver.findElement(By.xpath(" "))).selectByValue(numOfGuests); -> drop down menu
        driver.findElement(By.xpath("//*[@id=\"hotels\"]/div/div/form/div/div/div[3]/div/div/div/div/div/div/div[1]/div/div[2]/div/span/button[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"hotels\"]/div/div/form/div/div/div[3]/div/div/div/div/div/div/div[2]/div/div[2]/div/span/button[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"hotels\"]/div/div/form/div/div/div[4]/button")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String actualCity = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/section/div/div[2]/div[2]/div/div[1]/div[1]/h3/span[2]")).getText();
        System.out.println("CITY: " + actualCity);

        // 2. Modify the search results page, give criteria
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.findElement(By.cssSelector("/html/body/div[2]/div[1]/div[1]/section/div/div[2]/div[1]/aside/div[2]/button")).click();
        //driver.findElement(By.cssSelector("input[name='star'][id='" + starRating + "']")).click();

        // 3. Analyze the results and make our selection

        // 4. Book reservation

        // 5. Fill out contact / billing

        // 6. Get confirmation
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Search Results"));
    }

    @BeforeMethod
    public void setUp() {
        driver = utilities.DriverFactory.open(browserType);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.phptravels.net/");
        //WebDriverWait wait = new WebDriverWait(driver, 15);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"checkin\"]")));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
