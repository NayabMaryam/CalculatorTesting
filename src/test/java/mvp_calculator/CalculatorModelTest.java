package mvp_calculator;

/*
 * @author Tooba Nadeem
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalculatorModelTest {

	CalculatorModel model = new CalculatorModel(); // make an object of class under test so that we can call the
													// particular function of that class

	// ---------Addition tests-------------------
	@Test
	void fivePlusThreeShouldEqualEight() { // testing addition with positive number
		assertEquals(8, model.add(5, 3)); // assertEquals(expected,actual);
	}

	@Test
	void fivePlusMinusThreeShouldEqualTwo() { // testing addition with negative number
		assertEquals(2, model.add(5, -3));
	}

	// --------Subtraction tests-------------------
	@Test
	void threeMinusFiveShouldEqualMinusTwo() { // testing subtraction resulting in negative number
		assertEquals(-2, model.subtract(3, 5));
	}

	// ---------Multiplication tests-----------------
	@Test
	void fiveMultiplyZeroShouldEqualZero() { // testing multiplication by zero resulting in zero
		assertEquals(0, model.multiply(5, 0));
	}

	// ---------Division tests------------------------
	@Test
	void tenDivideFiveShouldEqualTwo() { // testing simple division
		assertEquals(2, model.divide(10, 5));
	}

	@Test
	void tenDivideZeroShouldEqualMinusOne() { // testing division by zero which results in undefined answer.Here
												// undefined answer is represented as a failure.Since we use -1 commonly
												// to indicate failure, the expected result is -1.
		assertEquals(-1, model.divide(10, 0), "Division by zero should return -1");
	}

	// -------------Exponentiation tests-----------------------------
	@Test
	void twoPowerThreeShouldEqualEight() { // testing simple power or exponentiation
		assertEquals(8, model.exponent(2, 3));
	}

	@Test
	void fivePowerZeroShouldEqualOne() { // testing power of Zero resulting in one
		assertEquals(1, model.exponent(5, 0));
	}

	// ----------Factorial tests-------------------------------------
	@Test
	void zeroFactorialShouldEqualOne() { // testing zero factorial
		assertEquals(1, model.factorial(0));
	}

	@Test
	void fiveFactorialShouldEqualOneTwenty() { // testing simple factorial
		assertEquals(120, model.factorial(5));
	}

	// --------Negation tests----------------------------------
	@Test
	void negationFourShouldEqualMinusFour() { // testing simple negation
		assertEquals(-4, model.negation(4));
	}
}
