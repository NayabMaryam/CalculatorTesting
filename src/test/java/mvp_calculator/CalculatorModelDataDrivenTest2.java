package mvp_calculator;
/*
 * @author Nayab Maryam
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

/**
 * Data-driven tests for CalculatorModel (exponential,factorial,negation)
 * Each test reads data from a CSV file.
 */
class CalculatorModelDataDrivenTest2 
{

    private final CalculatorModel model = new CalculatorModel(); //we create an object of class under test

    // ---------- Exponential Tests ----------
    //This test will run once for every line in the CSV file.
    @ParameterizedTest(name = "exponent({0}, {1}) = {2}") //for example: exponent(2, 3) = 8
    @CsvFileSource(resources = "/exponent_test_data.csv", numLinesToSkip = 1) //resources: tell JUnit to look in 'src/test/resources/add_test_data.csv'. //numLinesToSkip: skip the header line (num1,num2,expected).
    void testExponential(double num1, double num2, double expected) 
    {
        assertEquals(expected, model.exponent(num1, num2));
    }

    // ---------- Factorial Tests ----------
    @ParameterizedTest(name = "factorial({0}) = {1}") 
    @CsvFileSource(resources = "/factorial_test_data.csv", numLinesToSkip = 1) 
    void testFactorial(int num1, int expected) 
    {
        assertEquals(expected, model.factorial(num1));
    }

    // ---------- Negation Tests ----------
    @ParameterizedTest(name = "negation({0}) = {1}")
    @CsvFileSource(resources = "/negation_test_data.csv", numLinesToSkip = 1)
    void testNegation(double num1, double expected) 
    {
        assertEquals(expected, model.negation(num1));
    }

    
}

