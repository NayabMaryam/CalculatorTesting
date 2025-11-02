package mvp_calculator;

/*
 * @author Tooba Nadeem
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.event.ActionEvent;

/**
 * Unit tests for the CalculatorPresenter class using a MockView. Tests verify
 * correct interaction between Presenter and Model via View.
 */
public class CalculatorPresenterTest {

	private CalculatorModel model;
	private MockCalculatorView view; // we are making an object of MockCalculatorView instead of making a real
										// CalculatorView object just to avoid opening of GUI windows during testing
	private CalculatorPresenter presenter;

	@BeforeEach
	void setUp() { // fresh setUp for each test case to run because the states left after previous
					// test case could fail the next one
		model = new CalculatorModel();
		view = new MockCalculatorView();
		presenter = new CalculatorPresenter(model, view);
	}

	// ---------------Addition Tests------------------------------
	@Test
	void fourPlusFiveShouldDisplayNine() { // testing addition with positive number
		view.updateOp1("4");
		view.updateOp2("5");
		presenter.actionPerformed(new ActionEvent(this, 0, "add"));

		assertEquals("9.0", view.getResult());
	}

	@Test
	void minusThreePlusSevenShouldDisplayFour() { // testing addition with negative number
		view.updateOp1("-3");
		view.updateOp2("7");
		presenter.actionPerformed(new ActionEvent(this, 0, "add"));

		assertEquals("4.0", view.getResult());
	}

	// ---------- Subtraction Tests ----------
	@Test
	void tenMinusSixShouldDisplayFour() { // testing simple subtraction
		view.updateOp1("10");
		view.updateOp2("6");
		presenter.actionPerformed(new ActionEvent(this, 0, "subtract"));

		assertEquals("4.0", view.getResult());
	}

	// ---------- Multiplication Tests ----------
	@Test
	void threeMultiplyFIveShouldDisplayFifteen() { // testing simple multiplication
		view.updateOp1("3");
		view.updateOp2("5");
		presenter.actionPerformed(new ActionEvent(this, 0, "multiply"));

		assertEquals("15.0", view.getResult());
	}

	// ---------- Division Tests ----------
	@Test
	void eightDivideFourShouldDisplayTwo() { // testing simple division
		view.updateOp1("8");
		view.updateOp2("4");
		presenter.actionPerformed(new ActionEvent(this, 0, "divide"));

		assertEquals("2.0", view.getResult());
	}

	@Test
	void eightDivideZeroShouldDisplayMinusOne() { // testing division by zero which results in undefined answer.Here
													// undefined answer is represented as a failure.Since we use -1
													// commonly to indicate failure, the expected result is -1.
		view.updateOp1("8");
		view.updateOp2("0");
		presenter.actionPerformed(new ActionEvent(this, 0, "divide"));

		assertEquals("-1.0", view.getResult());
	}

	// ---------- Exponent Tests ----------
	@Test
	void twoPowerThreeShouldDisplayEight() { // testing simple power or exponentiation
		view.updateOp1("2");
		view.updateOp2("3");
		presenter.actionPerformed(new ActionEvent(this, 0, "exponent"));

		assertEquals("8.0", view.getResult());
	}

	// ---------- Factorial Tests ----------
	@Test
	void fiveFactorialShouldDisplayOneTwenty() { // testing simple factorial
		view.updateOp1("5");
		presenter.actionPerformed(new ActionEvent(this, 0, "factorial"));

		assertEquals("120.0", view.getResult());
	}

	// ---------- Negation Tests ----------
	@Test
	void negationSixShouldDisplayMinusSix() { // testing simple negation
		view.updateOp1("6");
		presenter.actionPerformed(new ActionEvent(this, 0, "negation"));

		assertEquals("-6.0", view.getResult());
	}

	// ---------- Invalid Input Tests ----------
	@Test
	void abcPlusThreeShouldDisplayErrorMessage() { // testing invalid input in addition
		view.updateOp1("abc");
		view.updateOp2("3");
		presenter.actionPerformed(new ActionEvent(this, 0, "add"));

		assertEquals("Error: Invalid input", view.getResult());
	}
}
