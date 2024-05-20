package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TenEastResetPasswordPage {

    private WebDriver driver;

    public TenEastResetPasswordPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//form[@id=\"request-password-reset\"]//input[@id='email']")
    WebElement inputEmail;

    @FindBy(xpath = "//button[@data-cy=\"login-reset-submit\"]")
    WebElement btnContinue;

    public By lblErrorMessage = By.xpath("//p[text()='Please enter a valid email']");


    public void typeEmail(String email){
        inputEmail.sendKeys(email);
    }

    public void clickContinue(){
        btnContinue.click();
    }
}
