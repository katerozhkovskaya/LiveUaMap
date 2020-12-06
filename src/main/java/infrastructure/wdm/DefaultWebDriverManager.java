package infrastructure.wdm;

import infrastructure.ConfigurationManager;
import infrastructure.RunEnv;
import org.openqa.selenium.WebDriver;

public class DefaultWebDriverManager implements WebDriverManagerNew {
    @Override
    public WebDriver getDriver() {

        RunEnv runOn = ConfigurationManager.getInstance().getRunOn();
        WebDriverFactory factory;
        switch (runOn) {
            case LOCAL:
                factory = new LocalWebDriverFactory();
                break;
            case REMOTE:
                factory = new RemoteWebDriverFactory();
                break;
            case CLOUD:
                factory = new CloudWebDriverFactory();
                break;
            default:
                factory = new LocalWebDriverFactory();
        }
        return factory.create();
    }

    @Override
    public void destroyDriver(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }
    }
}
