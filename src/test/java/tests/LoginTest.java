package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest {

    @Test(description = "Login verification with valid data")
    public void loginUserIsValidData(){
        boolean isMyJefitPageOpen = loginPage.open()
                .userNameAndPassword("svetlana_040285@mail.ru","veynzQ1`")
                .clickLogInButton()
                .isPageOpen();
        assertTrue(isMyJefitPageOpen);
    }
    @DataProvider(name = "incorrectLoginTest")
    public Object[][] incorrectLoginTest(){
        return new Object[][]{
                {"", "", "Invalid username/email or password"},
                {"alinamalina@mailto.plus", "", "Invalid username/email or password"},
                {"", "5467848346768Ja*", "Invalid username/email or password"},
                {"Miroslava&17", "Peter473764$$", "Invalid username/email or password"},
        };

    }
    @Test(dataProvider = "incorrectLoginTest")
    public void loginTestWithWrongData(String login,String password,String errorMessage){
        loginPage.open()
                .userNameAndPassword(login,password)
                .clickLogInButton();

        assertEquals(loginPage.getErrorMessage(), errorMessage,
                "The message text is incorrect or missing");

    }
}