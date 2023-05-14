package airbnb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

public class locators {
  static  WebDriver driver;
  private static int day1;
    private static int day2;
    private static String month1;
    private static String month2;

 public void openURL() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.airbnb.com/");
     Thread.sleep(8000);

     WebElement close = driver.findElement(By.xpath("//span[@class='i9dqh6z dir dir-ltr']"));
     close.click();

}
public void openLocation() throws InterruptedException {

        WebElement country = driver.findElement(By.xpath(String.format("//div[@role='search']/button[1]")));
        country.click();
    Thread.sleep(2000);
        WebElement search = driver.findElement(By.id("bigsearch-query-location-input"));
        search.sendKeys("rome,italy");
    Thread.sleep(2000);
    WebElement press = driver.findElement(By.id("bigsearch-query-location-suggestion-0"));
    press.click();
       //WebElement chooseCountry = driver.findElement(By.id("bigsearch-query-location-suggestion-0"));
       // chooseCountry.click();
}

    public void checkInDate() throws InterruptedException {
        int dayOfMonth = LocalDate.now().getDayOfMonth();
         day1 =dayOfMonth ;
        String dayOfWeek = LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        String month = LocalDate.now().getMonth().getDisplayName(TextStyle.FULL,Locale.ENGLISH);
         month1=month;
        int year = LocalDate.now().getYear();

        String output= String.format("%s, %s, %s %s, Today. Available. Select as check-in date. ",dayOfMonth,dayOfWeek,month,year) ;

        String xpathExpression = "//td[@aria-label='%s']";
        String formattedXpath = String.format(xpathExpression, output);

        WebElement checkin = driver.findElement(By.xpath(formattedXpath));
        Thread.sleep(2000);
        checkin.click();



    }
    public void checkoutDate() throws InterruptedException {

        int dayOfMonth = LocalDate.now().plusDays(10).getDayOfMonth();
        day2 =dayOfMonth ;

        String dayOfWeek = LocalDate.now().plusDays(10).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        String month = LocalDate.now().getMonth().getDisplayName(TextStyle.FULL,Locale.ENGLISH);
        month2=month;
        int year = LocalDate.now().getYear();

        String output= String.format("%s, %s, %s %s. Available. Select as checkout date. ",dayOfMonth,dayOfWeek,month,year) ;

        String xpathExpression = "//td[@aria-label='%s']";
        String formattedXpath = String.format(xpathExpression, output);

        WebElement checkout = driver.findElement(By.xpath(formattedXpath));
        Thread.sleep(2000);
        checkout.click();


    }


    public void addGuests () throws InterruptedException {

     WebElement add = driver.findElement(By.xpath("//div[@class='p1kudodg dir dir-ltr']"));
        add.click();
        Thread.sleep(2000);

        WebElement adults = driver.findElement(By.xpath("//button[@data-testid='stepper-adults-increase-button']"));
        adults.click();
        adults.click();
        Thread.sleep(2000);

        WebElement child = driver.findElement(By.xpath("//button[@data-testid='stepper-children-increase-button']"));
        child.click();

        WebElement search = driver.findElement(By.xpath("//span[@class='t1l18xbv dir dir-ltr']"));
        search.click();

    }

    public void checkAll() throws InterruptedException {
        String expectedCountry = "Rome";
        String expectedDate ;
        String expectedGuest = "3 guests";
        Thread.sleep(2000);
        WebElement verifyCountry = driver.findElement(By.xpath("//div[@class='cs3bjhu dir dir-ltr']/button[1]/div"));
        Thread.sleep(2000);
        String actualCountry = verifyCountry.getText();

        Assert.assertTrue(actualCountry.contains(expectedCountry),
                "The country name is wrong");

      WebElement verifyDate = driver.findElement(By.xpath("//div[@class='cs3bjhu dir dir-ltr']/button[2]/div"));
        Thread.sleep(2000);
        String actualDate = verifyDate.getText();

        if (month1.equals(month2)) {
          expectedDate = String.format("%s %s – %s",month1,day1,day2);
            System.out.println(expectedDate);
            Assert.assertEquals(actualDate,expectedDate);
        }
       else {
           expectedDate=String.format("%s %s – %s %s",month1,day1,month2,day2);

            System.out.println(expectedDate);
            Assert.assertEquals(actualDate,expectedDate);
        }



        WebElement verifyGuest = driver.findElement(By.xpath("//div[@class='cs3bjhu dir dir-ltr']/button[3]/div"));
        Thread.sleep(2000);
        String actualGuest = verifyGuest.getText();

        Assert.assertTrue(actualGuest.contains(expectedGuest),
                "The guests number is wrong.");


    }



    public void filters () throws InterruptedException {
     WebElement filter= driver.findElement(By.xpath("//button[@data-testid='category-bar-filter-button']"));
     filter.click();
Thread.sleep(2000);
WebElement filterButton = driver.findElement(By.xpath("(//div[@id='menuItemButton-5']/button)[1]"));
filterButton.click();
        Thread.sleep(2000);
        WebElement showMore = driver.findElement(By.xpath("(//span[@class='lnq7699 dir dir-ltr'])[1]"));
        showMore.click();
        Thread.sleep(2000);
        WebElement pool = driver.findElement(By.xpath("(//div[@class='lf10jxs dir dir-ltr']/span)[12]"));
        pool.click();
        Thread.sleep(2000);

        WebElement confirm = driver.findElement(By.xpath("//a[@data-testid='filter-modal-confirm']"));
        confirm.click();
    }


    public void checkResult() throws InterruptedException {
     Thread.sleep(10000);
        List<WebElement> resultElements = driver.findElements(By.xpath("//span[@class=' dir dir-ltr']"));

        // Perform assertions or checks on the result elements
        for (WebElement resultElement : resultElements) {

            String resultText = resultElement.getText();
            Assert.assertTrue(resultText.contains("5 bedrooms"));
        }

    }


}
//aria-label="9, Tuesday, May 2023. Available. Select as check-in date. "
//aria-label="16, Tuesday, May 2023. Selected check-in date. "
////*[@class='gh7uyir giajdwt g14v8520 dir dir-ltr']/div[5]

//May 8 – 18
//May 25 – Jun 4
//May 9 – 19
//May 9 - 19