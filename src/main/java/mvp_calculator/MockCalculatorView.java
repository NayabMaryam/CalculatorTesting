package mvp_calculator;
/*
 * @author Tooba Nadeem
 */

/**
 * A mock/test double implementation of CalculatorView for testing purpose. This
 * class simulates the behavior of the real View without using any GUI
 * components.
 */
@SuppressWarnings("serial")
public class MockCalculatorView extends CalculatorView {

	private String op1 = "";
	private String op2 = "";
	private String result = "";

	@Override
	public String getOp1() {
		return op1;
	}

	@Override
	public String getOp2() {
		return op2;
	}

	@Override
	public void updateOp1(String input) {
		this.op1 = input;
	}

	@Override
	public void updateOp2(String input) {
		this.op2 = input;
	}

	@Override
	public void updateResult(String result) {
		this.result = result;
	}

	/**
	 * Extra helper for tests. This lets us check what result Presenter displayed.
	 */
	public String getResult() {
		return result;
	}
}
