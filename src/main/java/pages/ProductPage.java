package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private static class Locators {
        private final static By cookies = By.xpath("//div[@class='IButton IButton--secondary']");
        private final static By productName = By.xpath("//h2[@class='user-product-name']/div[text()='New Balance 530 ']");
        private final static By productName2 = By.xpath("//h2[@class='user-product-name']/div[text()=' Кросівки для міста']");
        private final static By selectSize = By.xpath("//input[@aria-labelledby='vs2__combobox']");
        private final static By selectedSize = By.xpath("//b[@id='look3d-selectedSizeLabel']");
        private final static By favoritesButton = By.xpath("//label[@for='like_6121680']");
        private final static By favoritesMenu = By.xpath("//div[@class='user-menu-item item_favorite one-user-menu u-2']/a");
        private final static By cart = By.xpath("//div[@class='pay-bt']");

    }

    private static class Label {
        private final static String url = "https://intertop.ua/ua/product/sneakers-new-balance-6121680";
        private final static String productLabel = "New Balance 530";
        private final static String productLabel2 = "Кросівки для міста";
        private final static String sizeLabel = "40";
        private final static String favoritesButton = "//label[@for='like_6121680']";
        private final static String favoritesUrl = "https://intertop.ua/ua/account/wishlist/";
        private final static String productInCart = "//div[@class='basket-item__name']";

    }

    public void openPage() {
        driver.get(Label.url);
    }
    public void dismissCookies(){
        waiters.waitPresenceOfElementReturn(Locators.cookies).click();
    }
    public void waitPresenceOfProductName() {
        waiters.waitPresenceOfElementReturn(Locators.productName);
    }

    public void checkProductName() {
        assertions.equalsOfElementAndLabelText(Locators.productName, Label.productLabel);
        assertions.equalsOfElementAndLabelText(Locators.productName2, Label.productLabel2);
    }

    public void scrollProductPage() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,500)");
    }
    public void selectSize() {
        action.sendKeystoElementAndEnter(Locators.selectSize,Label.sizeLabel);
    }
    public void checkSelectedSize() {
        assertions.equalsOfElementAndLabelText(Locators.selectedSize, Label.sizeLabel);
    }

    public void checkFavoritesButtonIsNotSelected(){
        assertions.elementIsNotSelected(Label.favoritesButton);
    }
    public void selectFavoritesButton(){elements.clickOnElementBy(Locators.favoritesButton);
    }
    public void checkFavoritesButtonIsSelected(){assertions.elementIsDisplayed(Label.favoritesButton);
    }
    public void clickFavoritesMenu(){elements.clickOnElementBy(Locators.favoritesMenu);
    }
    public void checkMenuFavoritesUrl(){
        assertions.equalsOfStrings(Label.favoritesUrl, driver.getCurrentUrl());
    }
    public void addProductToCart(){elements.clickOnElementBy(Locators.cart);
    }
    public void checkProductInCart(){
        assertions.elementIsDisplayed(Label.productInCart);}

}