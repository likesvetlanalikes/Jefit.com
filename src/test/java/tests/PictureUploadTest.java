package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.*;

public class PictureUploadTest extends BaseTest {

    @Test(description = "Upload Profile Picture")
    public void photoShoutBeUploadedTest() {
        loginPage.open();
        loginPage.loginWithValidData();

        profilepicPage.uploadProfilePic();

        String imageName = profilepicPage.fileIsUploaded();
        assertTrue(imageName.contains("avatar"), "Picture not uploaded");
    }

}
