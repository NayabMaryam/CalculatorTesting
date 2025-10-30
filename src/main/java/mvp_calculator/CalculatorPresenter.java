package mvp_calculator;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * * The Presenter, responsible for handling user input and coordinating the
 * Model * and View. It implements the ActionListener interface to respond to
 * button * clicks.
 */
public class CalculatorPresenter implements ActionListener {
	private CalculatorModel model;
	private CalculatorView view;

	public CalculatorPresenter(CalculatorModel model, CalculatorView view) {
		this.model = model;
		this.view = view;
	}

	/**
	 * * This method is called when a user action occurs (e.g., button click). It *
	 * determines which action was performed and executes the appropriate logic.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		double op1, op2, result;
		int operand;
		
		switch (e.getActionCommand()) {
		case "0":
		case "1":
		case "2":
		case "3":
		case "4":
		case "5":
		case "6":
		case "7":
		case "8":
		case "9":
			if (view.getOp1().isEmpty()) {
			    view.updateOp1(e.getActionCommand());
			}
			else {
			view.updateOp2(e.getActionCommand());
			}
			break;
		case "add":
			try {
				op1 = Double.parseDouble(view.getOp1());
				op2 = Double.parseDouble(view.getOp2());
				result = model.add(op1, op2);
				view.updateResult(String.valueOf(result));
			} catch (NumberFormatException ex) {
				view.updateResult("Error: Invalid input");
			}
			break;
		case "subtract":
			try {
				op1 = Double.parseDouble(view.getOp1());
				op2 = Double.parseDouble(view.getOp2());
				result = model.subtract(op1, op2);
				view.updateResult(String.valueOf(result));
			} catch (NumberFormatException ex) {
				view.updateResult("Error: Invalid input");
			}
			break;
		case "multiply":
			try {
				op1 = Double.parseDouble(view.getOp1());
				op2 = Double.parseDouble(view.getOp2());
				result = model.multiply(op1, op2);
				view.updateResult(String.valueOf(result));
			} catch (NumberFormatException ex) {
				view.updateResult("Error: Invalid input");
			}
			break;
		case "divide":
			try {
				op1 = Double.parseDouble(view.getOp1());
				op2 = Double.parseDouble(view.getOp2());
				result = model.divide(op1, op2);
				view.updateResult(String.valueOf(result));
			} catch (NumberFormatException ex) {
				view.updateResult("Error: Invalid input");
			}
			break;
		case "exponent":
			try {
				op1 = Double.parseDouble(view.getOp1());
				op2 = Double.parseDouble(view.getOp2());
				result = model.exponent(op1, op2);
				view.updateResult(String.valueOf(result));
			} catch (NumberFormatException ex) {
				view.updateResult("Error: Invalid input");
			}
			break;
		case "factorial":
			try {
				operand = Integer.parseInt(view.getOp1());
				result = model.factorial(operand);
				view.updateResult(String.valueOf(result));
			} catch (NumberFormatException ex) {
				view.updateResult("Error: Invalid input");
			}
			break;
		case "negation":
			try {
				op1 = Double.parseDouble(view.getOp1());
				result = model.negation(op1);
				view.updateResult(String.valueOf(result));
			} catch (NumberFormatException ex) {
				view.updateResult("Error: Invalid input");
			}
			break;
		}
	}
}
