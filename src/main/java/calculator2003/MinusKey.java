/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calculator2003;


public class MinusKey implements OperatorKey
{	public MinusKey(CalculatorModel calc)
	{	calculator = calc;
	}

	public void hit()
	{
		calculator.rememberOperator(this);
	}
	
	public int operate(int left, int right)
	{
		return left - right;
	}

	private CalculatorModel calculator = null;
}
