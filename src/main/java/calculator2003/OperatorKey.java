package calculator2003;

// Defines the interface for operator keys like + and *. Needed
// since the operation is delayed and not executed at "hit" time.
public interface OperatorKey extends Key
{
	public int operate(int left, int right);
}