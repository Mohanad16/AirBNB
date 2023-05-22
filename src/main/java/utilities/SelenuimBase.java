package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class SelenuimBase {

  public   static WebDriver driver;

    public WebDriver seleniumConfig(String baseURL){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
        driver.manage().timeouts().getPageLoadTimeout();

        return driver;


    }

}
