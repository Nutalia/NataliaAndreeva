package hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivTest extends OperationsTest{

    @DataProvider(name = "divData")
    public Object[][] createDivData() {
        return new Object[][] {
                { 15, 3, 5 },
                { 101, 4, 25.25 },
                { 98.25, 0.5, 196.5 }
        };
    }

    @Test(dataProvider = "divData")
    public void divTest(double dividend, double divider, double expected) {
        double actual = calculator.div(dividend, divider);
        Assert.assertEquals(actual, expected);
    }
}