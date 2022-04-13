package hw3.ex2;

import hw3.DifferentElements;
import hw3.PageObjectsBaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class PageObjectsTest2 extends PageObjectsBaseTest {

    @Test
    public void testSitePage() {
        //1-4. User Authorization
        authorization();

        //5. Open through the header menu Service -> Different Elements Page
        homePage.getHeaderMenu().getSubitemByText("SERVICE", "DIFFERENT ELEMENTS").click();

        //6. Select checkboxes
        DifferentElements diffElem = new DifferentElements(driver);
        diffElem.clickCheckBox("Water");
        diffElem.clickCheckBox("Wind");

        //7. Select radio
        diffElem.clickRadioButton("Selen");

        //8. Select in dropdown
        diffElem.clickDropdown("Yellow");

        //9. Assertions
        String[] expectedLogs = {"Colors: value changed to Yellow",
                "metal: value changed to Selen",
                "Wind: condition changed to true",
                "Water: condition changed to true"
        };
        for (int i = 0; i < expectedLogs.length; i++) {
            WebElement current = diffElem.getLogs().get(i);
            softAssert.assertTrue(current.isDisplayed());
            softAssert.assertTrue(current.getText().contains(expectedLogs[i]));
        }

        softAssert.assertAll();
    }
}
