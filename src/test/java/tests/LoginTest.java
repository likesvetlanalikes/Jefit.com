package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import static org.testng.Assert.*;
public class LoginTest extends BaseTest {
    @Test(description = "Login verification with valid data")
    public void loginUserIsValidData(){
        boolean isProfilePageOpen = loginPage.open()
                .userNameAndPassword("svetlana_040285@mail.ru","veynzQ1`")
                .clickLogInButton()
                .isPageOpen();
        assertTrue(isProfilePageOpen);
    }

    @DataProvider(name = "incorrectLoginTest")
    public Object[][] incorrectLoginTest(){
        return new Object[][]{
                {11, 11, "Invalid username/email or password"},
                {"dfxfdhxfg5", "", "Invalid username/email or password"},
                {"", "3sfsdfe", "Invalid username/email or password"},
                {"HGJHFGJJHG", "hdgfj", "Invalid username/email or password"},
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
