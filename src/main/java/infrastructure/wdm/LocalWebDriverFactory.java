package infrastructure.wdm;

import infrastructure.BrowserType;
import infrastructure.ConfigurationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LocalWebDriverFactory implements WebDriverFactory {
    public WebDriver create() {
        BrowserType browser = ConfigurationManager.getInstance().getTestBrowser();
        switch (browser) {
            case CHROME:
                return new ChromeDriver();
            case FIREFOX:
                return new FirefoxDriver();
            case IE:
                return new InternetExplorerDriver();
            default:
                 throw new IllegalArgumentException(String.format("unable to create driver wit type %s", browser));
        }
    }
}
