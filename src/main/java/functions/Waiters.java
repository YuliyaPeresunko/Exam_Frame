package functions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.function.Function;

public class Waiters {
    static final Logger logger = LoggerFactory.getLogger(Waiters.class);
    private final WebDriver driver;

    public Waiters(WebDriver driver) {
        this.driver = driver;
    }

    private static final long EXPLICITY_WAIT = 20L;

    private FluentWait<WebDriver> fluentWait(Long duration) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(duration))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(InvalidElementStateException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    private void waitForFunction(Function function, Long timeout) {
        FluentWait<WebDriver> wait = fluentWait(timeout);
        wait.until(function);
    }

    public void waitForVisabilityOfElement(By by) {
        logger.info("waiting for visability of Element " + by.toString());
        waitForFunction(ExpectedConditions.visibilityOfElementLocated(by), EXPLICITY_WAIT);
    }

    public WebElement waitForVisabilityOfElementReturn(By by) {
        logger.info("waiting for visability of Element " + by.toString());
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForFrameAndSwitchToIt(By by) {
        logger.info("waiting for visability of frame and switch to it " + by.toString());
        waitForFunction(ExpectedConditions.visibilityOf(driver.findElement(by)), EXPLICITY_WAIT);
        waitForFunction(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by), EXPLICITY_WAIT);
    }

    public Alert waitForAlertAndSwitchToIt() {
        logger.info("waiting for Alert and switch to it ");
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.alertIsPresent());
    }

    public void waitElementToBeClickable(By by) {
        logger.info("waiting for element to be clickable " + by.toString());
        waitForFunction(ExpectedConditions.elementToBeClickable(by), EXPLICITY_WAIT);
    }

    public void waitElementToBeClickable(WebElement element) {
        logger.info("waiting for element to be clickable " + element.toString());
        waitForFunction(ExpectedConditions.elementToBeClickable(element), EXPLICITY_WAIT);
    }

    public WebElement waitElementToBeClickableReturn(By by) {
        logger.info("waiting for element to be clickable " + by.toString());
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.elementToBeClickable(by));
    }

    public WebElement waitElementToBeClickableReturn(WebElement element) {
        logger.info("waiting for element to be clickable " + element.toString());
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitElementToBeSelected(By by) {
        logger.info("waiting for element to be selected " + by.toString());
        waitForFunction(ExpectedConditions.elementToBeSelected(by), EXPLICITY_WAIT);
    }

    public void waitElementToBeSelected(WebElement element) {
        logger.info("waiting for element to be selected " + element.toString());
        waitForFunction(ExpectedConditions.elementToBeSelected(element), EXPLICITY_WAIT);
    }

    public void waitElementStateToBe(WebElement element, boolean boo) {
        logger.info("waiting for element state to be  " + element.toString());
        waitForFunction(ExpectedConditions.elementSelectionStateToBe(element, boo), EXPLICITY_WAIT);
    }

    public void waitVisabilityOfWebElement(WebElement element) {
        logger.info("waiting for visability of element " + element.toString());
        waitForFunction(ExpectedConditions.visibilityOf(element), EXPLICITY_WAIT);
    }

    public void waitVisabilityOfWebElement(By by) {
        logger.info("waiting for visability of element " + by.toString());
        waitForFunction(ExpectedConditions.visibilityOf(driver.findElement(by)), EXPLICITY_WAIT);
    }

    public WebElement waitVisabilityOfWebElementReturn(WebElement element) {
        logger.info("waiting for visability of element " + element.toString());
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitVisabilityOfWebElementReturn(By by) {
        logger.info("waiting for visability of element " + by.toString());
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.visibilityOf(driver.findElement(by)));
    }

    public WebElement waitPresenceOfElementReturn(By by) {
        logger.info("waiting for presence of element " + by.toString());
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitPresenceOfElement(By by) {
        logger.info("waiting for presence of element " + by.toString());
        waitForFunction(ExpectedConditions.presenceOfElementLocated(by), EXPLICITY_WAIT);
    }

    public void waitTitleContainsText(String text) {
        logger.info("waiting for title of element contains text " + text);
        waitForFunction(ExpectedConditions.titleContains(text), EXPLICITY_WAIT);
    }


}
