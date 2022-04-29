package hw5.steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class AssertStep extends BaseStep {

    @Then("Title of page is {string}")
    public void checkTitle(String expTitle) {
        Assert.assertEquals(driver.getTitle(), expTitle);
    }

    @Then("User's name is {string}")
    public void checkUser(String expName) {
        Assert.assertEquals(homePage.getUser().getUserName(), expName);
    }

    @Then("User can see items in header menu with proper text")
    public void checkHeaderItems(List<String> expText) {
        var headerItems = homePage.getHeaderMenu().getHeaderItems();
        for (WebElement current : headerItems) {
            Assert.assertTrue(current.isDisplayed());
        }
        Assert.assertEquals(headerItems.stream().map(WebElement::getText).toArray(String[]::new), expText.toArray());
    }

    @Then("User can see images on Home Page")
    public void checkImages() {
        var images = homePage.getImages();
        for (WebElement current : images) {
            Assert.assertTrue(current.isDisplayed());
        }
    }

    @Then("User can see proper texts under images")
    public void checkImageTexts(List<String> expText) {
        var imageTexts = homePage.getImageTexts();
        for (WebElement current : imageTexts) {
            Assert.assertTrue(current.isDisplayed());
        }
        Assert.assertEquals(imageTexts.stream().map(WebElement::getText).toArray(String[]::new), expText.toArray());
    }

    @Then("User can see iframe")
    public void checkIframe() {
        Assert.assertTrue(homePage.getIframe().isDisplayed());
    }

    @Then("User can see frame button in iframe")
    public void checkFrameButton() {
        Assert.assertTrue(homePage.getFrameButton().isDisplayed());
    }

    @Then("User can see items in left menu with proper text")
    public void checkLeftItems(List<String> expText) {
        var leftItems = homePage.getLeftMenu().getLeftItems();
        for (WebElement current : leftItems) {
            Assert.assertTrue(current.isDisplayed());
        }
        Assert.assertEquals(leftItems.stream().map(WebElement::getText).toArray(String[]::new), expText.toArray());
    }

    @Then("User can see logs with proper text")
    public void checkLogs(List<String> expText) {
        String[] expected = expText.toArray(String[]::new);
        var logs = diffElem.getLogs();
        for (int i = 0; i < expected.length; i++) {
            WebElement current = logs.get(i);
            Assert.assertTrue(current.isDisplayed());
            Assert.assertTrue(current.getText().contains(expected[i]));
        }
    }

    private void checkNumberAndDisplay(int numberOfElements, List<WebElement> webElements) {
        Assert.assertEquals(webElements.size(), numberOfElements);
        for (WebElement element : webElements) {
            Assert.assertTrue(element.isDisplayed());
        }
    }

    @Then("6 Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void checkDropdowns() {
        checkNumberAndDisplay(6, userTable.getDropdowns());
    }

    @Then("6 Usernames should be displayed on Users Table on User Table Page")
    public void checkUserNames() {
        checkNumberAndDisplay(6, userTable.getNames());
    }

    @Then("6 Description texts under images should be displayed on Users Table on User Table Page")
    public void checkUserDescriptions() {
        checkNumberAndDisplay(6, userTable.getDescriptions());
    }

    @Then("6 checkboxes should be displayed on Users Table on User Table Page")
    public void checkCheckboxes() {
        checkNumberAndDisplay(6, userTable.getCheckboxes());
    }

    @Then("User table should contain following values:")
    public void checkTableContent(List<List<String>> expValues) {
        for (int i = 0; i < 6; i++) {
            Assert.assertEquals(userTable.getTableLineContent(i), expValues.get(i + 1));
        }
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void checkDroplist(List<String> expValues) {
        Assert.assertEquals(userTable.getDropListValues(0).stream().map(WebElement::getText).toArray(String[]::new), expValues.subList(1, 4).toArray());
    }

    @Then("1 log row has {string} text in log section")
    public void checkLog(String expText) {
        Assert.assertTrue(userTable.getLog().getText().contains(expText));
    }
}
