package mvp_calculator;
/*
 * @author Nayab Maryam
 */
import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ActionListener;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorViewTest 
{

	/**
	 * Test#01
	 * To test if the operand1 field is successfully updates when user click on some number 
	 */
	@Test
	@DisplayName("updateOp1 should correctly update operand 1 field")
	void testToUpdateOperand1successfully() 
	{
		CalculatorView obj=new CalculatorView();
		obj.updateOp1("5");
		
		assertEquals("5",obj.getOp1(),"5 should be in Operand 1 field");
				
	}
	/**
	 * Test#02
	 * To test if the operand2 field is successfully updates when user click on some number 
	 */
	@Test
	@DisplayName("updateOp2 should correctly update operand 2 field")
	void testToUpdateOperand2successfully() 
	{
		CalculatorView obj=new CalculatorView();
		obj.updateOp2("10");
		
		assertEquals("10",obj.getOp2(),"10 should be in Operand 2 field");
				
	}
	/**
	 * Test#03
	 * To test if the result field is successfully updates after calculations 
	 */
	@Test
	@DisplayName("updateResult should correctly display result text")
	void testToUpdateresultsuccessfully() 
	{
		CalculatorView obj=new CalculatorView();
		obj.updateResult("15");
		
		// Assert (ECP: valid numeric string)
	    assertEquals("15", obj.getResult(), "Result TextField should display '15'");
				
	}
	/*
	 * Test#04
	 * To test if the fields of text1 and text2 handles the operands correctly if they are empty
	 */
	@Test
    @DisplayName("View should handle empty strings safely for operands")
    void testEmptyOperands() 
	{
        CalculatorView obj = new CalculatorView();
        obj.updateOp1("");
        obj.updateOp2("");
        assertEquals("", obj.getOp1());
        assertEquals("", obj.getOp2());
    }
	/*
	 * Test#05
	 * To test if the action listener works properly
	 */
	@Test
    @DisplayName("Setting ActionListener should not throw exception")
    void testSetActionListenerDoesNotThrow() {
        CalculatorView view = new CalculatorView();
        ActionListener dummyListener = e -> {}; // simple lambda listener
        assertDoesNotThrow(() -> view.setActionListener(dummyListener));
    }
	
	

}

