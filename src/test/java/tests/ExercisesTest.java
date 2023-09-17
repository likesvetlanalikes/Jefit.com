package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;
import static org.testng.Assert.*;

public class ExercisesTest extends BaseTest {

    @Test(description = "Open Exercise page")
    public void exercisePageShouldBeOpenedTest() {
        loginPage
                .open()
                .loginWithValidData();
        boolean isExercisesPageOpened = exercisesPage
                .openExercisePage()
                .isPageOpen();

        assertTrue(isExercisesPageOpened, "Exercises page hasn't opened");

    }

    @Test(description = "Open body part page")
    public void bodyPartPageShouldBeOpenedTest() {
        loginPage
                .open()
                .loginWithValidData();
        exercisesPage.openExercisePage();
        String exerciseName = exercisesPage.getBodyNameFromList();
        exercisesPage.clickBodyNameFromList();

        assertEquals(exerciseName, bodyPartPage.getExerciseName(), "The text doesn't match");

    }
}
