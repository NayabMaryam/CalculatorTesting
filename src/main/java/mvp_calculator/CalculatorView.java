package mvp_calculator;


import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionListener;

/**
 * The View, responsible for the user interface. This class creates and manages
 * the AWT components (TextFields, Buttons).
 */
@SuppressWarnings("serial")
public class CalculatorView extends Frame 
{
	private TextField txtOp1;
	private TextField txtOp2;
	private TextField txtRes;

	private Button addBtn, subBtn, multiplyBtn, divideBtn, exponentBtn, negationBtn, factorialBtn,zeroBtn,
			oneBtn, twoBtn, threeBtn, fourBtn, fiveBtn, sixBtn, sevenBtn, eightBtn, nineBtn;

	public CalculatorView() 
	{
		super();

		// Set the layout for the frame
		setLayout(new FlowLayout());

		// Initialize AWT components
		txtOp1 = new TextField(10);
		txtOp2 = new TextField(10);
		txtRes = new TextField(10);
		// The result TextField should be non-editable by the user
		txtRes.setEditable(false);
		addBtn = new Button("+");
		addBtn.setActionCommand("add");
		subBtn = new Button("-");
		subBtn.setActionCommand("subtract");
		multiplyBtn = new Button("*");
		multiplyBtn.setActionCommand("multiply");
		divideBtn = new Button("/");
		divideBtn.setActionCommand("divide");
		exponentBtn = new Button("^");
		exponentBtn.setActionCommand("exponent");
		negationBtn = new Button("+/-"); // used these symbols for negation as in negation we flip the sign of the
											// number;if its a positive number , negation changes it to negative number
											// and vice versa.
		negationBtn.setActionCommand("negation");
		factorialBtn = new Button("!");
		factorialBtn.setActionCommand("factorial");
		zeroBtn = new Button("0");
		zeroBtn.setActionCommand("0");
		oneBtn = new Button("1");
		oneBtn.setActionCommand("1");
		twoBtn = new Button("2");
		twoBtn.setActionCommand("2");
		threeBtn = new Button("3");
		threeBtn.setActionCommand("3");
		fourBtn = new Button("4");
		fourBtn.setActionCommand("4");
		fiveBtn = new Button("5");
		fiveBtn.setActionCommand("5");
		sixBtn = new Button("6");
		sixBtn.setActionCommand("6");
		sevenBtn = new Button("7");
		sevenBtn.setActionCommand("7");
		eightBtn = new Button("8");
		eightBtn.setActionCommand("8");
		nineBtn = new Button("9");
		nineBtn.setActionCommand("9");

		// Add components to the frame
		add(new Label("Operand 1:"));
		add(txtOp1);
		add(new Label("Operand 2:"));
		add(txtOp2);
		add(new Label("Result:"));
		add(txtRes);
		add(addBtn);
		add(subBtn);
		add(multiplyBtn);
		add(divideBtn);
		add(exponentBtn);
		add(negationBtn);
		add(factorialBtn);
		add(zeroBtn);
		add(oneBtn);
		add(twoBtn);
		add(threeBtn);
		add(fourBtn);
		add(fiveBtn);
		add(sixBtn);
		add(sevenBtn);
		add(eightBtn);
		add(nineBtn);

		setTitle("AWT Calculator");
		setLocation(200, 200);
		setSize(300, 150);

	}

	/**
	 * Gets the text from the first operand TextField.
	 * 
	 * @return The first operand as a String.
	 */
	public String getOp1() 
	{
		return txtOp1.getText();
	}

	/**
	 * Gets the text from the second operand TextField.
	 * 
	 * @return The second operand as a String.
	 */
	public String getOp2() 
	{
		return txtOp2.getText();
	}

	/**
	 * Updates the result TextField with the given result string.
	 * 
	 * @param result The result to display.
	 */
	public void updateResult(String result) 
	{
		txtRes.setText(result);
	}
	
	/**
	 * Updates the Op1 TextField with the given input string.
	 */
	public void updateOp1(String input) 
	{
		txtOp1.setText(input);
	}
	
	/**
	 * Updates the Op2 TextField with the given input string.
	 */
	public void updateOp2(String input) 
	{
		txtOp2.setText(input);
	}


	/**
	 * Sets the ActionListener for the button.
	 * 
	 * @param al The ActionListener to be added.
	 */
	public void setActionListener(ActionListener al) 
	{
		addBtn.addActionListener(al);
		subBtn.addActionListener(al);
		multiplyBtn.addActionListener(al);
		divideBtn.addActionListener(al);
		factorialBtn.addActionListener(al);
		exponentBtn.addActionListener(al);
		negationBtn.addActionListener(al);
		zeroBtn.addActionListener(al);
		oneBtn.addActionListener(al);
		twoBtn.addActionListener(al);
		threeBtn.addActionListener(al);
		fourBtn.addActionListener(al);
		fiveBtn.addActionListener(al);
		sixBtn.addActionListener(al);
		sevenBtn.addActionListener(al);
		eightBtn.addActionListener(al);
		nineBtn.addActionListener(al);

	}
}
