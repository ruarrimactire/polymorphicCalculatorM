/*
 * @(#)Calculator2003.java 1.0 03/07/30
 *
 * Responsibilities:
 *	Remembers the display value
 *  Remembers the current strategy for numeric keys
 *	Applies the current strategy when a number key is hit
 *
 *
 */
package calculator2003;

public class CalculatorModel
{
	/** Called when a number key is hit to apply the current strategy.
	 * @param value the value of the key that was hit
	 */
	public void numberHit(int value)
	{	numberStrategy.apply(value);
	}

	/** Retrieve the current display value.
	 * @return the current value of the display
	 */
	public int value()
	{	return display;
	}

	/** Change the display to an arbitrary value
	 * @param value the new value for the display
	 *
	 *	Code Smell. This should be private if it exists at all.  
	 */
	public void setDisplay(int value)
	{	display = value;
	}

	/** Save the display value so the second operand can be entered
	 * 
	 */
	public void saveValue()
	{	savedValue = display;
		display = 0;
	}

	/** Called to perform the current operation when the = key is
	 *  hit or another operator key.
	 */
	public void operate()
	{	display = operator.operate(savedValue, display);
		savedValue = 0;
		operator = new NullOperator();
	}

	/** Reset the calculator for a new computation.
	 * 
	 */
	public void reset()
	{	display = 0;
		savedValue = 0;
		operator = new NullOperator();
		numberStrategy = baseStrategy;
	}

	/** Set the number strategy back to the original. 
	 * 
	 */
	public void resetStrategy()
	{	numberStrategy = baseStrategy;
	}

	/** Called when an operator key is hit to remember the operator
	 * @param op the key that was hit.
	 */
	public void rememberOperator(OperatorKey op)
	{	operate();
		operator = op;
		numberStrategy = new SaveStrategy(baseStrategy, this);
	}

	private int display = 0;
	private int savedValue = 0;
	private OperatorKey operator = new NullOperator();
	private final NumberStrategy baseStrategy = new AccumulateStrategy(this);
	private NumberStrategy numberStrategy = baseStrategy;


	/** A 'pseudo' key representing an empty operation. This is the
	 *  initial value of the saved operator.
	 *  It implements the Null Object and Immutable design patterns. 
	 * @author jbergin
	 *
	 * Code Smell: Should be a singleton. 
	 */
	private class NullOperator implements OperatorKey
	{	
		public void hit()
		{
			// nothing
		}

		public int operate(int left, int right)
		{	return value();
		}
	}

}
