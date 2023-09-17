package pages;


import elements.Button;
import elements.ButtonAHref;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;

@Log4j2

public class PictureUploadPage extends BasePage {

    public static final By SELECT_FILE_BUTTON = By.id("avatarupload");
    public static final By UPLOAD_BUTTON = By.xpath("//input[@class='picturepostButton']");
    public static final By PROFILE_PIC_TITTLE = By.xpath("//strong[text()='Profile Picture Setup']");
    public static final By PROFILE_PIC = By.xpath("//img[@class ='leftProfilePic']");

    public PictureUploadPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return false;
    }

    @Step("Opening the Profilepic page")
    public PictureUploadPage open() {
        driver.get(BASE_URL + "my-jefit/profilepic.php");
        log.info("Open Profilepic page with URL: " + BASE_URL + "my-jefit/profilepic.php");
        return this;
    }


    @Step("Upload profile page")
    public void uploadProfilePic() {
        new ButtonAHref(driver, "Edit").click();
        File file = new File("src/test/resources/filesForUploading/kachok.jpg");
        driver.findElement(SELECT_FILE_BUTTON).sendKeys(file.getAbsolutePath());
        log.info("Select a file: " + file.getName() + " path file: " + file.getAbsolutePath() + " to upload");
        new Button(driver, "Upload Photo").click();
    }

    @Step("Make sure the profile picture is uploaded")
    public String fileIsUploaded() {
        WebElement imageName = driver.findElement(PROFILE_PIC);
        log.info("File is uploaded");
        return imageName.getAttribute("src");


    }

    public void uploadFile() {
    }
}
