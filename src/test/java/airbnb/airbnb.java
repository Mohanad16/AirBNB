package airbnb;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.xml.xpath.XPathExpressionException;

public class airbnb {



    @BeforeTest
    public void openBrowser() throws InterruptedException {
       locators obj =new locators();
        obj.openURL();
        Thread.sleep(2000);

    }

    @Test(priority = 1)
    public void chooseLocation () throws InterruptedException {

        locators selectCountry = new locators();
        selectCountry.openLocation();


    }

    public String creatDayLocator(){

        return " Today. Available. Select as check-in date. ";
    }
    @Test(priority = 2)
    public void checkIN() throws XPathExpressionException, InterruptedException {

        locators checkin = new locators();
        checkin.checkInDate();



    }


    @Test(priority = 3)

    public void checkOUT () throws InterruptedException {

     locators checkout = new locators();
        checkout.checkoutDate();
    }

    @Test(priority = 4)
public void guests () throws InterruptedException {

        locators AddGuests = new locators();
        AddGuests.addGuests();
    }


    @Test(priority = 5)
    public void checkAll() throws InterruptedException {
        locators verify = new locators();
        verify.checkAll();
    }

    @Test(priority = 6)
    public void filter() throws InterruptedException {
        locators filter=new locators();
        filter.filters();
    }

    @Test(priority = 7)
    public void checkResults() throws InterruptedException {
        locators results = new locators();
        results.checkResult();
    }

}
//td[@aria-label='2, Tuesday, May 2023, Today. Available. Select as check-in date. ']
//td[@aria-label='2, Tuesday, May 2023. Available. Select as checkout date. ']

//td[@aria-label='1, Monday, May 2023, Today. Selected check-in date. ']
