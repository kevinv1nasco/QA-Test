package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DuckHomePage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@aria-label='Search with DuckDuckGo']")
    WebElement txtSearch;

    @FindBy(xpath = "//button[@aria-label='Search']")
    WebElement btnSearch;


    public DuckHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void typeSearch(String value){
        txtSearch.sendKeys(value);
    }

    public void clickSearch(){
        btnSearch.click();
    }
}
