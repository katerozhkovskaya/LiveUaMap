package infrastructure.wdm;

import infrastructure.ConfigurationManager;
import infrastructure.PlatformType;
import infrastructure.wdm.Capabilities.PlatformCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class CloudWebDriverFactory implements WebDriverFactory {
    DesiredCapabilities caps = new DesiredCapabilities();
    WebDriver driver;

    public WebDriver create() {

        String username = System.getenv("BROWSERSTACK_USERNAME");
        String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
        PlatformType platform = ConfigurationManager.getInstance().getTestPlatform();
        switch (platform) {
            case MOBILE:
                caps.merge(PlatformCapabilities.mobileCapabilities());
                break;
            case DESKTOP:
                caps.merge(PlatformCapabilities.desctopCapabilities());
            default:
                throw new IllegalArgumentException(String.format("unable to create driver wit type %s", platform));
        }

        try {
            driver = new RemoteWebDriver(new URL("https://"+username+":"+accessKey+"@"+"hub-cloud.browserstack.com"+"/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;

    }
}

