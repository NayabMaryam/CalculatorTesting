package mvp_calculator;


/**
 * The Model is responsible for the business logic. It contains the core
 * functionality, such as addition.
 * 
 */
public class CalculatorModel 
{
	public int factorial(int n) 
	{
		if (n < 0) 
		{
	        throw new IllegalArgumentException("Factorial undefined for negative numbers");
	    }
		int fact = 1;
		for (int i = 1; i <= n; i++) 
		{
			fact *= i;
		}

		return fact;
	}

	public double negation(double n) 
	{
		if(n==0)
			return 0;
		else
		return (-n);
	}

	public double add(double num1, double num2) 
	{
		return (num1 + num2);
	}

	public double subtract(double num1, double num2) 
	{
		return (num1 - num2);
	}

	public double multiply(double num1, double num2) 
	{
		return (num1 * num2);
	}

	public double divide(double num1, double num2) 
	{
		if (num2 == 0) 
		{
			return -1; // Error, division by zero
		}
		return (num1 / num2);
	}

	public double exponent(double num1, double num2) 
	{
		if (num1 < 0 && num2 != Math.floor(num2)) 
		{
	        throw new ArithmeticException("Cannot raise negative base to fractional power");
	    }
		return (Math.pow(num1, num2));
	}
}
