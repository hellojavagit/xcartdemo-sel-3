package homepage;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully() {
        //1.1 Click on the “Shipping” link
        clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[3]/a[1]/span[1]"));
        //Verify the text “Shipping”
        verifyTextMethod("Shipping Texts does not match", "Shipping", By.id("page-title"));
    }

    @Test  //verifyUserShouldNavigateToNewPageSuccessfully()
    public void verifyUserShouldNavigateToNewPageSuccessfully() {
        //Click on the “New!” link
        clickOnElement(By.linkText("New!"));
        //Verify the text “New arrivals”
        verifyTextMethod("New Texts Does Not Match", "New arrivals", By.id("page-title"));
    }

    @Test
    //verifyUserShouldNavigateToComingsoonPageSuccessfully()
    public void verifyUserShouldNavigateToComingsoonPageSuccessfully() {
        // Click on the “Coming soon” link
        clickOnElement(By.linkText("Coming soon"));
        // Verify the text “Coming soon”
        verifyTextMethod("Texts Does Not Match", "Coming soon", By.xpath("//h1[@id='page-title']"));

    }

    @Test
    //verifyUserShouldNavigateToContactUsPageSuccessfully()
    public void verifyUserShouldNavigateToContactUsPageSuccessfully() {
        //Click on the “Contact us” link
        clickOnElement(By.linkText("Contact us"));
        //Verify the text “Contact us”
        verifyTextMethod("Contact us Texts Does Not Match", "Contact us", By.id("page-title"));

    }
}