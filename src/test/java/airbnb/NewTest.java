package airbnb;

import POM.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.Locators;
import utilities.SelenuimBase;

public class NewTest extends SelenuimBase{

    Locators actualText;
    String expectedCountry = "Rome";
    String expectedDate ;
    String expectedGuest = "3 guests";

    @BeforeTest
public void startBrowser(){
        SelenuimBase selenuimBase = new SelenuimBase();
        HomePage homePage = new HomePage();

        WebDriver driver = selenuimBase.seleniumConfig("https://www.airbnb.com/");
        homePage.closePopup(driver);
    }


    @Test
    public void airbnbReservation () throws InterruptedException {

        HomePage homePage = new HomePage();
        Locators loc =new Locators();
        String country = "rome,italy";

homePage.searchSteps(country,0,10);
Thread.sleep(2000);
Assert.assertEquals(homePage.checkCountry(),expectedCountry);
        System.out.println("actual : "+ homePage.checkCountry()+" and Expected : "+expectedCountry);
        Assert.assertEquals(homePage.checkDate(),loc.dateSender(0,10));
        System.out.println("actual : "+ homePage.checkDate()+" and Expected : "+loc.dateSender(0,10));
    }


}
