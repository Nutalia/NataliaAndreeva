package hw3.ex1;

import hw3.PageObjectsBaseTest;
import hw3.UserData;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class PageObjectsTest1 extends PageObjectsBaseTest {

    @Test
    public void testSitePage() {
        //1-4. User Authorization
        authorization(new UserData(properties.getProperty("userName"),
                        properties.getProperty("login"),
                        properties.getProperty("password")),
                properties.getProperty("title"));

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        String[] expectedItemText = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
        List<WebElement> headerItems = homePage.getHeaderMenu().getHeaderItems();
        for (WebElement current : headerItems) {
            softAssert.assertTrue(current.isDisplayed());
        }
        softAssert.assertEquals(headerItems.stream().map(WebElement::getText).toArray(String[]::new), expectedItemText);

        //6. Assert that there are 4 images on the Index Page and they are displayed
        for (WebElement current : homePage.getImages()) {
            softAssert.assertTrue(current.isDisplayed());
        }

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        String[] expectedImageText = {"To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"};
        var imageTexts = homePage.getImageTexts();
        for (WebElement current : imageTexts) {
            softAssert.assertTrue(current.isDisplayed());
        }
        softAssert.assertEquals(imageTexts.stream().map(WebElement::getText).toArray(String[]::new), expectedImageText);

        //8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(homePage.getIframe().isDisplayed());

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        softAssert.assertTrue(homePage.getFrameButton().isDisplayed());

        //10. Switch to original window back
        driver.switchTo().parentFrame();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        String[] expectedMenuText = {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};
        var leftItems = homePage.getLeftMenu().getLeftItems();
        for (WebElement current : leftItems) {
            softAssert.assertTrue(current.isDisplayed());
        }
        softAssert.assertEquals(leftItems.stream().map(WebElement::getText).toArray(String[]::new), expectedMenuText);

        softAssert.assertAll();
    }
}
