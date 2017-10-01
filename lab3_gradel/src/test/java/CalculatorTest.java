import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("Running unit tests.");
    }

    @Test
    @DisplayName("Testing initialization.")
    void checkInitialization() {
        Calculator calculator = new Calculator();
        assertNotNull(calculator, () -> "Calculator object must not be NULL.");
    }

    @Test
    @DisplayName("Testing sum.")
    void checkSum() {
        int result   = new Calculator().calculate("23 + 34");
        int expected = 57;

        assertEquals(result, expected);
    }

    @Test
    @DisplayName("Testing subtraction.")
    void checkSubtraction() {
        int result   = new Calculator().calculate("120 - 88");
        int expected = 32;

        assertEquals(result, expected);

    }

    @Test
    @DisplayName("Testing multiplication.")
    void checkMultiplication() {
        int result   = new Calculator().calculate("17 * 3");
        int expected = 51;

        assertEquals(result, expected);

    }

    @Test
    @DisplayName("Testing division.")
    void checkDivision() {
        int result   = new Calculator().calculate("176 / 4");
        int expected = 44;

        assertEquals(result, expected);

    }

    @Test
    @DisplayName("Testing division by zero.")
    void checkDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> {
            new Calculator().calculate("1 / 0");
        });
    }

    @Test
    @DisplayName("Testing complex expression.")
    void checkComplexExpression() {
        int result   = new Calculator().calculate("2 + 3 * (34 + 2) - (3 + 6) / 3");
        int expected = 107;

        assertEquals(result, expected);
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Finished unit tests.");
    }
}