package POM;

import utilities.Actions;
import utilities.Locators;
import utilities.SelenuimBase;


public class HomePage {

    /**
     * this method create a reservation steps into Airbnb web application
     *
     * @param country      enter country to search for
     * @param checkInDate  enter number of days after current day to select checkin date
     * @param checkOutDate enter number of days after current day to select checkout date
     */
    public void reservationSteps(String country, int checkInDate, int checkOutDate) throws InterruptedException {
        Actions actions = new Actions();
        Locators locators = new Locators();
        SelenuimBase selenuimBase = new SelenuimBase();
//Actions to search for country
        actions.click(locators.ChooseCountry);
        actions.sendKeys(locators.SearchCountry, country);
        selenuimBase.waitForElementToBeClickable(locators.SelectCountry, 20);
        actions.click(locators.SelectCountry);

//Actions of checkin and checkout date
        actions.click(locators.checkInDate(checkInDate));
        actions.click(locators.checkoutDate(checkOutDate));

//Actions to add number of guests
        selenuimBase.waitForElementToBeVisible(locators.addGuests, 10);
        actions.click(locators.addGuests);
        actions.click(locators.AddNumberOfAdults);
        actions.click(locators.AddNumberOfAdults);
        actions.click(locators.AddNumberOfChildren);
        actions.click(locators.ClickSearchButton);

//Actions to filter by giving bedroom numbers and choose pool to be existed
        selenuimBase.waitForElementToBeVisible(locators.mapVisible, 30);
        actions.click(locators.ClickFilterButton);
        selenuimBase.waitForElementToBeVisible(locators.ChooseNumberOfBedrooms, 10);
        actions.click(locators.ChooseNumberOfBedrooms);
        actions.scroll(1000);
        selenuimBase.waitForElementToBeVisible(locators.ShowMoreButton, 10);
        actions.click(locators.ShowMoreButton);
        actions.click(locators.SelectPoolCheckBox);
        actions.click(locators.ConfirmButton);
    }

    /**
     *
     * @return the country name that has entered to check actual with expected
     */
    public String checkCountry() throws InterruptedException {
        Actions actions = new Actions();
        Locators locators = new Locators();
        return actions.getText(locators.verifyCountry);
    }

    /**
     *
     * @return the checkin & checkout date that has entered to check actual with expected
     */

    public String checkDate() throws InterruptedException {
        Actions actions = new Actions();
        Locators locators = new Locators();
        return actions.getText(locators.verifyDate);
    }

    /**
     *
     * @return the number of guests that has entered to check actual with expected
     */
    public String checkGuests() throws InterruptedException {
        Actions actions = new Actions();
        Locators locators = new Locators();
        return actions.getText(locators.verifyGuest);
    }


}
