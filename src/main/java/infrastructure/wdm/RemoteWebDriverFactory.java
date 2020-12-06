package infrastructure.wdm;

import infrastructure.BrowserType;
import infrastructure.ConfigurationManager;
import infrastructure.wdm.Capabilities.BrowserCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteWebDriverFactory implements WebDriverFactory {
    DesiredCapabilities caps = new DesiredCapabilities();
    WebDriver driver;

    public WebDriver create() {
        BrowserType browser = ConfigurationManager.getInstance().getTestBrowser();
        switch (browser) {
            case CHROME:
                caps.merge(BrowserCapabilities.chromeCapabilities());
                break;
            case FIREFOX:
                caps.merge(BrowserCapabilities.firefoxCapabilities());
                break;
            default:
                throw new IllegalArgumentException(String.format("unable to create driver wit type %s", browser));
        }

        try {
            driver =  new RemoteWebDriver(new URL(ConfigurationManager.getInstance().getRemouteHubUrl()), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
