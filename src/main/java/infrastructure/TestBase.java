package infrastructure;

import infrastructure.logging.AbstractLogger;
import infrastructure.logging.FileTestLogger;
import infrastructure.logging.StdTestLogger;
import infrastructure.wdm.DefaultWebDriverManager;
import infrastructure.wdm.WebDriverManagerNew;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
    private WebDriverManagerNew wdm;
    protected WebDriver driver;
    protected TestServer server;
    protected AbstractLogger logger;
    protected WebDriverWait wait;

    @Before
    public void beforeTest() {
        wdm = new DefaultWebDriverManager();
        driver = wdm.getDriver();
        logger = getLogger();
        server = new TestServer();
        wait = new WebDriverWait(driver, 10);
        logger.log(server.getUrl());
    }

    @After
    public void tearDown() {
        wdm.destroyDriver(driver);
    }


    @AfterAll
    public void tearDownAll() {
        wdm.destroyDriver(driver);
    }
    public AbstractLogger getLogger() {
        return ConfigurationManager.getInstance().getCurrentEnvironment().equals("local") ? new StdTestLogger() : new FileTestLogger();
    }
}
