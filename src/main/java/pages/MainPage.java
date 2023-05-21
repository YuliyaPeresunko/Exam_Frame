package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    private static class Locators {
        private final static By cookies = By.xpath("//div[@class='IButton IButton--secondary']");
        private final static By forChildrenButton = By.xpath("//a[text()='Дітям']");
        private final static By forMenButton = By.xpath("//a[text()='Чоловікам']");
        private final static By forWomanButton = By.xpath("//a[text()='Жінкам']");
        private final static By salesButton = By.xpath("//span[@class='menu-item__name'][contains(text(),'Знижки')]");
        private final static By newsButton = By.xpath("//span[@class='menu-item__name'][contains(text(),'Новинки')]");
        private final static By shoesButton = By.xpath("//span[@class='menu-item__name'][contains(text(),'Взуття')]");
        private final static By clothesButton = By.xpath("//span[@class='menu-item__name'][contains(text(),'Одяг')]");
        private final static By streetStyleButton = By.xpath("//span[@class='menu-item__name'][contains(text(),'Street Style')]");
        private final static By accessoriesButton = By.xpath("//span[@class='menu-item__name'][contains(text(),'Аксесуари')]");
        private final static By sportButton = By.xpath("//span[@class='menu-item__name'][contains(text(),'Спорт')]");
        private final static By cosmeticsButton = By.xpath("//span[@class='menu-item__name'][contains(text(),'Косметика')]");
        private final static By makeLookButton = By.xpath("//span[@class='menu-item__name'][contains(text(),'Створи образ')]");
        private final static By brandsButton = By.xpath("//span[@class='menu-item__name'][contains(text(),'Бренди')]");
        private final static By promotionsButton = By.xpath("//span[@class='menu-item__name'][contains(text(),'Акції')]");
        private final static By womanCheckBox = By.xpath("//label[@for='box1']");
        private final static By menCheckBox = By.xpath("//label[@for='box2']");
        private final static By childrenCheckBox = By.xpath("//label[@for='box3']");
        private final static By authorizationButton = By.xpath("//div[@id='auth_block']");

    }

    private static class Label {
        private final static String url = "https://intertop.ua/ua/";
        private final static String titlePage1 = "INTERTOP.UA: купити взуття в Україні, каталог взуття 2023, розпродажі, ціни";
        private final static String forChildren = "ДІТЯМ";
        private final static String forMen = "ЧОЛОВІКАМ";
        private final static String forWomen = "ЖІНКАМ";
        private final static String sales = "Знижки";
        private final static String news = "Новинки";
        private final static String shoes = "Взуття";
        private final static String clothes = "Одяг";
        private final static String streetStyle = "Street Style";
        private final static String accessories = "Аксесуари";
        private final static String sport = "Спорт";
        private final static String cosmetics = "Косметика";
        private final static String makeLook = "Створи образ";
        private final static String brands = "Бренди";
        private final static String promotions = "Акції";
        private final static String listMenu = "//span[@class='menu-item__name']";
        private final static String womanCheckBox = "//label[@for='box1']";
        private final static String menCheckBox = "//label[@for='box2']";
        private final static String childrenCheckBox = "//label[@for='box3']";
        private final static String authorizationForm = "//div[@class='auth-page']";

    }

    public void openPage() {
        driver.get(Label.url);
    }

    public void dismissCookies() {
        waiters.waitPresenceOfElementReturn(MainPage.Locators.cookies).click();
    }

    public void checkTitleOfMainPage() {
        assertions.equalsOfStrings(Label.titlePage1, driver.getTitle());
    }

    public void checkLabelsMainMenu() {

        assertions.equalsOfElementAndLabelText(Locators.forChildrenButton, Label.forChildren);
        assertions.equalsOfElementAndLabelText(Locators.forMenButton, Label.forMen);
        assertions.equalsOfElementAndLabelText(Locators.forWomanButton, Label.forWomen);
        assertions.equalsOfElementAndLabelText(Locators.salesButton, Label.sales);
        assertions.equalsOfElementAndLabelText(Locators.newsButton, Label.news);
        assertions.equalsOfElementAndLabelText(Locators.shoesButton, Label.shoes);
        assertions.equalsOfElementAndLabelText(Locators.clothesButton, Label.clothes);
        assertions.equalsOfElementAndLabelText(Locators.streetStyleButton, Label.streetStyle);
        assertions.equalsOfElementAndLabelText(Locators.accessoriesButton, Label.accessories);
        assertions.equalsOfElementAndLabelText(Locators.sportButton, Label.sport);
        assertions.equalsOfElementAndLabelText(Locators.cosmeticsButton, Label.cosmetics);
        assertions.equalsOfElementAndLabelText(Locators.makeLookButton, Label.makeLook);
        assertions.equalsOfElementAndLabelText(Locators.brandsButton, Label.brands);
        assertions.equalsOfElementAndLabelText(Locators.promotionsButton, Label.promotions);
    }

    public void countElementsOfMenu() {

        List<WebElement> menu = elements.findElementsByXpath(Label.listMenu);
        assertions.equalsOfElementsAndNumber(menu, 11);
    }

    public void scrollPage() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,800)");
    }

    public void waitPresenceOfCheckBox() {
        waiters.waitPresenceOfElementReturn(Locators.womanCheckBox).click();
    }

    public void checkForWomanCheckBoxIsNotSelected() {
        assertions.elementIsNotSelected(Label.womanCheckBox);
    }

    public void selectForWomanCheckBox() {
        elements.clickOnElementBy(Locators.womanCheckBox);
    }

    public void checkForWomanCheckBoxIsSelected() {
        assertions.elementIsDisplayed(Label.womanCheckBox);
    }

    public void checkForMenCheckBoxIsNotSelected() {
        assertions.elementIsNotSelected(Label.menCheckBox);
    }

    public void selectForMenCheckBox() {
        elements.clickOnElementBy(Locators.menCheckBox);
    }

    public void checkForMenCheckBoxIsSelected() {
        assertions.elementIsDisplayed(Label.menCheckBox);
    }

    public void checkForChildrenCheckBoxIsNotSelected() {
        assertions.elementIsNotSelected(Label.childrenCheckBox);
    }

    public void selectForChildrenCheckBox() {
        elements.clickOnElementBy(Locators.childrenCheckBox);
    }

    public void checkForChildrenCheckBoxIsSelected() {
        assertions.elementIsDisplayed(Label.childrenCheckBox);
    }


    public void waitPresenceOfAuthorizationButtonAndClick() {
        waiters.waitPresenceOfElementReturn(Locators.authorizationButton).click();
    }

    public void checkAuthorizationFormIsDisplayed() {
        assertions.elementIsDisplayed(Label.authorizationForm);
    }

}

