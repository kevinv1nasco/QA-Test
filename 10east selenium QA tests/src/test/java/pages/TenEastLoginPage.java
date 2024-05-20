package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TenEastLoginPage {

    private WebDriver driver;

    public TenEastLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@data-cy=\"login-reset-link\"]")
    WebElement btnForgotPassword;

    public void clickForgotPassword(){
        btnForgotPassword.click();
    }
}


