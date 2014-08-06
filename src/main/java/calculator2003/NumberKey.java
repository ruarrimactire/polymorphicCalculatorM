package calculator2003;

public class NumberKey implements Key // Immutable
{	public NumberKey(CalculatorModel calc, int val)
	{	value = val;
		calculator = calc;
	}

	public void hit()
	{	calculator.numberHit(value);
	}

	private CalculatorModel calculator = null;
	private int value;
}

// Improvements: inner to calculatorModel, with typesafe enum for the 10 keys.