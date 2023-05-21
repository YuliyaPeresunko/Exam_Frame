import org.openqa.selenium.By;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainPageTests extends BaseTest {

    @Test(priority = 1)
    public void checkTitleTest1() {

        mainPage.openPage();
        mainPage.dismissCookies();
        mainPage.checkTitleOfMainPage();
    }

    @Test(priority = 2)
    public void checkLabelsTest2() {
        mainPage.openPage();
        mainPage.checkLabelsMainMenu();
    }

    @Test(priority = 3)
    public void countElementsOfMenuTest3() {
        mainPage.openPage();
        mainPage.countElementsOfMenu();
    }

    @Test(priority = 4)
    public void checkBoxTest4() {
        mainPage.openPage();
        mainPage.scrollPage();
        mainPage.waitPresenceOfCheckBox();
        mainPage.checkForWomanCheckBoxIsNotSelected();
        mainPage.selectForWomanCheckBox();
        mainPage.checkForWomanCheckBoxIsSelected();

        mainPage.checkForMenCheckBoxIsNotSelected();
        mainPage.selectForMenCheckBox();
        mainPage.checkForMenCheckBoxIsSelected();

        mainPage.checkForChildrenCheckBoxIsNotSelected();
        mainPage.selectForChildrenCheckBox();
        mainPage.checkForChildrenCheckBoxIsSelected();

    }

    @Test(priority = 5)
    public void checkAuthorizationFormTest5() {
        mainPage.openPage();
        mainPage.waitPresenceOfAuthorizationButtonAndClick();
        mainPage.checkAuthorizationFormIsDisplayed();
    }
}



