package hw4.ex2;

import hw3.UserData;
import hw4.AllureBaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("Tests with Allure Reports")
@Story("Second test with Allure")
public class AllureTest2 extends AllureBaseTest {

    @Test(description = "Exercise 2")
    public void testSitePage() {
        //1-4. User Authorization
        authorization(new UserData(properties.getProperty("userName"),
                        properties.getProperty("login"),
                        properties.getProperty("password")),
                properties.getProperty("title"));

        //5. Open through the header menu Service -> Different Elements Page
        actionStep.clickServiceItem("DIFFERENT ELEMENTS");

        //6. Select checkboxes
        actionStep.selectCheckBox("Water");
        actionStep.selectCheckBox("Wind");

        //7. Select radio
        actionStep.selectRadio("Selen");

        //8. Select in dropdown
        actionStep.selectColor("Yellow");

        //9. Assertions
        String[] expectedLogs = {"Colors: value changed to Yellow",
                "metal: value changed to Selen",
                "Wind: condition changed to true",
                "Water: condition changed to true"
        };
        assertStep.checkLogs(expectedLogs);

        assertStep.assertAll();
    }
}
