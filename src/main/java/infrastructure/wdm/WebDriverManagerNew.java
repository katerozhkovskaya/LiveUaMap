package infrastructure.wdm;

import org.openqa.selenium.WebDriver;

public interface WebDriverManagerNew {
    WebDriver getDriver();
    void destroyDriver(WebDriver browser);
}
