/*
 * Created on Nov 7, 2003
 *
 */
package calculator2003;

import java.awt.*;
import fit.Fixture;
//import junit.framework.*;
import junit.extensions.abbot.*;
import abbot.script.ComponentReference;
import abbot.tester.ComponentTester;

/**
 * @author jbergin
 *
 */
public class CalculatorGuiRobotFixture extends Fixture
{
	public Calculator calc = new Calculator();

	Button button5 = null;
	Button button2 = null;
	Button button3 = null;
	Button buttonEquals = null;
	Button buttonPlus = null;
	Button buttonMinus = null;
	TextField display = null;
	ComponentTester testBasic = null;
	
	public CalculatorGuiRobotFixture() throws Exception
	{	GuiTest test = new GuiTest("Calculator");
		test.setUp();
	}
	
	class GuiTest extends ComponentTestFixture
	{	public GuiTest(String name)
		{	super(name);
		}
		
		public void setUp() throws Exception
		{
			ComponentReference ref = new ComponentReference("twoButton", Button.class, "twoButton", "2");
			button2 = (Button)getFinder().findComponent(ref);
			testBasic = new ComponentTester();//ComponentTester.getTester(Button.class);
			
			ref = new ComponentReference("threeButton", Button.class, "threeButton", "3");
			button3 = (Button)getFinder().findComponent(ref);
			
			ref = new ComponentReference("fiveButton", Button.class, "fiveButton", "5");
			button5 = (Button)getFinder().findComponent(ref);
			
			ref = new ComponentReference("equalsButton", Button.class, "equalsButton", "equals");
			buttonEquals = (Button)getFinder().findComponent(ref);
			
			ref = new ComponentReference("plusButton", Button.class, "plusButton", "plus");
			buttonPlus = (Button)getFinder().findComponent(ref);
			
			ref = new ComponentReference("minusButton", Button.class, "minusButton", "minus");
			buttonMinus = (Button)getFinder().findComponent(ref);
			
			ref = new ComponentReference("display", TextField.class);
			display = (TextField)getFinder().findComponent(ref);
			
		}
	
	}

	private int delay = 0;
	
	public void delay(int d)
	{	delay = d;
	}
	
	private void click(Button button)
	{	testBasic.actionClick(button);	
		testBasic.actionDelay(delay);
	}
	public void five() throws Exception
	{	click(button5);
	}
	public void three() throws Exception
	{	click(button3);
	}
	public void two() throws Exception
	{	click(button2);
	}
	public void equals() throws Exception
	{	click(buttonEquals);
	}
	public void plus() throws Exception
	{	click(buttonPlus);
	}
	public void minus() throws Exception
	{	click(buttonMinus);
	}
	public String value() throws Exception
	{	testBasic.actionDelay(delay);
		return display.getText();
	}

}
