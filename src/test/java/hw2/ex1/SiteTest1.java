package hw2.ex1;

import hw2.BrowserTest;
import hw2.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class SiteTest1 extends BrowserTest {

    @Test
    public void testSitePage() {
        //1-4. User Authorization
        authorization(new User("ROMAN IOVLEV", "Roman", "Jdi1234"));

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        String[] expectedItemText = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
        List<WebElement> headerItems = driver.findElements(By.cssSelector("header .nav>li"));
        softAssert.assertEquals(headerItems.size(), expectedItemText.length);
        for (WebElement current : headerItems) {
            softAssert.assertTrue(current.isDisplayed());
        }
        softAssert.assertEquals(headerItems.stream().map(WebElement::getText).toArray(String[]::new), expectedItemText);

        //6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> images = driver.findElements(By.className("benefit-icon"));
        softAssert.assertEquals(images.size(), 4);
        for (WebElement currImage : images) {
            softAssert.assertTrue(currImage.isDisplayed());
        }

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        String[] expectedImageText = {"To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"};
        List<WebElement> texts = driver.findElements(By.className("benefit-txt"));
        softAssert.assertEquals(texts.size(), expectedImageText.length);
        for (WebElement imageText : texts) {
            softAssert.assertTrue(imageText.isDisplayed());
        }
        softAssert.assertEquals(texts.stream().map(WebElement::getText).toArray(String[]::new), expectedImageText);

        //8. Assert that there is the iframe with “Frame Button” exist
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        softAssert.assertTrue(iframe.isDisplayed());

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame(iframe);
        WebElement frameButton = driver.findElement(By.id("frame-button"));
        softAssert.assertTrue(frameButton.isDisplayed());

        //10. Switch to original window back
        driver.switchTo().parentFrame();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        String[] expectedMenuText = {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};
        List<WebElement> menuItems = driver.findElements(By.cssSelector(".sidebar-menu>li"));
        softAssert.assertEquals(menuItems.size(), expectedMenuText.length);
        for (WebElement current : menuItems) {
            softAssert.assertTrue(current.isDisplayed());
        }
        softAssert.assertEquals(menuItems.stream().map(WebElement::getText).toArray(String[]::new), expectedMenuText);

        softAssert.assertAll();
    }
}
