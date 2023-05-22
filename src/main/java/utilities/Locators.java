package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Locators {


    public By country = By.xpath(String.format("//div[@role='search']/button[1]"));
    public By SearchCountry = By.id("bigsearch-query-location-input");
    public By SelectCountry = By.id("bigsearch-query-location-suggestion-0");

    public By checkInDate(int days) throws InterruptedException {
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
    public By checkoutDate(int days) throws InterruptedException {

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
    public By verifyCountry = By.xpath("//div[@class='cs3bjhu dir dir-ltr']/button[1]/div");

    public By verifyDate = By.xpath("//div[@class='cs3bjhu dir dir-ltr']/button[2]/div");

    public By verifyGuest = By.xpath("//div[@class='cs3bjhu dir dir-ltr']/button[3]/div");

    public By addGuests = By.xpath("//div[@class='p1kudodg dir dir-ltr']");

    public By adults= By.xpath("//button[@data-testid='stepper-adults-increase-button']");

    public By child = By.xpath("//button[@data-testid='stepper-children-increase-button']");

    public By search = By.xpath("//span[@class='t1l18xbv dir dir-ltr']");

    public By filter= By.xpath("//button[@class='l1j9v1wn c1tureqs dir dir-ltr']");

    public By BedRooms =By.xpath("(//div[@id='menuItemButton-5']/button)[1]");

    public By showMore = By.xpath("(//span[@class='lnq7699 dir dir-ltr'])[1]");

    public By pool = By.xpath("(//div[@class='lf10jxs dir dir-ltr']/span)[12]");

    public By confirm =By.xpath("//a[@data-testid='filter-modal-confirm']");



    public String dateSender (int checkInDays,int checkOutDays){
        int dayOfMonth = LocalDate.now().plusDays(checkInDays).getDayOfMonth();

        String month = LocalDate.now().plusDays(checkInDays).getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);

        int dayOfMonth2 = LocalDate.now().plusDays(checkOutDays).getDayOfMonth();

        String month2 = LocalDate.now().plusDays(checkOutDays).getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);


        if (month.equals(month2)) {
          String  expectedDate = String.format("%s %s – %s",month,dayOfMonth,dayOfMonth2);
            System.out.println(expectedDate);
        return expectedDate;
        }
        else {
         String   expectedDate=String.format("%s %s – %s %s",month,dayOfMonth,month2,dayOfMonth2);

            System.out.println(expectedDate);
        return expectedDate;
        }
    }


}
