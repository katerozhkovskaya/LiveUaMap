package infrastructure.pages.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageFactory {
    WebDriver driver;

    public MainPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPageFactory openMainPage(String url) {
        driver.get(url);
        return this;
    }

    public LoginPageFactory navigateToLoginPage() {
        driver.findElement(By.linkText("Log in")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains("wp-login.php"));
        return new LoginPageFactory(driver);
    }
}
