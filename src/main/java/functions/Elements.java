package functions;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Elements {
    static final Logger logger = LoggerFactory.getLogger(Elements.class);
    private final WebDriver driver;
    private final Waiters waiters;

    public Elements(WebDriver driver) {
        this.driver = driver;
        waiters = new Waiters(driver);
    }

    public WebElement findSingleElement(By by) {
        try {
            waiters.waitVisabilityOfWebElement(by);
            logger.info("trying to find element by locator " + by.toString());
            return driver.findElement(by);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return null;
    }

    public WebElement findElementByXpath(String xpath) {
        try {
            waiters.waitVisabilityOfWebElement(By.xpath(xpath));
            logger.info("trying to find element by xpath " + xpath);
            return driver.findElement(By.xpath(xpath));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<WebElement> findElementsByXpath(String xpath) {
        try {
            waiters.waitVisabilityOfWebElement(By.xpath(xpath));
            logger.info("trying to find elements by xpath " + xpath);
            return driver.findElements(By.xpath(xpath));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean isElementDisplayed(String xpath) {
        logger.info("checking if element is displayed " + xpath);
        return findElementByXpath(xpath).isDisplayed();
    }

    public boolean isElementSelected(String xpath) {
        logger.info("checking if element is selected " + xpath);
        return findElementByXpath(xpath).isSelected();
    }

    public String getTextFromElementXpath(String xpath) {
        logger.info("getting text from element " + xpath);
        return findElementByXpath(xpath).getText();
    }

    public String getTextFromElementBy(By locator) {
        logger.info("getting text from element " + locator.toString());
        return findSingleElement(locator).getText();
    }

    public void clickOnElementByXpath(String xpath) {
        logger.info("clicking on Element " + xpath);
        findElementByXpath(xpath).click();
    }

    public void clickOnElementBy(By locators) {
        logger.info("clicking on Element " + locators.toString());
        findSingleElement(locators).click();
    }

    public void sendKeysToElementWithXpath(String xpath, String text) {
        logger.info("sending keys " + text + " to element " + xpath);
        findElementByXpath(xpath).sendKeys(text);
    }

    public void sendKeysToElementBy(By locator, String text) {
        logger.info("sending keys " + text + " to element " + locator.toString());
        findSingleElement(locator).sendKeys(text);
    }
}
