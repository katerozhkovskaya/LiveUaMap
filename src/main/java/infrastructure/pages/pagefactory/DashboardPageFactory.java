package infrastructure.pages.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DashboardPageFactory {

        WebDriver driver;
        WebDriverWait wait;

        public DashboardPageFactory(WebDriver driver) {
            this.driver = driver;
            wait = new WebDriverWait(driver, 10);
            PageFactory.initElements(driver,this);
        }

        public void verifyUserIsLogged(){
            wait.until(ExpectedConditions.urlContains("wp-admin/"));
            assertEquals("kate",  driver.findElement(By.className("display-name")).getText());
        }

}

