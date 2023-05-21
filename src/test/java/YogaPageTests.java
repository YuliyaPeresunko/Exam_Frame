import org.testng.annotations.Test;

public class YogaPageTests extends BaseTest {

    @Test
    public void checkTextH1Test6() {
        yogaPage.openPage();
        yogaPage.waitForH1Loaded();
        yogaPage.checkTextOfH1();
    }

    @Test
    public void checkNumberOfYogaSectionCategoriesTest7() {
        yogaPage.openPage();
        yogaPage.waitForH1Loaded();
        yogaPage.countCategoriesOfYogaSection();
    }

    @Test
    public void checkLabelsOfMenuAboutUsTest8() {
        yogaPage.openPage();
        yogaPage.waitForMenuAboutUsLoaded();
        yogaPage.CheckLabelsOfMenuAboutUs();
    }

    @Test
    public void checkLabelsCategoryCollectionsOfMenuSportTest9() {
        yogaPage.openPage();
        yogaPage.waitForMenuSportLoadedAndClick();
        yogaPage.checkLabelsOfCollections();
    }

    @Test
    public void searchByTextTest10() {
        String input = "sport";
        yogaPage.openPage();
        yogaPage.waitForSearchLoaded();
        yogaPage.searchByText(input);
        searchResultPage.waitForSearchResultLoaded();
        searchResultPage.checkSearchResultContainsText(input);
    }
}





    




