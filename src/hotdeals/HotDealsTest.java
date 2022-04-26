package hotdeals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class HotDealsTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com";

    @Before
    public void  setUp() {
        openBrowser(baseUrl);
    }
    @Test
    //verifySaleProductsArrangeAlphabetically()
    public void verifySaleProductsArrangeAlphabetically() throws InterruptedException {
        //Mouse hover on the “Hot deals” link
        mouseHover(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/span"));
        //Mouse hover on the “Sale”  link and click
        //mouseHoverAndClick(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[1]"));
        mouseHoverAndClick(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[1]/a"));
        //Verify the text “Sale”
        verifyTextMethod("ErrorMessage","Sale",By.id("page-title"));

        //Mouse hover on “Sort By” and select “Name A-Z”
        mouseHover(By.xpath("//span[contains(text(),'Sort by:')]"));
       mouseHoverAndClick(By.xpath("//a[normalize-space()='Name A - Z']"));
        //Verify that the product arrange alphabetically
       // verifyTextMethod("Products arranged alphabetically","Recommended",By.xpath("//span[@class='sort-by-value']"));
        verifyTextMethod("error message","Name A - Z",By.xpath("//span[contains(text(),'Name A - Z')]"));
    }
    @Test
    public void verifySaleProductsPriceArrangeLowToHigh() throws InterruptedException {
        //Mouse hover on the “Hot deals” link
        mouseHover(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/span"));
        //Mouse hover on the “Sale”  link and click
        mouseHoverAndClick(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[1]"));
        //Verify the text “Sale”
        verifyTextMethod("ErrorMessage","Sale",By.id("page-title"));
        //Mouse hover on “Sort By” and select “Price Low-High”
        mouseHover(By.xpath("//span[contains(text(),'Sort by:')]"));
        mouseHoverAndClick(By.linkText("Price Low - High"));
        //Verify that the product’s price arrange Low to High
        verifyTextMethod("Products arranged in order low to high","Price Low - High",By.xpath("//span[contains(text(),'Price Low - High')]"));
    }
    @Test
    //  verifySaleProductsArrangeByRates()
    public void verifySaleProductsArrangeByRates() throws InterruptedException {
        //Mouse hover on the “Hot deals” link
        mouseHover(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/span"));
        //Mouse hover on the “Sale”  link and click
        mouseHoverAndClick(By.xpath(" //body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[1]"));
        //Verify the text “Sale”
        verifyTextMethod("ErrorMessage","Sale",By.id("page-title"));
        //Mouse hover on “Sort By” and select “Rates”
        mouseHover(By.xpath("//span[contains(text(),'Sort by:')]"));
        mouseHoverAndClick(By.linkText("Rates"));
        //Verify that the product’s price arrange Rates
        verifyTextMethod("Product Rates are","Rates",By.xpath("//span[contains(text(),'Rates')]"));
    }

    @Test
    public void verifyBestSellersProductsArrangeByZToA() throws InterruptedException {
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        mouseHoverAndClick(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        verifyTextMethod("error message","Bestsellers",By.xpath("//h1[contains(text(),'Bestsellers')]"));
        mouseHover(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverAndClick(By.xpath("//a[contains(text(),'Name Z - A')]"));
        verifyTextMethod("Product arranged By","Name Z - A",By.xpath("//span[@class='sort-by-value']"));
    }


    @Test
    public void verifyBestSellersProductsPriceArrangeHighToLow() throws InterruptedException {
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        mouseHoverAndClick(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        verifyTextMethod("error message","Bestsellers",By.xpath("//h1[contains(text(),'Bestsellers')]"));
        mouseHover(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverAndClick(By.xpath("//a[normalize-space()='Price High - Low']"));
        verifyTextMethod("HighToLow","Price High - Low",By.xpath("//span[contains(text(),'Price High - Low')]"));

    }
    @Test
    public void verifyBestSellersProductsArrangeByRates() throws InterruptedException {
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        mouseHoverAndClick(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        verifyTextMethod("error message","Bestsellers",By.xpath("//h1[contains(text(),'Bestsellers')]"));
        mouseHover(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverAndClick(By.xpath("//a[contains(text(),'Rates')]"));
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}