package calculator2003;	/** Strategy to use (once) after an operator key is hit to make	 *  sure the display is saved and we are set up for the next value.	 *  Implements the Decorator Design Pattern, and the Immutable pattern.	 * @author jbergin	 *	 	 **/	public class SaveStrategy implements NumberStrategy // A decorator	{		public SaveStrategy(NumberStrategy decorated, CalculatorModel calc)		{	this.decorated = decorated;			calculator = calc;		}		public void apply(int value)		{	calculator.saveValue();			decorated.apply(value);			calculator.resetStrategy();		}		private NumberStrategy decorated = null;		private CalculatorModel calculator = null;	}