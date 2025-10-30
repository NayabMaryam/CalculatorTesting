package mvp_calculator;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/**
 * The main application class. This class creates and connects the Model, View,
 * and Presenter.
 */
public class CalculatorApp 
{

	public static void main(String args[]) 
	{
		CalculatorModel model = new CalculatorModel();
		CalculatorView view = new CalculatorView();
		CalculatorPresenter presenter = new CalculatorPresenter(model, view);

		view.setActionListener(presenter);

		// Add a WindowListener for cross button in window to close event window
		// gracefully!
		view.addWindowListener(new WindowAdapter() 
		{
			@Override
			public void windowClosing(WindowEvent e) 
			{
				System.exit(0); // Exit the application when the window is closed
			}
		});

		view.setVisible(true);
	}
}