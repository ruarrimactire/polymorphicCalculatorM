package calculator2003;


public class EqualsKey implements Key
{	public EqualsKey(CalculatorModel calc)
	{	calculator = calc;
	}

	public void hit()
	{
		calculator.operate();
	}

	private CalculatorModel calculator = null;
}