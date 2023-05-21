package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.testng.Assert.*;


public class Assertions {
    static final Logger logger = LoggerFactory.getLogger(Assertions.class);
    private final Elements elements;
    private final ActionClass actions;
    private final WebDriver driver;
    private final Waiters waiters;

    public Assertions(WebDriver driver) {
        this.driver = driver;
        elements = new Elements(driver);
        actions = new ActionClass(driver);
        waiters = new Waiters(driver);
    }

    public void elementIsDisplayed(String xpath) {
        logger.info("trying to check the assertion that the element is displayed " + xpath);
        assertTrue(elements.isElementDisplayed(xpath), "Элемент не отображается, хотя должен был");
    }

    public void elementIsSelected(String xpath) {
        logger.info("trying to check the assertion that the element is selected " + xpath);
        assertTrue(elements.isElementSelected(xpath), "Элемент не выбран, хотя должен был");
    }

    public void elementIsNotSelected(String xpath) {
        logger.info("trying to check the assertion that the element is not displayed " + xpath);
        assertFalse(elements.isElementSelected(xpath), "Элемент выбран, хотя не должен был");
    }

    public void equalsOfElementAndLabelText(String xpathOfElement, String expectedString) {
        logger.info("trying to compare element " + xpathOfElement + " and label text " + expectedString);
        assertEquals(elements.getTextFromElementXpath(xpathOfElement), expectedString,
                "Я ожидал получить " + expectedString + ". А получил " + elements.getTextFromElementXpath(xpathOfElement));
    }

    public void equalsOfElementsAndNumber(List<WebElement> list, int expectedNumber) {
        logger.info("trying to compare elements " + list.toString() + " and number " + expectedNumber);
        assertEquals(list.size(), expectedNumber,
                "Я ожидал получить " + expectedNumber + ". А получил " + list.size());
    }

    public void equalsOfStrings(String actualString, String expectedString) {
        logger.info("trying to compare actual string " + actualString + " and expectedString " + expectedString);
        assertEquals(actualString, expectedString,
                "Я ожидал получить " + expectedString + ". А получил " + actualString);
    }

    public void equalsOfElementAndLabelText(By xpath, String expectedString) {
        logger.info("trying to compare element " + xpath + " and string " + expectedString);
        assertEquals(elements.getTextFromElementBy(xpath), expectedString,
                "Я ожидал получить " + expectedString + ". А получил " + elements.getTextFromElementBy(xpath));
    }
}
