package tests;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


import pages.TenEastLoginPage;
import pages.TenEastOnboardingPage;
import pages.TenEastResetPasswordPage;
import utils.DriverInstance;
import pages.TenEastHomePage;

import pages.DuckHomePage;
import pages.DuckSearchResultPage;
import pages.NyTimesBestSellersPage;
import pages.AmazonPage;

import pages.GooglePage;
import pages.WikipediaPage;


public class Tests {
    private String baseUrlTest1 = "https://10east.co";
    private String baseUrlTest2 = "https://www.google.com/?&hl=en";
    private String baseUrlTest3 = "https://duckduckgo.com/";

    @BeforeClass
    public static void setup(){
        DriverInstance.init();
    }

    @Test
    public void automatedTest1(){
        DriverInstance.driver.get(baseUrlTest1);
        TenEastHomePage tenEastHomePage = new TenEastHomePage(DriverInstance.driver);
        TenEastOnboardingPage tenEastOnboardingPage = new TenEastOnboardingPage(DriverInstance.driver);
        TenEastLoginPage tenEastLoginPage = new TenEastLoginPage(DriverInstance.driver);
        TenEastResetPasswordPage tenEastResetPasswordPage = new TenEastResetPasswordPage(DriverInstance.driver);
        WebDriverWait wait = new WebDriverWait(DriverInstance.driver, 10);
        tenEastHomePage.clickAccept();
        tenEastHomePage.clickInquire();
        tenEastOnboardingPage.clickGoBack();
        tenEastHomePage.clickLogin();
        tenEastLoginPage.clickForgotPassword();
        tenEastResetPasswordPage.typeEmail("d");
        tenEastResetPasswordPage.clickContinue();
        wait.until(ExpectedConditions.visibilityOfElementLocated(tenEastResetPasswordPage.lblErrorMessage));
    }

    @Test
    public void automatedTest2() throws InterruptedException {
        DriverInstance.driver.get(baseUrlTest2);
        GooglePage googlePage = new GooglePage(DriverInstance.driver);
        WikipediaPage wikipediaPage = new WikipediaPage(DriverInstance.driver);
        WebDriverWait wait = new WebDriverWait(DriverInstance.driver, 10);
        googlePage.typeSearchAndEnter("S&P 500");
        googlePage.scrollToSearchResultLink("List of S&P 500 companies");
        googlePage.navigateToSearchResultLink("List of S&P 500 companies");
        wait.until(ExpectedConditions.visibilityOfElementLocated(wikipediaPage.getTableRowSelector("AAPL")));
    }

    @Test
    public void automatedTest3(){
        DuckHomePage duckHomePage = new DuckHomePage(DriverInstance.driver);
        DuckSearchResultPage duckSearchResultPage = new DuckSearchResultPage(DriverInstance.driver);
        NyTimesBestSellersPage nyTimesBestSellersPage = new NyTimesBestSellersPage(DriverInstance.driver);
        AmazonPage amazonPage = new AmazonPage(DriverInstance.driver);
        WebDriverWait wait = new WebDriverWait(DriverInstance.driver, 10);


        //Visit https://ducksducksgo.com/
        DriverInstance.driver.get(baseUrlTest3);

        //Identify the link https://www.nytimes.com/books/best-sellers/ on the search results
        String searchPage = "https://www.nytimes.com/books/best-sellers/";
        duckHomePage.typeSearch(searchPage);
        duckHomePage.clickSearch();
        //Click the link and find the name of number 1 best-selling book in hardcover nonfiction section
        duckSearchResultPage.clickSearchResultLink(searchPage);
        nyTimesBestSellersPage.selectNonFiction("Hardcover Nonfiction");
        wait.until(ExpectedConditions.visibilityOfElementLocated(nyTimesBestSellersPage.labelHardcoverNonfiction));
        String url = DriverInstance.driver.getCurrentUrl();
        assertEquals(url, "https://www.nytimes.com/books/best-sellers/hardcover-nonfiction/");
        System.out.println(nyTimesBestSellersPage.getBookName(1));

        //Click on "buy" button and choose Amazon to be redirected to Amazon's site
        nyTimesBestSellersPage.clickBuyBook(1);
        nyTimesBestSellersPage.clickBookRetailers(1, "Amazon");

        //Add two copies to the shopping cart and proceed to checkout page
        amazonPage.selectCopies(2);
        amazonPage.clickBuyNow();
    }

    @AfterClass
    public static void tearDown(){
        DriverInstance.quit();
    }
}
