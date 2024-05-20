package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.JavascriptExecutor;

public class GooglePage {
    private WebDriver driver;

    @FindBy(xpath = "//textarea[@title='Search']")
    WebElement txtSearch;

    public GooglePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void typeSearchAndEnter(String value){
        txtSearch.sendKeys(value, Keys.ENTER);
    }

    public void scrollToSearchResultLink(String text){
        WebElement element = driver.findElement(By.xpath("//a[text()='"+text+"']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void navigateToSearchResultLink(String text){
        WebElement element = driver.findElement(By.linkText(text));
        driver.get(element.getAttribute(("href")));
    }
}
