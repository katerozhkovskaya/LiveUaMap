package infrastructure.pages.pageobjectclassic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyCabinetPage  extends PageFactory {

        WebDriver driver;
        WebDriverWait wait;

        public MyCabinetPage(WebDriver driver) {
            this.driver = driver;
            wait = new WebDriverWait(driver, 10);
            PageFactory.initElements(driver, this);
        }

        public void verifyUserIsLogged(){
            wait.until(ExpectedConditions.urlContains("https://me.liveuamap.com/cabinet"));
            assertEquals("katerozhkovskaya",  driver.findElement(By.xpath("//span[contains(@class, 'username')]")).getText());
        }

}

