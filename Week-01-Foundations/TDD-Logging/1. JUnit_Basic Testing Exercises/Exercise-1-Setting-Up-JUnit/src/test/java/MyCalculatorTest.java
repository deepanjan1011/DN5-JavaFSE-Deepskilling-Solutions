import org.junit.Test;
import static org.junit.Assert.*;

public class MyCalculatorTest {

    @Test
    public void testAdd() {
        MyCalculator calc = new MyCalculator();
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    public void testSubtract() {
        MyCalculator calc = new MyCalculator();
        assertEquals(1, calc.subtract(3, 2));
    }
}
