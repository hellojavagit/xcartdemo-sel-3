package shopping;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ShoppingTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForOllieTheAppControlledRobot() throws InterruptedException {
        //Mouse hover on the “Hot deals” link
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        //Mouse hover on the “Bestsellers”  link and click
        mouseHoverAndClick(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        //mouseHoverAndClick(By.xpath("//li[@class='leaf active has-sub']//span[contains(text(),'Bestsellers')]"));

        //Verify the text “Bestsellers”
        verifyTextMethod("error message", "Bestsellers", By.xpath("//h1[contains(text(),'Bestsellers')]"));

        //Mouse hover on “Sort By” and select “Name A-Z”
        mouseHover(By.xpath("//span[@class='sort-by-label']"));
        Thread.sleep(2000);
        mouseHoverAndClick(By.xpath("//a[contains(text(),'Name A - Z')]"));
        Thread.sleep(2000);

        //Click on “Add to cart” button of the product “Ollie - The App Controlled Robot”
        mouseHover(By.xpath("//img[@class = 'photo ls-is-cached lazyloaded' and @alt='iPhone 5S']"));
        mouseHoverAndClick(By.xpath("//button[contains(@class,'regular-button add-to-cart product-add2cart productid-42')]//span[contains(text(),'Add to cart')]"));
        verifyTextMethod("Successfull", "Product has been added to your cart", By.xpath("//li[@class='info']"));

        //Click on X sign to close the message
        //Click on “Your cart” icon and Click on “View cart” button
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        //clickOnElement(By.linkText("View cart"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//span[normalize-space()='View cart']"));
        //clickOnElement(By.className("//a[@class='regular-button cart']"));
        //clickOnElement(By.xpath("//span[text()='View cart']"));
        verifyTextMethod("Not Displays Items In Cart", "Your shopping cart - 1 item",By.xpath("//h1[@id='page-title']"));
        //Verify the Subtotal $99.00
        verifyTextMethod("verifying subtotal","Subtotal: $299.00",By.xpath("//ul[@class='sums']//li[@class='subtotal']"));
         Thread.sleep(2000);
        //Verify the total $106.23
        verifyTextMethod("Total Error", "309", By.xpath("//span[normalize-space()='309']"));
        //Click on “Go to checkout” button
        clickOnElement(By.xpath("//button[contains(@class,'regular-button regular-main-button checkout')]"));
        //Verify the text “Log in to your account”
        verifyTextMethod("Login","Log in to your account",By.xpath("//h3[normalize-space()='Log in to your account']"));
        //Log in to your account
        sendTextToElement(By.xpath("//input[@id='email']"),"prime78657@gmail.com");
        // Click on “Continue” Button
        clickOnElement(By.xpath("//td[@class='buttons-row']//button[@type='submit']"));
        //Verify the text “Secure Checkout”
        verifyTextMethod("ErrorMessage","Secure Checkout",By.xpath("//*[@id=\"content\"]/div/div/div/div/div/h1"));
        //Fill all the mandatory fields
        sendTextToElement(By.id("shippingaddress-firstname"),"primes");
        sendTextToElement(By.id("shippingaddress-lastname"),"test");
        sendTextToElement(By.id("shippingaddress-street"),"avenue");
        sendTextToElement(By.name("shippingAddress[city]"), "CAlifornia");
        selectByIndexFromDropDown(By.name("shippingAddress[country_code]"),6);
        sendTextToElement(By.id("shippingaddress-custom-state"),"anyland");
        sendTextToElement(By.name("shippingAddress[zipcode]"),"12345");
        sendTextToElement(By.id("shippingaddress-phone"),"123678897");
        sendTextToElement(By.name("email"),"prime123@gmail.com");
        clickOnElement(By.id("create_profile"));
        //Thread.sleep(2000);
      //driver.findElement(By.xpath("//input[@id='create_profile']")).click();
      sendTextToElement(By.xpath("//*[@id=\"password\"]"),"abcd123");
      //Select the Delivery Method to “Local Shipping”
        //clickOnElement(By.id("method128"));
        clickOnElement(By.xpath("//input[@id='method128']"));
        //clickOnElement(By.id("method128"));
        //Select Payment Method “COD”
       clickOnElement(By.xpath("//input[@id='pmethod6']"));
        //Verify the total $99.00
        verifyTextMethod("Total does not match","$299.00",By.xpath("//span[@class='price']/descendant::span[2]"));
        //Click on “Place Order” Button
        clickOnElement(By.xpath("//body/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[4]/button[1]"));
        //Verify the text “Thank you for your order”
        verifyTextMethod("verifying messages ","Thank you for your order",By.id("page-title"));

    }
    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {
        //Mouse hover on the “Hot deals” link
        mouseHover(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/span"));
        //Mouse hover on the “Bestseller”  link and click
        mouseHoverAndClick(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        // Verify the text “Bestsellers”
        verifyTextMethod("error message","Bestsellers",By.xpath("//h1[contains(text(),'Bestsellers')]"));
        //Mouse hover on “Sort By” and select “Name A-Z
        mouseHover(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverAndClick(By.linkText("Name A - Z"));
        //Click on “Add to cart” button of the product “Vinyl Idolz: Ghostbusters”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[contains(@class,'regular-button add-to-cart product-add2cart productid-13')]"));
        //Verify the message “Product has been added to your cart” display in  green bar
        verifyTextMethod("Item not added","Product has been added to your cart",By.xpath("//li[@class='info']"));
        //Click on X sign to close the message
        clickOnElement(By.xpath("//a[@title='Close']"));
        //Click on “Your cart” icon and Click on “View cart” button
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//span[normalize-space()='View cart']"));
        //Verify the text “Your shopping cart - 1 item”
        verifyTextMethod("Errormessage","Your shopping cart - 2 items",By.xpath("//h1[@id='page-title']"));
        //Click on “Empty your cart” link
        clickOnElement(By.xpath("//a[normalize-space()='Empty your cart']"));
        //Verify the text “Are you sure you want to clear your cart?” on alert
       // verifyTextMethod("ALert","Are you sure you want to clear your cart?",getTextAlert());
        //Click “Ok” on alert
        acceptAlert();
        // Verify the message “Item(s) deleted from your cart”
        verifyTextMethod("Items deleted from cart","Item(s) deleted from your cart",By.xpath("//li[@class='info']"));

        //Verify the text “Your cart is empty”
        verifyTextMethod("Items deleted","Your cart is empty",By.linkText("Your cart is empty"));

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}