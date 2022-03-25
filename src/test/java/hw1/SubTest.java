package hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubTest extends OperationsTest{

    @DataProvider(name = "subData")
    public Object[][] createSubData() {
        return new Object[][] {
                { 8, 10, -2 },
                { 1465, 384, 1081 },
                { 189.125, 96.75, 92.375}
        };
    }

    @Test(dataProvider = "subData")
    public void subTest(double minuend, double subtrahend, double expected) {
        double actual = calculator.sub(minuend, subtrahend);
        Assert.assertEquals(actual,expected);
    }
}