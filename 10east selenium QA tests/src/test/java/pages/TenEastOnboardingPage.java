package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TenEastOnboardingPage {

    private WebDriver driver;

    @FindBy(xpath = "//button[@aria-label=\"Go back\"]")
    WebElement btnGoBack;

    public TenEastOnboardingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Click Accept button
     */
    public void clickGoBack(){
        btnGoBack.click();
    }
}
