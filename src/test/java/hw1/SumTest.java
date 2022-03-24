package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumTest {

    Calculator calculator = new Calculator();

    @DataProvider(name = "sumData")
    public Object[][] createLongData() {
        return new Object[][] {
                { 2, 4, 6 },
                { 5000, 1789, 6789 },
                { 10.5, 4.75, 15.25 }
        };
    }

    @Test(dataProvider="sumData")
    void sumTest(double operand1, double operand2, double expected) {
        double actual = calculator.sum(operand1, operand2);
        Assert.assertEquals(actual, expected);
    }

}
