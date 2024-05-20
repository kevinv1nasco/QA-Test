package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TenEastHomePage {

    private WebDriver driver;

    @FindBy(xpath = "//button/span[text()='Accept']")
    WebElement btnAccept;

    @FindBy(xpath = "//a[text()=\"Login\"]")
    WebElement btnLogin;

    @FindBy(xpath = "//header//div/a//span[text()='Inquire']")
    WebElement btnInquire;

    public TenEastHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Click Accept button
     */
    public void clickAccept(){
        btnAccept.click();
    }

    /**
     * Click Inquire button
     */
    public void clickInquire(){
        btnInquire.click();
    }

    /**
     * Click Login button
     */
    public void clickLogin(){
        btnLogin.click();
    }
}
