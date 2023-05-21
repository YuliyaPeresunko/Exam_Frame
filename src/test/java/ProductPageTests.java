import org.testng.annotations.Test;

public class ProductPageTests extends BaseTest {

    @Test
    public void checkProductNameTest11() {
        productPage.openPage();
        productPage.waitPresenceOfProductName();
        productPage.checkProductName();

    }

    @Test
    public void checkSelectSizeTest12() {
        productPage.openPage();
        productPage.scrollProductPage();
        productPage.selectSize();
        productPage.checkSelectedSize();

    }

    @Test
    public void checkFavoritesButtonTest13() {
        productPage.openPage();
        productPage.scrollProductPage();
        productPage.selectSize();
        productPage.checkFavoritesButtonIsNotSelected();
        productPage.selectFavoritesButton();
        productPage.checkFavoritesButtonIsSelected();
    }

    @Test
    public void checkMenuFavoritesUrlTest14() {
        productPage.openPage();
        productPage.clickFavoritesMenu();
        productPage.checkMenuFavoritesUrl();
    }

    @Test
    public void addProductToCartAndCheckTest15() {
        productPage.openPage();
        productPage.scrollProductPage();
        productPage.selectSize();
        productPage.addProductToCart();
        productPage.checkProductInCart();

    }
}



