package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DuckSearchResultPage {

    private WebDriver driver;

    public DuckSearchResultPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSearchResultLink(String link){
        WebElement element = driver.findElement(By.xpath("//h2//a[@href='"+link+"']"));
        element.click();
    }
}


