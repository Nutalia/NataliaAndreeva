package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeMethod;

public class OperationsTest {
    protected Calculator calculator;

    @BeforeMethod
    public void makeCalculator() {
        calculator = new Calculator();
    }
}