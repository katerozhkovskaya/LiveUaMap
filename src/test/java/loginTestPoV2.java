import infrastructure.TestBase;
import infrastructure.pages.pagefactory.LoginPageFactory;
import infrastructure.pages.pagefactory.MainPageFactory;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class loginTestPoV2 extends TestBase {
    private MainPageFactory mainPageFactory;
    private LoginPageFactory loginPageFactory;

    @Test
    public void emptyLoginName() {
        mainPageFactory = new MainPageFactory(driver);
        mainPageFactory.openMainPage(server.getUrl());
        mainPageFactory.navigateToLoginPage();

        loginPageFactory = new LoginPageFactory(driver);
        loginPageFactory.populatedName("");
        loginPageFactory.populatedPass("Kate123Rozhkovska");
        loginPageFactory.submitFail();

        Assertions.assertEquals("Error: The username field is empty.", loginPageFactory.getErrMsg());
    }

    @Test
    public void emptyLoginPass() {
        mainPageFactory = new MainPageFactory(driver);
        mainPageFactory.openMainPage(server.getUrl());
        mainPageFactory.navigateToLoginPage();

        loginPageFactory = new LoginPageFactory(driver);
        loginPageFactory.populatedName("kate");
        loginPageFactory.populatedPass("");
        loginPageFactory.submitFail();

        Assertions.assertEquals("Error: The password field is empty.", loginPageFactory.getErrMsg());
    }

}
