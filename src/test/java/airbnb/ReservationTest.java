package airbnb;

import POM.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Locators;
import utilities.SelenuimBase;

public class ReservationTest extends SelenuimBase {


    String expectedCountry = "Rome";

    String expectedGuest = "3 guests";

    @BeforeTest
    public void startBrowser() {
        SelenuimBase selenuimBase = new SelenuimBase();
        HomePage homePage = new HomePage();

        WebDriver driver = selenuimBase.seleniumConfig("https://www.airbnb.com/");
        homePage.closePopup(driver);
    }

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void airbnbReservation() throws InterruptedException {

        HomePage homePage = new HomePage();
        Locators loc = new Locators();
        String country = "rome,italy";

        homePage.reservationSteps(country, 0, 10);

        softAssert.assertEquals(homePage.checkCountry(), expectedCountry);
        softAssert.assertEquals(homePage.checkDate(), loc.CheckChosenDate(0, 10));
        softAssert.assertEquals(homePage.checkGuests(), expectedGuest);
    }


}
