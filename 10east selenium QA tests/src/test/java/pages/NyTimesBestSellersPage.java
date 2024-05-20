package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NyTimesBestSellersPage {

    private WebDriver driver;

    public By listNonfiction = By.xpath("//nav//form[1]//select[@id='listName-select-Nonfiction']");

    public By labelHardcoverNonfiction = By.xpath("//h1[@data-testid='header-title' and contains(text(),'Hardcover Nonfiction')]");

    public NyTimesBestSellersPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectNonFiction(String text){
        Select selectElement = new Select(driver.findElement(listNonfiction));
        selectElement.selectByVisibleText(text);
    }

    public String getBookName(int number){
        WebElement element = driver.findElement(By.xpath("//section[@aria-labelledby='bestsellers-topic-header']/ol/li["+number+"]//h3"));
        return element.getText();
    }

    public void clickBuyBook(int number){
        WebElement element = driver.findElement(By.xpath("//section[@aria-labelledby='bestsellers-topic-header']/ol/li["+number+"]//button"));
        element.click();
    }

    public void clickBookRetailers(int number, String retailer){
        WebElement element = driver.findElement(By.xpath("//section[@aria-labelledby='bestsellers-topic-header']/ol/li["+number+"]//ul[@aria-label='Links to Book Retailers']//a[text()='"+retailer+"']"));
        element.click();
    }


}
