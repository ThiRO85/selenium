package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
    // Define web elements at class level

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"login_field\"]")
    WebElement userNameBox;

    @FindBy(xpath = "//*[@id=\"password\"]")
    WebElement passwordBox;

    @FindBy(name = "commit")
    WebElement loginButton;

    // Steps
    public void setUserName(String userName) {
        userNameBox.sendKeys(userName);
    }

    public void setPassword(String password) {
        passwordBox.sendKeys(password);
    }

    public void clickSubmit() {
        loginButton.click();
    }

    // Actions
    public void login(String userName, String password) {
        setUserName(userName);
        setPassword(password);
        clickSubmit();
    }

    // Constructor initializes the state of the driver
    public LoginPageFactory(WebDriver driver) {
        this.driver = driver;

        // Initialize web elements
        PageFactory.initElements(driver, this);
    }
}
