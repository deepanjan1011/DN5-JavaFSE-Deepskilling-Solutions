import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyCalculatorTest {

    private MyCalculator calculator;

    @Before
    public void setUp() {
        calculator = new MyCalculator();
        System.out.println("Setup: Calculator initialized.");
    }

    @After
    public void tearDown() {
        calculator = null;
        System.out.println("Teardown: Calculator destroyed.");
    }

    @Test
    public void testAdd() {
        // Arrange
        int a = 3, b = 2;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(5, result);
    }

    @Test
    public void testMultiply() {
        // Arrange
        int a = 4, b = 3;

        // Act
        int result = calculator.multiply(a, b);

        // Assert
        assertEquals(12, result);
    }
}
