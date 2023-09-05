package tests;

import io.github.bonigarcia.wdm.WebDriverManager;

import lombok.extern.log4j.Log4j2;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;


import pages.*;

import java.util.concurrent.TimeUnit;

@Log4j2
@Listeners(TestListener.class)

public class BaseTest {
    WebDriver driver;
    protected LoginPage loginPage;
    protected MyJefitPage myJefitPage;




    @Step("Setting up and opening the browser")
    @BeforeMethod
    public void setUp(ITestContext context){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        context.setAttribute("driver",driver);


        loginPage = new LoginPage(driver);
        myJefitPage = new MyJefitPage(driver);



    }
    @Step("Closing the browser")
    @AfterMethod(alwaysRun = true)
    public void tearDown(){

        driver.quit();
    }
}
