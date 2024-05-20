package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AmazonPage {
    private WebDriver driver;

    public By listQuantity = By.xpath("//select[@id='quantity']");

    @FindBy(xpath = "//span[@id='submit.buy-now']")
    WebElement btnBuyNow;

    public AmazonPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectCopies(int copies){
        Select selectElement = new Select(driver.findElement(listQuantity));
        selectElement.selectByVisibleText(String.valueOf(copies));
    }

    public void clickBuyNow(){
        btnBuyNow.click();
    }
}
