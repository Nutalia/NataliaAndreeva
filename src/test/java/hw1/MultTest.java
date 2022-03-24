package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultTest {
    Calculator calculator = new Calculator();

    @DataProvider(name = "multData")
    public Object[][] createMultData() {
        return new Object[][] {
                { 7, 3, 21 },
                { 856, 37, 31672 },
                { 184.25, 32, 5896}
        };
    }

    @Test(dataProvider = "multData")
    public void multTest(double operand1, double operand2, double expected) {
        double actual = calculator.mult(operand1, operand2);
        Assert.assertEquals(actual, expected);
    }
}
