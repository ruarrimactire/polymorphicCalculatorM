package calculator2003;


import java.awt.*;
import java.awt.event.*;

/** This is the GUI for the Calculator model
 *	For a graphical calculator use this as the main.
 *  Note that all of the compoinents here have been given names with 
 * setName. This is to enable FIT, Fitnesse, Abbot automated testing of this
 * interface. 
 */
public class Calculator extends Frame
{
	public Calculator()
	{
		super("Simple Calc");
		setName("Calculator");
		setSize(400,200);
		setBackground(Color.blue);
		setLayout(new FlowLayout());
		add(display);
		display.setBackground(Color.white);
		display.setEnabled(false);
		display.setName("display");
		display.setEnabled(false);
		add(twoButton);
		twoButton.addActionListener(key2Listener);
		twoButton.setName("twoButton");
		add(threeButton);
		threeButton.addActionListener(key3Listener);
		threeButton.setName("threeButton");
		add(fiveButton);
		fiveButton.addActionListener(key5Listener);
		fiveButton.setName("fiveButton");
		add(plusButton);
		plusButton.addActionListener(plusListener);
		plusButton.setName("plusButton");
		add(minusButton);
		minusButton.addActionListener(minusListener);
		minusButton.setName("minusButton");
		add(equalsButton);
		equalsButton.addActionListener(equalsListener);
		equalsButton.setName("equalsButton");
		addWindowListener(new Closer());

		setVisible(true);
	}

	// Set up the model.
	private CalculatorModel	calculator = new CalculatorModel();
	private NumberKey	key5 = new NumberKey(calculator, 5);
	private NumberKey	key3 = new NumberKey(calculator, 3);
	private NumberKey	key2 = new NumberKey(calculator, 2);
	private EqualsKey	equals = new EqualsKey(calculator);
	private PlusKey		plus = new PlusKey(calculator);
	private MinusKey	minus = new MinusKey(calculator);

	// Set up the GUI

	private Button fiveButton = new Button("5");
	private ActionListener key5Listener = new KeyListener(key5);
	private Button threeButton = new Button("3");
	private ActionListener key3Listener = new KeyListener(key3);
	private Button twoButton = new Button("2");
	private ActionListener key2Listener = new KeyListener(key2);
	private Button equalsButton = new Button("=");
	private ActionListener equalsListener = new KeyListener(equals);
	private Button plusButton = new Button("+");
	private ActionListener plusListener = new KeyListener(plus);
	private Button minusButton = new Button("-");
	private ActionListener minusListener = new KeyListener(minus);
	private TextField display = new TextField("0", 12);

	// Inner classes for listeners

	class KeyListener implements ActionListener
	{	KeyListener(Key key)
		{	this.key = key;
		}

		public void actionPerformed(ActionEvent e)
		{	key.hit();
			display.setText("" + calculator.value());
		}

		private Key key = null;	
	}

	class Closer extends WindowAdapter
	{	public void windowClosing(WindowEvent e)
		{	dispose();
			System.exit(0);
		}
	}
	
	public static void main(String [] args)
	{
		Calculator calc = new Calculator();
	}
}