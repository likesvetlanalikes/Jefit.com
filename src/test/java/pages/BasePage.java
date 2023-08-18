package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

@
public abstract class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public static final String BASE_URL = "https://www.jefit.com/";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @Step("Be sure that page is open")
    public abstract boolean isPageOpen();



}
