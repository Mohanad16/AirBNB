package utilities;

import org.openqa.selenium.By;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Locators {

    //choose country button
    public By ChooseCountry = By.xpath("//div[@role='search']/button[1]");
    //search country field
    public By SearchCountry = By.id("bigsearch-query-location-input");
    //select country from search dropdown list
    public By SelectCountry = By.id("bigsearch-query-location-suggestion-0");


    //locate the checkin date
    public By checkInDate(int days) {
        int dayOfMonth = LocalDate.now().plusDays(days).getDayOfMonth();
        //  day1 = dayOfMonth;
        String dayOfWeek = LocalDate.now().plusDays(days).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        String month = LocalDate.now().plusDays(days).getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        //  month1 = month;
        int year = LocalDate.now().getYear();

        String output = String.format("%s, %s, %s %s, Today. Available. Select as check-in date. ", dayOfMonth, dayOfWeek, month, year);

        String xpathExpression = "//td[@aria-label='%s']";
        return By.xpath(String.format(xpathExpression, output));
    }

    //locate the checkout date
    public By checkoutDate(int days) {

        int dayOfMonth = LocalDate.now().plusDays(days).getDayOfMonth();
        // day2 = dayOfMonth;

        String dayOfWeek = LocalDate.now().plusDays(days).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        String month = LocalDate.now().plusDays(days).getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        //month2 = month;
        int year = LocalDate.now().getYear();

        String output = String.format("%s, %s, %s %s. Available. Select as checkout date. ", dayOfMonth, dayOfWeek, month, year);

        String xpathExpression = "//td[@aria-label='%s']";
        return By.xpath(String.format(xpathExpression, output));
    }

    public By mapVisible = By.xpath("//div[@aria-roledescription='map']");

    public By verifyCountry = By.xpath("//div[@class='cs3bjhu dir dir-ltr']/button[1]/div");

    public By verifyDate = By.xpath("//div[@class='cs3bjhu dir dir-ltr']/button[2]/div");

    public By verifyGuest = By.xpath("//div[@class='cs3bjhu dir dir-ltr']/button[3]/div");

    public By addGuests = By.xpath("(//div[@class='c1ykbue4 dir dir-ltr'])[3]");

    public By AddNumberOfAdults = By.xpath("//button[@data-testid='stepper-adults-increase-button']");

    public By AddNumberOfChildren = By.xpath("//button[@data-testid='stepper-children-increase-button']");

    public By ClickSearchButton = By.xpath("//span[@class='t1dqvypu dir dir-ltr']");

    public By ClickFilterButton = By.xpath("//button[@data-testid='category-bar-filter-button']");

    public By ChooseNumberOfBedrooms = By.xpath("(//div[@id='menuItemButton-5']/button)[1]");

    public By ShowMoreButton = By.xpath("(//span[@class='lnq7699 dir dir-ltr'])[1]");

    public By SelectPoolCheckBox = By.xpath("//input[@name='Pool']");

    public By ConfirmButton = By.xpath("//a[@data-testid='filter-modal-confirm']");


    public String CheckChosenDate(int checkInDays, int checkOutDays) {
        int dayOfMonth = LocalDate.now().plusDays(checkInDays).getDayOfMonth();

        String month = LocalDate.now().plusDays(checkInDays).getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);

        int dayOfMonth2 = LocalDate.now().plusDays(checkOutDays).getDayOfMonth();

        String month2 = LocalDate.now().plusDays(checkOutDays).getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);


        String expectedDate;
        if (month.equals(month2)) {
            expectedDate = String.format("%s %s – %s", month, dayOfMonth, dayOfMonth2);
        } else {
            expectedDate = String.format("%s %s – %s %s", month, dayOfMonth, month2, dayOfMonth2);

        }
        System.out.println(expectedDate);
        return expectedDate;
    }


}
