package infrastructure.pages.pageobjectclassic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends PageFactory {
    @FindBy(xpath = "//div[@class='news-lent']//a[@id='menu_loginm']")
    private WebElement loginLink;
    @FindBy(xpath = "//div[@class='news-lent']//a[@id='menu_loginm']")
    private WebElement searchField;
    @FindBy(xpath = "//div[@class='news-lent']//a[@id='menu_loginm']")
    private WebElement title;

    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage openMainPage(String url) {
        driver.get(url);
        return this;
    }

    public LoginPage navigateToLoginPage() {
        loginLink.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains("https://me.liveuamap.com/welcome"));
        return new LoginPage(driver);
    }

    public void fillSearchField() {
        searchField.sendKeys("");
    }

    public String postTitle(){
        title.getText();
    }
}
