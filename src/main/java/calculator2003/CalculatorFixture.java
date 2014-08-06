/*
 * Created on Oct 29, 2003
 *
 */
package calculator2003;

import fit.ColumnFixture;

/**
 * @author jbergin
 * this class is a simple fixture for the FIT framework (fit.c2.com)
 * to enable automated customer level testing of the model. 
 *
 */
public class CalculatorFixture extends ColumnFixture
{	CalculatorModel model = new CalculatorModel();
	OperatorKey plus = new PlusKey(model);
	OperatorKey minus = new MinusKey(model);
	EqualsKey equals = new EqualsKey(model);
	
	public int left;
	public int right;
	public OperatorKey op;
	public OperatorKey op2;
	public int third;
	
	public int simpleValue()
	{
		model.numberHit(left);
		model.rememberOperator(op);
		model.numberHit(right);
		model.operate();
		return model.value();
	}
	
	public int chainValue()
	{
		model.numberHit(left);
		model.rememberOperator(op);
		model.numberHit(right);
		model.rememberOperator(op2);
		model.numberHit(third);
		model.operate();
		return model.value();
	}
	
	// Auxiliary
	
	public Object parse (String s, Class type) throws Exception 
	{	
		if(type.equals(OperatorKey.class))
		{	if(s.equals("+"))
				return plus;
			if(s.equals("-"))
				return minus;
//			if(s.equals("*"))
//				return product;
		}
		return super.parse(s,type);
	}

}
