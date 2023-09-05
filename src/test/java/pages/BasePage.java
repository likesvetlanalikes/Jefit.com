package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;
import lombok.extern.log4j.Log4j2;

@Log4j2
public abstract class BasePage {

    final String BASE_URL = "https://www.jefit.com/";
    WebDriver driver;
    WebDriverWait wait;



    public BasePage(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

    public String waitAndGetText(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();
    }
    public abstract boolean isPageOpen();

    public boolean isExist(By locator){
        try {
            return driver.findElement(locator).isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }
}
