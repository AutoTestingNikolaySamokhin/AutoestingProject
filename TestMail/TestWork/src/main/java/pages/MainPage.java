package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainPage {

    private WebDriver driver;
    private WebDriverWait driverWait;

    @FindBy(id = "mailbox:password")
    WebElement password;
    @FindBy(name = "login")
    WebElement userName;
    @FindBy(id = "mailbox:submit")
    WebElement loginClickButton;


    public MainPage(WebDriver driver) {
        this.driver = driver;
        driverWait = new WebDriverWait(driver, 15, 3000);
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    public WebDriver getDriver() {

        return driver;
    }

    public void searchUserName(String query) {

        userName.sendKeys(query);

    }


    public void searchPassword(String query) {

        password.sendKeys(query);
    }


    public void searchLoginClickButton() {
        loginClickButton.click();
    }


}