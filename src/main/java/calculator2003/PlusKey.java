package calculator2003;


public class PlusKey implements OperatorKey
{	public PlusKey(CalculatorModel calc)
	{	calculator = calc;
	}

	public void hit()
	{
		calculator.rememberOperator(this);
	}
	
	public int operate(int left, int right)
	{
		return left + right;
	}

	private CalculatorModel calculator = null;
}