package tests;

import org.testng.annotations.*;
import pages.PreviewPage;

public class PreviewPageTest extends BaseTest {
    PreviewPage previewSteps;

    @Test(dataProvider = "previewData")
    public void testPreviewDataDisplaying(int order, String name, String desc, String price, String src) {
        try {
            previewSteps = previewPageSteps.openPreview(order);
            previewSteps.assertThatNameTextIsEquals(name);
            previewSteps.assertThatDescTextIsEquals(desc);
            previewSteps.assertThatPriceIsEquals(price);
            previewSteps.assertThatPictureNameIsEquals(src);
        }
        finally {
            getDriver().navigate().back();
        }
    }

    @Test
    public void testButtonBack() {
        previewSteps = previewPageSteps.buttonBack(0);
        previewSteps.assertThatMainPageOpens();
    }
}