package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Actions extends SelenuimBase {


    public void click (By path){
        WebElement ClickButton = driver.findElement(path);
        ClickButton.click();

    }

    public void sendKeys(By path ,String value){
        WebElement SendText = driver.findElement(path);
        SendText.sendKeys(value);

    }

public String assertCountry(By path){
        WebElement AssertCountry=driver.findElement(path);
       String text= AssertCountry.getText();
       return text;

}

}
