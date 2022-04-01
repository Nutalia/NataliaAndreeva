package hw2.ex2;

import hw2.BrowserTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class SiteTest2 extends BrowserTest {

    @Test
    public void testSitePage() {
        //5. Open through the header menu Service -> Different Elements Page
        WebElement service = driver.findElement(By.cssSelector("header .nav .dropdown"));
        service.click();
        WebElement diffElements = service.findElement(By.xpath("//*[text()='Different elements']"));
        diffElements.click();

        //6. Select checkboxes
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("label.label-checkbox"));
        checkBoxes.removeIf(x -> !x.getText().equals("Water") && !x.getText().equals("Wind"));
        softAssert.assertEquals(checkBoxes.size(), 2);
        for(WebElement box: checkBoxes) {
            box.findElement(By.tagName("input")).click();
        }

        //7. Select radio
        List<WebElement> radios = driver.findElements(By.cssSelector("label.label-radio"));
        radios.removeIf(x -> !x.getText().equals("Selen"));
        softAssert.assertEquals(radios.size(), 1);
        for(WebElement button: radios) {
            button.findElement(By.tagName("input")).click();
        }

        //8. Select in dropdown
        WebElement yellow = driver.findElement(By.xpath("//select/option[text()='Yellow']"));
        yellow.click();

        //9. Assertions
        String[] expectedLogs = {"Colors: value changed to Yellow",
                                 "metal: value changed to Selen",
                                 "Wind: condition changed to true",
                                 "Water: condition changed to true"
                                 };
        List<WebElement> log = driver.findElements(By.cssSelector(".info-panel-body-log li"));
        softAssert.assertEquals(log.size(), expectedLogs.length);
        for(int i = 0; i < log.size() && i < expectedLogs.length; i++) {
            WebElement current = log.get(i);
            softAssert.assertTrue(current.isDisplayed());
            softAssert.assertTrue(current.getText().contains(expectedLogs[i]));
        }

        softAssert.assertAll();
    }
}
