package steps;

import pages.MainPage;
import pages.PreviewPage;

public class PreviewPageSteps {

    private final PreviewPage previewPage = new PreviewPage();
    private final MainPage mainPage = new MainPage();

    public PreviewPage openPreview(int pictureOrder) {
        mainPage.clickOnPicture(pictureOrder);
        return new PreviewPage();
    }

    public PreviewPage buttonBack(int pictureOrder) {
        mainPage.clickOnPicture(pictureOrder);
        previewPage.pressButtonBack();
        return new PreviewPage();
    }

}
