import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LoginTest extends LoginPrecondition {

    private void populatedLoginFormAndSubmit(String name, String pass) {
        logger.log("user enter name: " + name);
        driver.findElement(By.id("user_login")).sendKeys(name);
        logger.log("user enter pass: " + pass);
        driver.findElement(By.id("user_pass")).sendKeys(pass);
        logger.log("user submit pass");
        driver.findElement(By.id("wp-submit")).click();

    }

    @Test
    public void positiveLogin() {
        populatedLoginFormAndSubmit("kate", "Kate123Rozhkovska");
        logger.log("wait until dashboard page is loaded");

        wait.until(d -> driver.findElement(By.tagName("h1")));
        String actualH1 = driver.findElement(By.tagName("h1")).getText();
        assertEquals("Dashboard", actualH1);
        String actualName = driver.findElement(By.className("display-name")).getText();
        assertEquals("kate", actualName);
    }

    public void negativeLoginWithoutName() {
        driver.findElement(By.id("user_login")).sendKeys("");
        driver.findElement(By.id("user_pass")).sendKeys("Kate123Rozhkovska");
        driver.findElement(By.id("wp-submit")).click();
        wait.until(d -> driver.findElement(By.id("login_error")).isDisplayed());
        String actualText = driver.findElement(By.id("login_error")).getText();
        String expectedText = "Error: The username field is empty.";
        assertEquals(expectedText, actualText);
    }

    @Test
    public void negativeLoginWithWrongName() {
        driver.findElement(By.id("user_login")).sendKeys("kate12");
        driver.findElement(By.id("user_pass")).sendKeys("Kate123Rozhkovska");
        driver.findElement(By.id("wp-submit")).click();
        wait.until(d -> driver.findElement(By.id("login_error")).isDisplayed());
        String actualText = driver.findElement(By.id("login_error")).getText();
        String expectedText = "Unknown username. Check again or try your email address.";
        assertEquals(expectedText, actualText);
    }

    @Test
    public void negativeLoginWithoutPass() {
        driver.findElement(By.id("user_login")).sendKeys("kate");
        driver.findElement(By.id("user_pass")).sendKeys("");
        driver.findElement(By.id("wp-submit")).click();
        wait.until(d -> driver.findElement(By.id("login_error")).isDisplayed());
        String actualText = driver.findElement(By.id("login_error")).getText();
        String expectedText = "Error: The password field is empty.";
        assertEquals(expectedText, actualText);
    }

    @Test
    public void negativeLoginWithWrongPass() {
        driver.findElement(By.id("user_login")).sendKeys("kate");
        driver.findElement(By.id("user_pass")).sendKeys("Kate123");
        driver.findElement(By.id("wp-submit")).click();
        wait.until(d -> driver.findElement(By.id("login_error")).isDisplayed());
        String actualText = driver.findElement(By.id("login_error")).getText();
        String expectedText = "Error: The password you entered for the username kate is incorrect. Lost your password?";
        assertEquals(expectedText, actualText);
    }

    @Test
    public void negativeLoginWithoutPassAndName() {
        driver.findElement(By.id("wp-submit")).click();
        wait.until(d -> driver.findElement(By.id("login_error")).isDisplayed());
        String actualText = driver.findElement(By.id("login_error")).getText();
        String expectedText = "Error: The username field is empty.\nError: The password field is empty.";
        assertEquals(expectedText, actualText);
    }

}
