package hw2.ex1;

import hw2.BrowserTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class SiteTest1 extends BrowserTest {

    @Test
    public void testSitePage() {

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        String[] expectedItemText = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
        List<WebElement> headerItems = driver.findElements(By.cssSelector("header .nav>li"));
        softAssert.assertEquals(headerItems.size(), expectedItemText.length);
        for(int i = 0; i < headerItems.size() && i < expectedItemText.length; i++) {
            WebElement current = headerItems.get(i);
            softAssert.assertTrue(current.isDisplayed());
            softAssert.assertEquals(current.getText(), expectedItemText[i]);
        }

        //6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> images = driver.findElements(By.className("benefit-icon"));
        softAssert.assertEquals(images.size(), 4);
        for(WebElement currImage: images) {
            softAssert.assertTrue(currImage.isDisplayed());
        }

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        String[] expectedImageText = {"To include good practices\nand ideas from successful\nEPAM project",
                                      "To be flexible and\ncustomizable",
                                      "To be multiplatform",
                                      "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"};
        List<WebElement> texts = driver.findElements(By.className("benefit-txt"));
        softAssert.assertEquals(texts.size(), expectedImageText.length);
        for(int i = 0; i < texts.size() && i < expectedImageText.length; i++) {
            softAssert.assertTrue(texts.get(i).isDisplayed());
            softAssert.assertEquals(texts.get(i).getText(), expectedImageText[i]);
        }

        //8. Assert that there is the iframe with “Frame Button” exist
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        softAssert.assertTrue(iframe.isDisplayed());

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.navigate().to(iframe.getAttribute("src"));
        WebElement frameButton = driver.findElement(By.id("frame-button"));
        softAssert.assertTrue(frameButton.isDisplayed());

        //10. Switch to original window back
        driver.navigate().to(homeUrl);
        softAssert.assertEquals(driver.getCurrentUrl(), homeUrl);

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        String[] expectedMenuText = { "Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};
        List<WebElement> menuItems = driver.findElements(By.cssSelector(".sidebar-menu>li"));
        softAssert.assertEquals(menuItems.size(), expectedMenuText.length);
        for(int i = 0; i < menuItems.size() && i < 5; i++) {
            WebElement current = menuItems.get(i);
            softAssert.assertTrue(current.isDisplayed());
            softAssert.assertEquals(current.getText(), expectedMenuText[i]);
        }

        softAssert.assertAll();
    }
}
