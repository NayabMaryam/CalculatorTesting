package mvp_calculator;

/*
 * @author Nayab Maryam
 */
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorAppTest 
{
	
	/*
	 * Test#01
	 * To test that our whole application is successfully opened without any exception and all components are correctly initialized
	 */
	@Test 
	@DisplayName("App should start without throwing exceptions")
	void testIsAppStartSuccessfully() 
	{
		
		 assertDoesNotThrow(() -> { //assertDoesNotThrow(...) checks that no runtime errors happen (like NullPointerException)
	            // Call main with empty arguments
	           CalculatorApp.main(new String[]{});
	        });
		
		
	}
	/*
	 * Test#02 
	 * To Test can  we create the each MVP components successfully,without errors and are they correctly linked model–view–presenter objects?
	 * 
	 */
	@Test
	@DisplayName("MVP components should initialize correctly")
	void testAppInitializesMVP() 
	{
	    CalculatorModel model = new CalculatorModel();
	    CalculatorView view = new CalculatorView();
	    CalculatorPresenter presenter = new CalculatorPresenter(model, view);

	    //asssertNotNull checks if any of these objects get null it means the initialization of classes of ailed here  
	    assertNotNull(model);
	    assertNotNull(view);
	    assertNotNull(presenter);
	}


}

