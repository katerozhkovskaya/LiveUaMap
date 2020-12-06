package infrastructure.pages.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
    @FindBy(id = "user_login")
    private WebElement loginField;
    @FindBy(id = "user_pass")
    private WebElement passField;
    @FindBy(id = "wp-submit")
    private WebElement submitButton;
    @FindBy(id = "login_error")
    private WebElement errMsgTitle;

    WebDriver driver;

    public LoginPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPageFactory populatedName(String name) {
        loginField.sendKeys(name);
        return this;
    }

    public LoginPageFactory populatedPass(String pass) {
        passField.sendKeys(pass);
        return this;
    }

    public DashboardPageFactory submit() {
        submitButton.click();
        return new DashboardPageFactory(driver);
    }


    public LoginPageFactory submitFail() {
        submitButton.click();
        return this;
    }


//    public void verifyLoginError(String error) {
//        String actualText = driver.findElement(By.id("login_error")).getText();
//        assertEquals(error, actualText);
//    }

    public String getErrMsg() {
        return errMsgTitle.getText();
    }
}
