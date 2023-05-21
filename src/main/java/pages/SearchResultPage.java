package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BasePage {
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    private static class Locators {

        private final static By searchResult = By.xpath("//div[@class='search-title']");
        private final static By searchText = By.xpath("//div[@class='search-title']/span");

    }

    public void waitForSearchResultLoaded() {
        waiters.waitPresenceOfElementReturn(Locators.searchResult);
    }

    public void checkSearchResultContainsText(String input) {
        assertions.equalsOfElementAndLabelText(Locators.searchText, input);
    }

}
