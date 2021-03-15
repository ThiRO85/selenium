package smoketests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utilities.DriverFactory;

public class PageTitleJUnit {
    // 1. Declare the variables and objets at Class level in order to access in multiples methods through program

    WebDriver driver;
    String webURL = "https://login.infojobs.com.br/cadastrar-curriculo.aspx";

    @Test
    public void pageTitleTest() {
        System.out.println("Running the test");
        driver.get(webURL);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Cadastrar Curriculo GRÁTIS | Infojobs";
        Assert.assertEquals(expectedTitle, actualTitle);
        //Assert.fail("We intentionally failed this test");
    }

    @Before
    public void setUp() {
        System.out.println("Initializing the driver");
        driver = DriverFactory.open("chrome");
    }

    @After
    public void tearDown() {
        System.out.println("Closing the driver");
        driver.close();
    }
}
