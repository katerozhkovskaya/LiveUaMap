package infrastructure.utils;

import org.openqa.selenium.WebDriver;

public class SeleniumUtils {
    private WebDriver driver;
    private String parentWindow;

    public SeleniumUtils(WebDriver driver) {
        this.driver = driver;
        this.parentWindow = driver.getWindowHandle();
    }


    public  void switchToWindowByTitle( String title) {

        for (String window : driver.getWindowHandles()) {
            driver.switchTo().window(window);
            if (driver.getTitle().equals(title)) {
                break;
            }
        }
    }

    public void switchToWindowByUrl( String url) {

        for (String window : driver.getWindowHandles()) {
            driver.switchTo().window(window);
            if (driver.getCurrentUrl().contains(url)) {
                break;
            }
        }
    }

    public  void returnToParentWin() {
        driver.switchTo().window(this.parentWindow);
    }

    public  void closeExtra() {
        for (String window : driver.getWindowHandles()) {
            driver.switchTo().window(window);
            if (!driver.getWindowHandle().equals(this.parentWindow)) {
                driver.close();
            }
        }
    }

}