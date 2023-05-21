package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActionClass {
    static final Logger logger = LoggerFactory.getLogger(ActionClass.class);
    private final Elements elements;
    private final Actions actions;
    private final WebDriver driver;

    public ActionClass(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        elements = new Elements(driver);
    }

    public void dragNdrop(WebElement source, WebElement target) {
        logger.info("trying to dragNdrop element " + source.toString());
        actions.dragAndDrop(source, target).perform();
    }

    public void dragNdrop(String xpathSource, String xpathTarget) {
        logger.info("trying to dragNdrop element " + xpathSource);
        actions.dragAndDrop(elements.findElementByXpath(xpathSource), elements.findElementByXpath(xpathTarget)).perform();
    }

    public void moveToElementLocation(String xpath) {
        logger.info("trying to move to element " + xpath);
        actions.moveToElement(elements.findElementByXpath(xpath)).perform();
    }

    public void sendKeystoElementAndEnter(By xpath, String text) {
        logger.info("trying to send Keys to element " + xpath + " and click Enter");
        actions.sendKeys(elements.findSingleElement(xpath), text).sendKeys(org.openqa.selenium.Keys.ENTER)
                .build().perform();
    }
}
