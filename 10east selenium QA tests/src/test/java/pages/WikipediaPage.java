package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WikipediaPage
{
    private WebDriver driver;

    public WikipediaPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public By getTableRowSelector(String text){
        return By.xpath("//table[@id='constituents']/tbody/tr/td[1]/a[text()='"+text+"']");
    }
}


