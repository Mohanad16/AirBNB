package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class SelenuimBase {

    public static WebDriver driver;
    static WebDriverWait wait;

    public WebDriver seleniumConfig(String baseURL) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
        driver.manage().timeouts().getPageLoadTimeout();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        return driver;


    }

    public void waitForElementToBeVisible(By locator, int durationInSeconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementToBeClickable(By locator, int durationInSeconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
