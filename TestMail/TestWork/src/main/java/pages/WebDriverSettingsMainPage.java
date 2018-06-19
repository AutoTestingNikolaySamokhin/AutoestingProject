package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class WebDriverSettingsMainPage {

    WebDriver driver;
    public MainPage mainPage;


    @BeforeClass
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "D:/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        mainPage.getDriver().get("https://mail.ru/");
        System.out.println("Start");

    }


    @AfterClass
    public void close() {
        if (driver != null) driver.quit();
            System.out.println("Close");
    }
}