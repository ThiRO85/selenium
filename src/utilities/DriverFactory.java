package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
    // this method return a WebDriver object
    public static WebDriver open(String browserType) {
        if (browserType.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
            System.out.println("Using Chrome");
            return new ChromeDriver();
        }
        else if (browserType.equalsIgnoreCase("brave")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions().setBinary("C:\\Selenium\\BraveBrowserSetup32.exe");
            System.out.println("Using Brave");
            return new ChromeDriver(options);
        }
        else if (browserType.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
            System.out.println("Using Firefox");
            return new FirefoxDriver();
        }
        else {
            System.setProperty("webdriver.ie.driver", "C:\\Selenium\\IEDriverServer.exe");
            System.out.println("Using Internet Explorer");
            return new InternetExplorerDriver();
        }
    }
}
