import infrastructure.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPrecondition extends TestBase {

    @Override
    public void beforeTest() {
        super.beforeTest();
        openMainPage();
        navigateToLoginPage();
    }

    public void navigateToLoginPage() {
        driver.findElement(By.linkText("Log in")).click();
        wait.until(ExpectedConditions.urlContains("wp-login.php"));
    }

    public void openMainPage() {
        driver.get(server.getUrl());
    }
}
