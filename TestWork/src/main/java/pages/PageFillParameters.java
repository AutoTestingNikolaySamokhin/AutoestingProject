package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageFillParameters {
    WebDriver driver;


    public void getDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void writeWordsMail(String words) {
        String path = "//*[@id=\"compose_to\"]";
        WebElement webElement;
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("document.getElementsByName('To')[0].setAttribute('type', 'text');");
        jse.executeScript("document.getElementsByName('To')[0].setAttribute('value', '" + words + "');");
        for (int i = 0; i < 1000000; i++) {
        }
        webElement = driver.findElement(By.xpath(path));
        webElement.sendKeys(words);
        jse.executeScript("document.getElementsByName('To')[0].setAttribute('type', 'hidden');");
    }



    public void writeWordsBody(String words) {
        String path = "tinymce";
        String pathFrame = ".//tr[@class='mceFirst mceLast']//iframe";
        WebElement webElement;
        driver.switchTo().frame(driver.findElement(By.xpath(pathFrame)));
        webElement = driver.findElement(By.id(path));
        webElement.click();
        webElement.clear();
        webElement.sendKeys(words);
        driver.switchTo().defaultContent();
    }


    public void clickOnSendMail() {
        String path = "(.//div/descendant::span[@class=\"b-toolbar__btn__text\"])[1]";
        WebElement webElement = driver.findElement(By.xpath(path));
        new Actions(driver).click(webElement).build().perform();
    }


    public void clickButtonWrite() {
        String path = "(.//div/descendant::span[@class=\"b-toolbar__btn__text b-toolbar__btn__text_pad\"])[1]";
        WebElement webElement = (new WebDriverWait(driver, 10)
            .until(ExpectedConditions.elementToBeClickable(By.xpath(path))));
        new Actions(driver).click(webElement).build().perform();
    }
}
