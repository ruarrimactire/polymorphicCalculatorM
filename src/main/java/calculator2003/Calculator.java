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
                
                
		add(display, BorderLayout.NORTH);
		display.setBackground(Color.white);
		display.setEnabled(false);
		display.setName("display");
		display.setEnabled(false);
                
                Panel buttonPanel = new Panel();
                buttonPanel.setLayout(new GridLayout(6,3));   
                add(buttonPanel, BorderLayout.CENTER);
                
                buttonPanel.add(sevenButton);
		sevenButton.addActionListener(key7Listener);
		sevenButton.setName("sevenButton");
                buttonPanel.add(eightButton);
		eightButton.addActionListener(key8Listener);
		eightButton.setName("eightButton");
                buttonPanel.add(nineButton);
		nineButton.addActionListener(key9Listener);
		nineButton.setName("nineButton");

                buttonPanel.add(fourButton);
		fourButton.addActionListener(key4Listener);
		fourButton.setName("fourButton");
                buttonPanel.add(fiveButton);
		fiveButton.addActionListener(key5Listener);
		fiveButton.setName("fiveButton");
                buttonPanel.add(sixButton);
		sixButton.addActionListener(key6Listener);
		sixButton.setName("sixButton");

                buttonPanel.add(oneButton);
		oneButton.addActionListener(key1Listener);
		oneButton.setName("oneButton");
                buttonPanel.add(twoButton);
		twoButton.addActionListener(key2Listener);
		twoButton.setName("twoButton");
		buttonPanel.add(threeButton);
		threeButton.addActionListener(key3Listener);
		threeButton.setName("threeButton");
		
		buttonPanel.add(zeroButton);
		zeroButton.addActionListener(key0Listener);
		zeroButton.setName("zeroButton");
		buttonPanel.add(plusButton);
		plusButton.addActionListener(plusListener);
		plusButton.setName("plusButton");
		buttonPanel.add(minusButton);
		minusButton.addActionListener(minusListener);
		minusButton.setName("minusButton");

                buttonPanel.add(equalsButton);
		equalsButton.addActionListener(equalsListener);
		equalsButton.setName("equalsButton");
		addWindowListener(new Closer());

		setVisible(true);
	}

	// Set up the model.
	private CalculatorModel	calculator = new CalculatorModel();
	private NumberKey	key7 = new NumberKey(calculator, 7);
	private NumberKey	key8 = new NumberKey(calculator, 8);
	private NumberKey	key9 = new NumberKey(calculator, 9);
	private NumberKey	key4 = new NumberKey(calculator, 4);
	private NumberKey	key5 = new NumberKey(calculator, 5);
	private NumberKey	key6 = new NumberKey(calculator, 6);
	private NumberKey	key1 = new NumberKey(calculator, 1);
	private NumberKey	key2 = new NumberKey(calculator, 2);
	private NumberKey	key3 = new NumberKey(calculator, 3);
	private NumberKey	key0 = new NumberKey(calculator, 0);
	private EqualsKey	equals = new EqualsKey(calculator);
	private PlusKey		plus = new PlusKey(calculator);
	private MinusKey	minus = new MinusKey(calculator);

	// Set up the GUI

        private Button sevenButton = new Button("7");
	private ActionListener key7Listener = new KeyListener(key7);
        private Button eightButton = new Button("8");
	private ActionListener key8Listener = new KeyListener(key8);
        private Button nineButton = new Button("9");
	private ActionListener key9Listener = new KeyListener(key9);

        private Button fourButton = new Button("4");
	private ActionListener key4Listener = new KeyListener(key4);
        private Button fiveButton = new Button("5");
	private ActionListener key5Listener = new KeyListener(key5);
        private Button sixButton = new Button("6");
	private ActionListener key6Listener = new KeyListener(key6);

        private Button oneButton = new Button("1");
	private ActionListener key1Listener = new KeyListener(key1);
        private Button twoButton = new Button("2");
	private ActionListener key2Listener = new KeyListener(key2);
        private Button threeButton = new Button("3");
	private ActionListener key3Listener = new KeyListener(key3);

        private Button zeroButton = new Button("0");
	private ActionListener key0Listener = new KeyListener(key0);
        private Button plusButton = new Button("+");
	private ActionListener plusListener = new KeyListener(plus);
	private Button minusButton = new Button("-");
	private ActionListener minusListener = new KeyListener(minus);

        private Button equalsButton = new Button("=");
	private ActionListener equalsListener = new KeyListener(equals);

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
