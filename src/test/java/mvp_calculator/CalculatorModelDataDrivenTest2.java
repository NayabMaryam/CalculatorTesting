package mvp_calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class CalculatorModelDataDrivenTest2 
{

    private final CalculatorModel model = new CalculatorModel();

    // ---------- Exponential Tests ----------
    @ParameterizedTest(name = "exponent({0}, {1}) => {2}")
    @CsvFileSource(resources = "/exponent_test_data.csv", numLinesToSkip = 1)
    void testExponential(double base, double power, String expectedStr) 
    {
        if (expectedStr.equals("EXCEPTION")) 
        {
            assertThrows(ArithmeticException.class, () -> model.exponent(base, power),
                    "Expected ArithmeticException for invalid exponent input");
        } 
        else 
        {
            double expected = Double.parseDouble(expectedStr);
            double result = model.exponent(base, power);
            assertEquals(expected, result, 0.0001);
        }
    }

    // ---------- Factorial Tests ----------
    @ParameterizedTest(name = "factorial({0}) => {1}")
    @CsvFileSource(resources = "/factorial_test_data.csv", numLinesToSkip = 1)
    void testFactorial(int n, String expectedStr) 
    {
        if (expectedStr.equals("EXCEPTION")) 
        {
            assertThrows(IllegalArgumentException.class, () -> model.factorial(n),
                    "Expected IllegalArgumentException for negative input");
        } 
        else 
        {
            int expected = Integer.parseInt(expectedStr);
            int result = model.factorial(n);
            assertEquals(expected, result);
        }
    }



    // ---------- Negation Tests ----------
    @ParameterizedTest(name = "negation({0}) = {1}")
    @CsvFileSource(resources = "/negation_test_data.csv", numLinesToSkip = 1)
    void testNegation(double num1, double expected) 
    {
        assertEquals(expected, model.negation(num1));
    }

    
}

