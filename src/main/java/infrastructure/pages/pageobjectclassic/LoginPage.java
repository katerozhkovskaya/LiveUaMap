package infrastructure.pages.pageobjectclassic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPage extends PageFactory {
    WebDriver driver;
    @FindBy(xpath = "//input[@id='input-email-login']")
    private WebElement loginEmail;
    @FindBy(xpath = "//input[(@id='input-password-login')]")
    private WebElement loginPass;
    @FindBy(xpath = "//button[(@id='submit-login')]")
    private WebElement submitButton;
    @FindBy(xpath = "//p[contains(@class, 'error')]")
    private WebElement errMsgTitle;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage populatedEmail(String email) {
        loginEmail.sendKeys(email);
        return this;
    }

    public LoginPage populatedPass(String pass) {
        loginPass.sendKeys(pass);
        return this;
    }

    public MyCabinetPage submit() {
        submitButton.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains("https://me.liveuamap.com/cabinet"));
        return new MyCabinetPage(driver);
    }


    public void verifyLoginError(String error) {
        assertEquals(error, errMsgTitle.getText());
    }
}
