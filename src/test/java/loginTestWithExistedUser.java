
import infrastructure.TestBase;
import infrastructure.pages.pageobjectclassic.LoginPage;
import infrastructure.pages.pageobjectclassic.MainPage;
import org.junit.Test;

public class loginTestWithExistedUser extends TestBase {
    private MainPage mainPage;
    private LoginPage loginPage;

    @Test
    public void positiveLogin() {
        mainPage = new MainPage(driver);
        mainPage.openMainPage(server.getUrl()).navigateToLoginPage();
        loginPage = new LoginPage(driver);
        loginPage.populatedEmail("katerozhkovskaya@gmail.com")
                .populatedPass("welovelit123")
                .submit().verifyUserIsLogged();
    }

    @Test
    public void wrongLoginEmail() {
        mainPage = new MainPage(driver);
        mainPage.openMainPage(server.getUrl())
                .navigateToLoginPage();

        loginPage = new LoginPage(driver);
        loginPage.populatedEmail("kate@gmail.com")
                .populatedPass("welovelit123")
                .submit();
        loginPage.verifyLoginError("Before login you must confirm your email.");
    }

    @Test
    public void wrongLoginPass() {
        mainPage = new MainPage(driver);
        mainPage.openMainPage(server.getUrl())
                .navigateToLoginPage();
        loginPage = new LoginPage(driver);
        loginPage.populatedEmail("katerozhkovskaya@gmail.com")
                .populatedPass("welovelit").submit();
        loginPage.verifyLoginError("Incorrect email or password.");
    }
    @Test
    public void findPost() {
        mainPage = new MainPage(driver);
        mainPage.openMainPage(server.getUrl())
                .fillSearchField();
        loginPage = new LoginPage(driver);
        loginPage.populatedEmail("katerozhkovskaya@gmail.com")
                .populatedPass("welovelit").submit();
        loginPage.verifyLoginError("Incorrect email or password.");
    }
}
