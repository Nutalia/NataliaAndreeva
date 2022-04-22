package hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AssertStep extends BaseStep{

    SoftAssert softAssert;

    public AssertStep(WebDriver driver) {
        super(driver);
        softAssert = new SoftAssert();
    }

    @Step(value = "Check that title is '{expTitle}'")
    public void checkTitle(String expTitle) {
        softAssert.assertEquals(driver.getTitle(), expTitle);
    }

    @Step(value = "Check that user is logged in")
    public void checkUser(String expName) {
        softAssert.assertEquals(homePage.getUser().getUserName(), expName);
    }

    @Step(value = "Header items are displayed and have proper texts")
    public void checkHeaderItems(String[] expText) {
        var headerItems = homePage.getHeaderMenu().getHeaderItems();
        for (WebElement current : headerItems) {
            softAssert.assertTrue(current.isDisplayed());
        }
        softAssert.assertEquals(headerItems.stream().map(WebElement::getText).toArray(String[]::new), expText);
    }

    @Step(value = "Images are displayed")
    public void checkImages() {
        var images = homePage.getImages();
        for (WebElement current : images) {
            softAssert.assertTrue(current.isDisplayed());
        }
    }

    @Step(value = "Texts under images are displayed and have proper values")
    public void checkImageTexts(String[] expText) {
        var imageTexts = homePage.getImageTexts();
        for (WebElement current : imageTexts) {
            softAssert.assertTrue(current.isDisplayed());
        }
        softAssert.assertEquals(imageTexts.stream().map(WebElement::getText).toArray(String[]::new), expText);
    }

    @Step(value = "Iframe is displayed")
    public void checkIframe() {
        softAssert.assertTrue(homePage.getIframe().isDisplayed());
    }

    @Step(value = "Frame button in iframe is displayed")
    public void checkFrameButton() {
        softAssert.assertTrue(homePage.getFrameButton().isDisplayed());
    }

    @Step(value = "Item in left menu are displayed and have proper texts")
    public void checkLeftItems(String[] expText) {
        var leftItems = homePage.getLeftMenu().getLeftItems();
        for (WebElement current : leftItems) {
            softAssert.assertTrue(current.isDisplayed());
        }
        softAssert.assertEquals(leftItems.stream().map(WebElement::getText).toArray(String[]::new), expText);
    }

    @Step("Logs are displayed and have proper texts")
    public void checkLogs(String[] expText) {
        var logs = diffElem.getLogs();
        for (int i = 0; i < expText.length; i++) {
            WebElement current = logs.get(i);
            softAssert.assertTrue(current.isDisplayed());
            softAssert.assertTrue(current.getText().contains(expText[i]));
        }
    }

    public void assertAll() {
        softAssert.assertAll();
    }
}
