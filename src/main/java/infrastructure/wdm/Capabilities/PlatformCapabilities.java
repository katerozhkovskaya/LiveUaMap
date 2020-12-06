package infrastructure.wdm.Capabilities;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PlatformCapabilities {
    public static Capabilities mobileCapabilities() {
        ChromeOptions mobileOptions = new ChromeOptions();
        mobileOptions.setCapability("name","\"Bstack-[Junit] Sample Test");
        mobileOptions.setCapability("browserstack.debug" , true);
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.merge(mobileOptions);
        return desiredCapabilities;
    }

    public static Capabilities desctopCapabilities() {
        ChromeOptions desctopOptions = new ChromeOptions();
        desctopOptions.setCapability("name","\"Bstack-[Junit] Sample Test");
        desctopOptions.setCapability("browserstack.debug" , true);
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.merge(desctopOptions);
        return desiredCapabilities;
    }
}

