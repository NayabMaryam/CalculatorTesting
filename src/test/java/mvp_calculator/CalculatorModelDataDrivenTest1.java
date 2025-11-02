package mvp_calculator;
/*
 * @author Tooba Nadeem
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

/**
 * Data-driven tests for CalculatorModel (add, subtract, multiply, divide)
 * Each test reads data from a CSV file.
 */
class CalculatorModelDataDrivenTest1 {

    private final CalculatorModel model = new CalculatorModel(); //we create an object of class under test

    // ---------- Addition Tests ----------
    //This test will run once for every line in the CSV file.
    @ParameterizedTest(name = "add({0}, {1}) = {2}") //for example: add(5.0, 3.0) = 8.0
    @CsvFileSource(resources = "/add_test_data.csv", numLinesToSkip = 1) //resources: tell JUnit to look in 'src/test/resources/add_test_data.csv'. //numLinesToSkip: skip the header line (num1,num2,expected).
    void testAddition(double num1, double num2, double expected) {
        assertEquals(expected, model.add(num1, num2));
    }

    // ---------- Subtraction Tests ----------
    @ParameterizedTest(name = "subtract({0}, {1}) = {2}") 
    @CsvFileSource(resources = "/subtract_test_data.csv", numLinesToSkip = 1) 
    void testSubtraction(double num1, double num2, double expected) {
        assertEquals(expected, model.subtract(num1, num2));
    }

    // ---------- Multiplication Tests ----------
    @ParameterizedTest(name = "multiply({0}, {1}) = {2}")
    @CsvFileSource(resources = "/multiply_test_data.csv", numLinesToSkip = 1)
    void testMultiplication(double num1, double num2, double expected) {
        assertEquals(expected, model.multiply(num1, num2));
    }

    // ---------- Division Tests ----------
    @ParameterizedTest(name = "divide({0}, {1}) = {2}")
    @CsvFileSource(resources = "/divide_test_data.csv", numLinesToSkip = 1)
    void testDivision(double num1, double num2, double expected) {
        assertEquals(expected, model.divide(num1, num2));
    }
}
