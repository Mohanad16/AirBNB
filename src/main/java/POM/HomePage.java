package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Actions;
import utilities.Locators;
import utilities.SelenuimBase;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HomePage extends SelenuimBase {
    public void closePopup(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By popup = By.xpath("//span[@class='i9dqh6z dir dir-ltr']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(popup));

        WebElement close = driver.findElement(popup);
        close.click();
    }

    public void searchSteps(String country, int checkInDate, int checkOutDate) throws InterruptedException {
        Actions actions = new Actions();
        Locators locators = new Locators();

        actions.click(locators.country);
        actions.sendKeys(locators.SearchCountry, country);
        Thread.sleep(1000);
        actions.click(locators.SelectCountry);
        actions.click(locators.checkInDate(checkInDate));
        actions.click(locators.checkoutDate(checkOutDate));
        Thread.sleep(2000);
        actions.click(locators.addGuests);
        actions.click(locators.adults);
        actions.click(locators.adults);
        actions.click(locators.child);
        actions.click(locators.search);

       Thread.sleep(2000);
        actions.click(locators.filter);
        Thread.sleep(2000);

        actions.click(locators.BedRooms);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 1000)");
        Thread.sleep(2000);
        actions.click(locators.showMore);
        actions.click(locators.pool);
        actions.click(locators.confirm);
    }

    public String checkCountry() {
        Actions actions = new Actions();
        Locators locators = new Locators();
        String CountryText= actions.assertCountry(locators.verifyCountry);
        return CountryText;
    }

    public String checkDate() {
        Actions actions = new Actions();
        Locators locators = new Locators();
        String dateText= actions.assertCountry(locators.verifyDate);
        return dateText;
    }

    public String checkGuests() {
        Actions actions = new Actions();
        Locators locators = new Locators();
        String GuestsNumber= actions.assertCountry(locators.verifyGuest);
        return GuestsNumber;
    }


}
