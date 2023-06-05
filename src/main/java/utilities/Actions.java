package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Actions extends SelenuimBase {


    public void click(By path) throws InterruptedException {
        Thread.sleep(500);
        WebElement ClickButton = driver.findElement(path);
        ClickButton.click();

    }

    public void sendKeys(By path, String value) throws InterruptedException {
        Thread.sleep(500);
        WebElement SendText = driver.findElement(path);
        SendText.sendKeys(value);

    }

    public String getText(By path) throws InterruptedException {
        Thread.sleep(200);
        WebElement GetText = driver.findElement(path);
        return GetText.getText();

    }


    public void scroll(int scrollHeight) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, arguments[0])", scrollHeight);

    }

}
