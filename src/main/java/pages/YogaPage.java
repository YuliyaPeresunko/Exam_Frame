package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class YogaPage extends BasePage {
    public YogaPage(WebDriver driver) {
        super(driver);
    }

    private static class Locators {
        private final static By titleText = By.xpath("//h1");
        private final static By menuAboutUs = By.xpath("//div[@class='f-column about-menu']//li");
        private final static By menuSport = By.xpath("//span[@class='menu-item__name'][contains(text(),'Спорт')]");
        private final static By collections = By.xpath("//a[text()='Коллекции']");
        private final static By adidas = By.xpath("//a[text()='Adidas Ultraboost']");
        private final static By newBalance = By.xpath("//a[text()='New Balance 530']");
        private final static By nike = By.xpath("//a[text()='Nike Air Max']");
        private final static By search = By.xpath("//input[@id='v_search_input']");
        private final static By searchButton = By.xpath("//button[@class='btn-search']");

    }

    private static class Label {
        private final static String url = "https://intertop.ua/ua/deals/11723/";
        private final static String textH1 = "Для занять йогою";
        private final static String categoriesOfYogaSection = "//ul[@class='filter-left-list']/li";
        private final static String menuAboutUs = "//div[@class='f-column about-menu']//li";
        private final static String shops = "Магазини";
        private final static String career = "Кар'єра";
        private final static String news = "Новини";
        private final static String ecoTrail = "Екостежка";
        private final static String contacts = "Контакти";
        private final static String collections = "Коллекции";
        private final static String adidas = "Adidas Ultraboost";
        private final static String newBalance = "New Balance 530";
        private final static String nike = "Nike Air Max";

    }

    public void openPage() {
        driver.get(Label.url);
    }

    public void waitForH1Loaded() {
        waiters.waitPresenceOfElementReturn(Locators.titleText);
    }

    public void checkTextOfH1() {
        assertions.equalsOfElementAndLabelText(Locators.titleText, Label.textH1);
    }


    public void countCategoriesOfYogaSection() {

        List<WebElement> menuJoga = elements.findElementsByXpath(Label.categoriesOfYogaSection);
        assertions.equalsOfElementsAndNumber(menuJoga, 5);
    }


    public void waitForMenuAboutUsLoaded() {
        waiters.waitPresenceOfElementReturn(Locators.menuAboutUs);
    }

    public void CheckLabelsOfMenuAboutUs() {

        List<WebElement> aboutMenu = elements.findElementsByXpath(Label.menuAboutUs);

        String[] labelsAboutMenu = {Label.shops, Label.career, Label.news, Label.ecoTrail, Label.contacts};
        for (int i = 0; i < aboutMenu.size(); i++) {
            assertions.equalsOfStrings(aboutMenu.get(i).getText(), labelsAboutMenu[i]);
            System.out.println(labelsAboutMenu[i]);
        }
    }

    public void waitForMenuSportLoadedAndClick() {
        waiters.waitPresenceOfElementReturn(Locators.menuSport).click();
    }

    public void checkLabelsOfCollections() {
        assertions.equalsOfElementAndLabelText(Locators.collections, Label.collections);
        assertions.equalsOfElementAndLabelText(Locators.adidas, Label.adidas);
        assertions.equalsOfElementAndLabelText(Locators.newBalance, Label.newBalance);
        assertions.equalsOfElementAndLabelText(Locators.nike, Label.nike);
    }

    public void waitForSearchLoaded() {
        waiters.waitPresenceOfElementReturn(Locators.search);
    }

    public void searchByText(String text) {
        elements.sendKeysToElementBy(Locators.search, text);
        elements.clickOnElementBy(Locators.searchButton);
    }

}

