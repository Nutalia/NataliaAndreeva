package hw4.ex1;

import hw3.UserData;
import hw4.AllureBaseTest;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Feature("Allure Report on failure")
public class AllureFailTest1 extends AllureBaseTest {

    @Test(description = "Fail exercise 1")
    public void testSitePage() {
        //1-4. User Authorization
        authorization(new UserData("Roman",
                        properties.getProperty("login"),
                        properties.getProperty("password")),
                "Home");

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        String[] expectedItemText = {"Home", "Contact Form", "Service", "Metals & Colors"};
        assertStep.checkHeaderItems(expectedItemText);

        //6. Assert that there are 4 images on the Index Page and they are displayed
        assertStep.checkImages();

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        String[] expectedImageText = {"To include good practices\nand ideas from successful\nEPAM proj",
                "To be flex and\ncustomizable",
                "To be multi",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more"};
        assertStep.checkImageTexts(expectedImageText);

        //8. Assert that there is the iframe with “Frame Button” exist
        assertStep.checkIframe();

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        assertStep.checkFrameButton();

        //10. Switch to original window back
        actionStep.switchBack();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        String[] expectedMenuText = {"Home", "Contact", "Serv", "Metal & Color", "Elem pack"};
        assertStep.checkLeftItems(expectedMenuText);

        assertStep.assertAll();
    }
}
