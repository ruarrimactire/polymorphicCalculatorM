package calculator2003;

import junit.framework.*;
import junit.swingui.*;

public class CalculatorTest extends TestCase
{
	public CalculatorTest(String s)
	{
		super(s);
	}

	// declare the variables to be tested
	private CalculatorModel calculator;
	private NumberKey key5;
	private NumberKey key3;
	private EqualsKey equals;
	private PlusKey plus;

	public void setUp() // give values to the variables
	{	calculator = new CalculatorModel();
		key5 = new NumberKey(calculator, 5);
		key3 = new NumberKey(calculator, 3);
		equals = new EqualsKey(calculator);
		plus = new PlusKey(calculator);
	}

	// define your tests using the above variables.
	public void testAccumulation()
	{	key5.hit();
		key5.hit();
		key3.hit();
		assertEquals("Accumulate failure 1", 553, calculator.value());
		calculator.reset();
		key3.hit();
		key5.hit();
		assertEquals("Accumulate failure 2", 35, calculator.value());
	}

	public void testSimpleAdd()
	{	key5.hit();
		plus.hit();
		key3.hit();
		equals.hit();
		assertEquals("SimpleAddFailure", 8, calculator.value());
	}

	public void testAdd()
	{	key5.hit();
		key5.hit();
		key3.hit();

		plus.hit();

		key3.hit();
		key5.hit();

		plus.hit();
		assertEquals("Add failure", 588, calculator.value());

		key3.hit();

		equals.hit();
		assertEquals("Equals failure", 591, calculator.value());

		plus.hit();

		key5.hit();

		equals.hit();
		assertEquals("Calculation failure", 596, calculator.value());

	}

	public static void main(String [] args)
	{
		TestRunner.run(CalculatorTest.class);
	}
}

/* JUnit hints:
 *Always import as we have done here.
 *Declare your variables to be tested as class instance variables but don't
 *	initialize them.
 *Give values to the variables in setUp.
 *Start the names of your tests always with "test...".
 *Use the main we have used here with your own class name substituting for
 *	CalculatorTest as needed. Note that it the name of the class we are writng
 *	here.
 *Always use the assertion form that has a String as its first argument. There
 *	are other assertions you can make. See the JUnit documentation in the
 *	distribution.  The String will be printed if the test fails so have it
 *	explain what failed as we have here. If the test succeeds it won't appear.
 *
 *Note that if you have several such TestCases you can combine them into a
 *	suite that is run as a whole.
 *
 *You can learn a lot about Java by examining the source code of JUnit.
 */