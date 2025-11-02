package mvp_calculator;

/*
 * @author Tooba Nadeem
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
/*
 * @author Nayab Maryam
 * To add the @TestMehodOrder()
 */
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
class CalculatorModelTest 
{

	CalculatorModel model = new CalculatorModel(); // make an object of class under test so that we can call the
													// particular function of that class

	// ---------Addition tests-------------------
	@Test
	@Order(1)
	void fivePlusThreeShouldEqualEight() { // testing addition with positive number
		assertEquals(8, model.add(5, 3)); // assertEquals(expected,actual);
	}

	@Test
	@Order(2)
	void fivePlusMinusThreeShouldEqualTwo() { // testing addition with negative number
		assertEquals(2, model.add(5, -3));
	}

	// --------Subtraction tests-------------------
	@Test
	@Order(3)
	void threeMinusFiveShouldEqualMinusTwo() { // testing subtraction resulting in negative number
		assertEquals(-2, model.subtract(3, 5));
	}

	// ---------Multiplication tests-----------------
	@Test
	@Order(4)
	void fiveMultiplyZeroShouldEqualZero() { // testing multiplication by zero resulting in zero
		assertEquals(0, model.multiply(5, 0));
	}

	// ---------Division tests------------------------
	@Test
	@Order(5)
	void tenDivideFiveShouldEqualTwo() { // testing simple division
		assertEquals(2, model.divide(10, 5));
	}

	@Test
	@Order(6)
	void tenDivideZeroShouldEqualMinusOne() { // testing division by zero which results in undefined answer.Here
												// undefined answer is represented as a failure.Since we use -1 commonly
												// to indicate failure, the expected result is -1.
		assertEquals(-1, model.divide(10, 0), "Division by zero should return -1");
	}

	// -------------Exponentiation tests-----------------------------
	@Test
	@Order(7)
	void twoPowerThreeShouldEqualEight() { // testing simple power or exponentiation
		assertEquals(8, model.exponent(2, 3));
	}

	@Test
	@Order(8)
	void fivePowerZeroShouldEqualOne() { // testing power of Zero resulting in one
		assertEquals(1, model.exponent(5, 0));
	}

	// ----------Factorial tests-------------------------------------
	@Test
	@Order(9)
	void zeroFactorialShouldEqualOne() { // testing zero factorial
		assertEquals(1, model.factorial(0));
	}

	@Test
	@Order(10)
	void fiveFactorialShouldEqualOneTwenty() { // testing simple factorial
		assertEquals(120, model.factorial(5));
	}

	// --------Negation tests----------------------------------
	@Test
	@Order(11)
	void negationFourShouldEqualMinusFour() { // testing simple negation
		assertEquals(-4, model.negation(4));
	}
}
